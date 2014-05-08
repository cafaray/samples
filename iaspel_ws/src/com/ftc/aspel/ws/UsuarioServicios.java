package com.ftc.aspel.ws;

import com.ftc.aspel.dao.ManejaUsuario;
import com.ftc.aspel.dao.impl.ManejaUsuarioImpl;
import com.ftc.aspel.exception.AspelException;
import com.ftc.aspel.model.Usuario;
import com.ftc.aspel.ws.util.WrapperUsuario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class UsuarioServicios {

    public UsuarioServicios() {
    }

    @WebMethod
    public Usuario registraUsuario(Usuario usuario)  {
        try {
            ManejaUsuario ru = new ManejaUsuarioImpl();
            return ru.registraUsuario(usuario);
        } catch (AspelException ex) {
            Logger.getLogger(UsuarioServicios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @WebMethod
    public Usuario actualizaUsuario(Usuario usuario)  {
        try {
            ManejaUsuario ru = new ManejaUsuarioImpl();
            return ru.actualizaUsuario(usuario);
        } catch (AspelException ex) {
            Logger.getLogger(UsuarioServicios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @WebMethod
    public Usuario activaUsuario(String cuenta)  {
        try {
            ManejaUsuario ru = new ManejaUsuarioImpl();
            return ru.activaUsuario(cuenta);
        } catch (AspelException ex) {
            Logger.getLogger(UsuarioServicios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @WebMethod
    public Usuario cambiaContrasenia(String cuenta, String contrasenia)  {
        try {
            ManejaUsuario ru = new ManejaUsuarioImpl();
            return ru.cambiaContrasenia(cuenta, contrasenia);
        } catch (AspelException ex) {
            Logger.getLogger(UsuarioServicios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @WebMethod
    public boolean suspendeUsuario(Usuario usuario)  {
        try {
            ManejaUsuario ru = new ManejaUsuarioImpl();
            return ru.suspendeUsuario(usuario);
        } catch (AspelException ex) {
            Logger.getLogger(UsuarioServicios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @WebMethod
    public List<WrapperUsuario> usuariosActivos()  {
        try {
            ManejaUsuario ru = new ManejaUsuarioImpl();
            List<Usuario> lista = ru.listarUsuariosActivos();
            List<WrapperUsuario> usuarios = new ArrayList<WrapperUsuario>();
            for(Usuario usuario:lista){
                usuarios.add(new WrapperUsuario(usuario));
            }
            return usuarios;
        } catch (AspelException ex) {
            Logger.getLogger(UsuarioServicios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @WebMethod
    public List<WrapperUsuario> usuariosSuspendidos()  {
        try {
            ManejaUsuario ru = new ManejaUsuarioImpl();
            List<Usuario> lista = ru.listarUsuariosSuspendidos();
            List<WrapperUsuario> usuarios = new ArrayList<WrapperUsuario>();
            for(Usuario usuario:lista){
                usuarios.add(new WrapperUsuario(usuario));
            }
            return usuarios;
        } catch (AspelException ex) {
            Logger.getLogger(UsuarioServicios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @WebMethod
    public List<WrapperUsuario> listado()  {
        try {
            ManejaUsuario ru = new ManejaUsuarioImpl();
            List<Usuario> lista = ru.listarUsuarios();
            List<WrapperUsuario> usuarios = new ArrayList<WrapperUsuario>();
            for(Usuario usuario:lista){
                usuarios.add(new WrapperUsuario(usuario));
            }
            return usuarios;
        } catch (AspelException ex) {
            Logger.getLogger(UsuarioServicios.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
    
}
