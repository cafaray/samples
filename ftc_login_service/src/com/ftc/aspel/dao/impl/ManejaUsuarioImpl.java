package com.ftc.aspel.dao.impl;

import com.ftc.aspel.dao.ManejaUsuario;
import com.ftc.aspel.exception.AspelException;
import com.ftc.aspel.model.Usuario;
import com.ftc.utiles.GenerateTokens;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import javax.persistence.TypedQuery;

public class ManejaUsuarioImpl implements ManejaUsuario {

    private final GenericImpl g;

    public ManejaUsuarioImpl() {
        g = new GenericImpl();
    }

    @Override
    public Usuario registraUsuario(Usuario usuario) throws AspelException {
        if (usuario.getUsuarioDetalle() != null) {
            usuario.setInstatus("A");
            usuario.setTmstmp(new Timestamp(Calendar.getInstance().getTimeInMillis()));
            usuario.setDsvalcon(GenerateTokens.passValue(usuario.getDsvalcon()));
            usuario.getUsuarioDetalle().setTmstmp(new Timestamp(Calendar.getInstance().getTimeInMillis()));
            usuario.getUsuarioDetalle().setIdusuari(usuario);
            return (Usuario) g.insert(usuario);
        } else {
            throw new AspelException("The detailed user information can not be null.");
        }
    }

    @Override
    public Usuario actualizaUsuario(Usuario usuario) throws AspelException {
        //No se puede suspender a un usuario por este medio.
        usuario.setInstatus("A");
        usuario.setDsvalcon(GenerateTokens.passValue(usuario.getDsvalcon()));
        return (Usuario) g.update(usuario);
    }

    @Override
    public boolean suspendeUsuario(Usuario usuario) throws AspelException {
        usuario.setInstatus("S");
        g.update(usuario);
        return true;
    }

    @Override
    public Usuario activaUsuario(String cuenta) throws AspelException {
        TypedQuery<Usuario> query = g.getEntityManager().createNamedQuery("Usuario.findByCuenta", Usuario.class);
        query.setParameter("cuenta", cuenta);
        Usuario usuario = query.getSingleResult();
        usuario.setInstatus("A");
        return (Usuario) g.update(usuario);
    }

    @Override
    public Usuario cambiaContrasenia(String cuenta, String contrasenia) throws AspelException {
        TypedQuery<Usuario> query = g.getEntityManager().createNamedQuery("Usuario.findByCuenta", Usuario.class);
        query.setParameter("cuenta", cuenta);
        Usuario usuario = query.getSingleResult();
        usuario.setInstatus("A");
        usuario.setDsvalcon(GenerateTokens.passValue(contrasenia));
        return (Usuario) g.update(usuario);
    }

    @Override
    public List<Usuario> listarUsuariosActivos() throws AspelException {
        TypedQuery<Usuario> query = g.getEntityManager().createNamedQuery("Usuario.activeUsers", Usuario.class);
        return query.getResultList();
    }

    @Override
    public List<Usuario> listarUsuariosSuspendidos() throws AspelException {
        TypedQuery<Usuario> query = g.getEntityManager().createNamedQuery("Usuario.suspendUsers", Usuario.class);
        return query.getResultList();
    }

    @Override
    public List<Usuario> listarUsuarios() throws AspelException {
        TypedQuery<Usuario> query = g.getEntityManager().createNamedQuery("Usuario.findAll", Usuario.class);
        return query.getResultList();
    }

}
