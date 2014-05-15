package com.ftc.aspel.ws;

import com.ftc.aspel.dao.ManejaSesion;
import com.ftc.aspel.dao.impl.ManejaSesionImpl;
import com.ftc.aspel.exception.AspelException;
import com.ftc.aspel.model.Sesion;
import com.ftc.aspel.model.UsuarioDetalle;
import com.ftc.aspel.ws.util.WrapperSesion;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class SesionServicios {

    @WebMethod
    public String iniciarSesion(String cuenta, String contrasenia) {
        try {                       
            ManejaSesion sesion = new ManejaSesionImpl();
            String token = sesion.sesionActiva(cuenta);
            if (token.length() > 0) {
                return token;
            } else {
                token = sesion.iniciaSesion(cuenta, contrasenia);
                if (token == null) {                                    
                    System.out.println("I can not start session.");
                }
            }
            return token;
        } catch (AspelException e) {
            System.out.println("I can not start session. AspelException ocurred: "+ e.getMessage());
            return null;
            //throw new AspelException("I can not start session.");
        }
    }

    @WebMethod
    public boolean cierraSesion(String token) {
        ManejaSesion sesion = new ManejaSesionImpl();
        try {
            sesion.cierraSesion(token);
        } catch (AspelException ex) {
            Logger.getLogger(SesionServicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @WebMethod
    public UsuarioDetalle datosUsuario(String token) {
        ManejaSesion sesion = new ManejaSesionImpl();
        try {
            return sesion.datosUsuario(token);
        } catch (AspelException ex) {
            Logger.getLogger(SesionServicios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @WebMethod
    public List<WrapperSesion> sesiones() {
        ManejaSesion ms = new ManejaSesionImpl();        
        try {       
            List<Sesion> lista = ms.listar();
            List<WrapperSesion> vuelta = new ArrayList<WrapperSesion>();
            for(Sesion sesion:lista){
                vuelta.add(new WrapperSesion(sesion));
            }
            return vuelta;
            //return ms.listar();
        } catch (AspelException ex) {
            Logger.getLogger(SesionServicios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
