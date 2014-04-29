package com.ftc.aspel.dao;

import com.ftc.aspel.exception.AspelException;
import com.ftc.aspel.model.Usuario;
import com.ftc.aspel.model.UsuarioDetalle;
import java.util.List;

public interface ManejaUsuario {
    Usuario registraUsuario(Usuario usuario) throws AspelException;
    Usuario actualizaUsuario(Usuario usuario) throws AspelException;
    boolean suspendeUsuario(Usuario usuario) throws AspelException;
    Usuario activaUsuario(String cuenta) throws AspelException;
    Usuario cambiaContrasenia(String cuenta, String contrasenia) throws AspelException;
    List<Usuario> listarUsuariosActivos()throws AspelException;
    List<Usuario> listarUsuariosSuspendidos()throws AspelException;
    List<Usuario> listarUsuarios()throws AspelException;
    
}
