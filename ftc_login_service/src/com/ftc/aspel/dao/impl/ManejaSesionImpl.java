package com.ftc.aspel.dao.impl;

import com.ftc.aspel.dao.ManejaSesion;
import com.ftc.aspel.dao.ManejaUsuario;
import com.ftc.aspel.exception.AspelException;
import com.ftc.aspel.model.Sesion;
import com.ftc.aspel.model.Usuario;
import com.ftc.aspel.model.UsuarioDetalle;
import com.ftc.utiles.GenerateTokens;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.TypedQuery;

public class ManejaSesionImpl implements ManejaSesion {

    private final GenericImpl generic;

    public ManejaSesionImpl() {
        generic = new GenericImpl();
    }

    @Override
    public String iniciaSesion(String cuenta, String contrasenia) throws AspelException {
        ManejaUsuario usuarios = new ManejaUsuarioImpl();
        Usuario usuario = usuarios.validaAccesoUsuario(cuenta, contrasenia);
        //String sql = "SELECT s FROM Sesion s WHERE s.idusuari = :idusuario AND s.instatus = :estatus";
        TypedQuery<Sesion> querySesion = generic.getEntityManager().createNamedQuery("Sesion.activeSession", Sesion.class);
        querySesion.setParameter("idusuario", usuario);
        Sesion sesion;
        if (querySesion.getResultList().size() > 0) {
            sesion = querySesion.getSingleResult();
            if (validaSesion(sesion)) {
                return sesion.getDstoken();
            }
        }        
        sesion = nuevaSesion(usuario);
        return sesion.getDstoken();

    }

    private Sesion nuevaSesion(Usuario usuario) throws AspelException {
        Date fecini = new Date();
        Date fecfin = calculaFechaFinSesion(fecini);

        Sesion sesion = new Sesion();
        sesion.setDtfecini(fecini);
        sesion.setDtfecfin(fecfin);
        sesion.setInstatus("A");
        sesion.setDstoken(GenerateTokens.newToken()); //asignar nuevo valor de token
        sesion.setTmstmp(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        sesion.setIdusuari(usuario);
        generic.insert(sesion);
        return sesion;
    }

    private Date calculaFechaFinSesion(Date fechaInicio) throws AspelException {
        Calendar vuelta = Calendar.getInstance();
        vuelta.setTime(fechaInicio);
        vuelta.set(Calendar.HOUR_OF_DAY, vuelta.get(Calendar.HOUR_OF_DAY) + 2);
        return vuelta.getTime();
    }

    private boolean validaSesion(Sesion sesion) throws AspelException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        //valida que la fecha de inicio sea menor o igual que hoy
        if (sesion.getDtfecini().after(new Date())) {
            return false;
            //throw new AspelException("Session date is impossible: " + dateFormat.format(sesion.getDtfecini()));
        }
        //valida la fecha de inicio vs fecha de fin
        if (sesion.getDtfecfin().before(new Date())) {
            sesion.setInstatus("C");
            generic.update(sesion);
            return false;
            //throw new AspelException("Session date is end: " + dateFormat.format(sesion.getDtfecfin()));
        }
        return true;
    }

    private Sesion recuperaSesion(String cuenta) throws AspelException {
        TypedQuery<Usuario> query = generic.getEntityManager().createNamedQuery("Usuario.findByCuenta", Usuario.class);
        query.setParameter("cuenta", cuenta);
        Usuario usuario = query.getSingleResult();
        if (usuario != null) {
            Sesion sesion = recuperaSesionActiva(usuario);
            if (sesion == null) {
                throw new AspelException(String.format("There is no active session for user %s", cuenta));
            } else {
                return sesion;
            }
        } else {
            throw new AspelException(String.format("User %s does not exists!!!", cuenta));
        }
    }

    @Override
    public void cierraSesion(String token) throws AspelException {
        Sesion sesion = recuperaSesionPorToken(token);
        if (sesion != null) {
            if (sesion.getInstatus().equals("A")) {
                sesion.setInstatus("C");
                generic.update(sesion);
            }
        } else {
            throw new AspelException("Session token does not exists.");
        }
    }

    @Override
    public UsuarioDetalle datosUsuario(String token) throws AspelException {
//        Sesion sesion = recuperaSesionPorToken(token);
//        if (sesion != null) {
//            UsuarioDetalle detalle = sesion.getUsuario().getUsuarioDetalle();
//            if (detalle != null) {
//                return detalle;
//            } else {
//                throw new AspelException("UsuarioDetalle does not exists!!!");
//            }
//        } else {
//            throw new AspelException("Session token does not exists.");
//        }
        throw new UnsupportedOperationException();
    }

    @Override
    public String sesionActiva(String cuenta) throws AspelException {
        TypedQuery<Usuario> query = generic.getEntityManager().createNamedQuery("Usuario.findByCuenta", Usuario.class);
        query.setParameter("cuenta", cuenta);
        List<Usuario> usuarios = query.getResultList();
        if (usuarios != null && usuarios.size() > 0) {
            Usuario usuario = query.getSingleResult();
            Sesion sesion = recuperaSesionActiva(usuario);            
            return sesion!=null?sesion.getDstoken():"";
        } else {
            throw new AspelException(String.format("There is no active session for user %s.", cuenta));
        }
    }

    private Sesion recuperaSesionActiva(Usuario idusuario) throws AspelException {
        TypedQuery<Sesion> query = generic.getEntityManager().createNamedQuery("Sesion.activeSession", Sesion.class);
        query.setParameter("idusuario", idusuario);
        List<Sesion> sesiones = query.getResultList();
        if (sesiones.size() > 0) {
            Sesion sesion = null;
            Iterator<Sesion> lista = sesiones.iterator();
            int x = 0;
            do {
                if (x > 0 && sesion!=null) {
                    cierraSesion(sesion.getDstoken());
                }
                sesion = lista.next();
                if(!validaSesion(sesion)){
                    cierraSesion(sesion.getDstoken());
                    sesion = null;
                }
                x++;
            } while (lista.hasNext());
            return sesion;
        } else {
            return null;
        }
    }

    @Override
    public boolean validaSesion(String token) throws AspelException {
        Sesion sesion = recuperaSesionPorToken(token);
        if (sesion != null) {
            return validaSesion(sesion);
        } else {
            throw new AspelException("Session token does not exists.");
        }
    }

    private Sesion recuperaSesionPorToken(String token) throws AspelException {
        TypedQuery<Sesion> query = generic.getEntityManager().createNamedQuery("Sesion.findByToken", Sesion.class);
        query.setParameter("token", token);
        Sesion sesion = query.getSingleResult();
        return sesion;
    }

    @Override
    public List<Sesion> listar() throws AspelException {
        TypedQuery<Sesion> query = generic.getEntityManager().createNamedQuery("Sesion.findAll",Sesion.class);
        List<Sesion> sesiones = query.getResultList();
        if (sesiones.size()>0){
            System.out.println("Si hay sesiones: "+sesiones.size());
            return sesiones;
        }
        return null;
        //return generic.listar(Sesion.class);
    }

}
