package com.ftc.aspel.dao;

import com.ftc.aspel.exception.AspelException;
import com.ftc.aspel.model.Sesion;
import com.ftc.aspel.model.UsuarioDetalle;
import java.util.List;

public interface ManejaSesion {

    String iniciaSesion(String cuenta, String contrasenia) throws AspelException;

    void cierraSesion(String token) throws AspelException;

    UsuarioDetalle datosUsuario(String token) throws AspelException;

    String sesionActiva(String cuenta) throws AspelException;

    boolean validaSesion(String token) throws AspelException;

    List<Sesion> listar() throws AspelException;
}
