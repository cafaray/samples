package com.ftc.iaspel;

import com.ftc.aspel.ws.SesionServicios;
import com.ftc.aspel.ws.UsuarioServicios;
import javax.xml.ws.Endpoint;

public class StartUp {

    public static void main(String[] args) {
        SesionServicios sesion = new SesionServicios();
        Endpoint.publish("http://localhost:7070/iaspel/sesionServicios", sesion);

        UsuarioServicios usuario = new UsuarioServicios();
        Endpoint.publish("http://localhost:7070/iaspel/usuarioServicios", usuario);
    }
    
}
