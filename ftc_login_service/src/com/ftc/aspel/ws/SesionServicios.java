package com.ftc.aspel.ws;

import com.ftc.aspel.dao.ManejaSesion;
import com.ftc.aspel.dao.impl.ManejaSesionImpl;
import com.ftc.aspel.exception.AspelException;
import com.ftc.aspel.model.Sesion;
import com.ftc.aspel.model.UsuarioDetalle;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class SesionServicios {

    public SesionServicios() {
    }

    @WebMethod
    public String iniciarSesion(String cuenta, String contrasenia) throws AspelException {

        ManejaSesion sesion = new ManejaSesionImpl();

        String token = "";
        token = sesion.sesionActiva(cuenta);
        if (token.length() > 0) {
            return token;
        } else {
            token = sesion.iniciaSesion(cuenta, contrasenia);

            if (token != null) {
                return token;
            } else {
                throw new AspelException("I can not start session.");
            }
        }
    }

    @WebMethod
    public boolean cierraSesion(String token) throws AspelException {
        ManejaSesion sesion = new ManejaSesionImpl();
        sesion.cierraSesion(token);
        return true;
    }

    @WebMethod
    public UsuarioDetalle datosUsuario(String token) throws AspelException {
        ManejaSesion sesion = new ManejaSesionImpl();
        return sesion.datosUsuario(token);
    }

    @WebMethod
    public List<Sesion> sesiones()throws AspelException{
        ManejaSesion ms = new ManejaSesionImpl();
        return ms.listar();
    }
    
}
