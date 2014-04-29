package com.ftc.aspel.ws;

import com.ftc.aspel.dao.ManejaUsuario;
import com.ftc.aspel.dao.impl.ManejaUsuarioImpl;
import com.ftc.aspel.exception.AspelException;
import com.ftc.aspel.model.Usuario;
import com.ftc.aspel.model.UsuarioDetalle;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class UsuarioServicios {

    public UsuarioServicios() {
    }
    
    @WebMethod
    public Usuario registraUsuario(Usuario usuario)throws AspelException{
        ManejaUsuario ru = new ManejaUsuarioImpl();
        return ru.registraUsuario(usuario);
    }
    
    @WebMethod
    public Usuario actualizaUsuario(Usuario usuario) throws AspelException {
        ManejaUsuario ru = new ManejaUsuarioImpl();        
        return ru.actualizaUsuario(usuario);
    }
    
    @WebMethod
    public Usuario activaUsuario(String cuenta)throws AspelException{
        ManejaUsuario ru = new ManejaUsuarioImpl();
        return ru.activaUsuario(cuenta);
    }
    
    @WebMethod
    public Usuario cambiaContrasenia(String cuenta, String contrasenia)throws AspelException{
        ManejaUsuario ru = new ManejaUsuarioImpl();
        return ru.cambiaContrasenia(cuenta, contrasenia);
    }
    
    @WebMethod
    public boolean suspendeUsuario(Usuario usuario) throws AspelException{
        ManejaUsuario ru = new ManejaUsuarioImpl();
        return ru.suspendeUsuario(usuario);
    }
    
    @WebMethod
    public List<Usuario> usuariosActivos()throws AspelException{
        ManejaUsuario ru = new ManejaUsuarioImpl();
        return ru.listarUsuariosActivos();
    }
    
    @WebMethod
    public List<Usuario> usuariosSuspendidos()throws AspelException{
        ManejaUsuario ru = new ManejaUsuarioImpl();
        return ru.listarUsuariosSuspendidos();
    }
    
    @WebMethod
    public List<Usuario> listado()throws AspelException{
        ManejaUsuario ru = new ManejaUsuarioImpl();
        return ru.listarUsuarios();
    }
    
}
