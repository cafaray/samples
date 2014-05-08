package com.ftc.iaspel.util;

import com.ftc.aspel.ws.SesionServicios;
import com.ftc.aspel.ws.SesionServiciosService;
import com.ftc.aspel.ws.UsuarioServicios;
import com.ftc.aspel.ws.UsuarioServiciosService;
import com.ftc.aspel.ws.WrapperUsuario;
import com.ftc.aspel.ws.WrapperUsuarioDetalle;
import java.util.List;

public class Conexion {

    private static boolean conectado = false;
    private static WrapperUsuario usuario = null;
    private static String _cuenta = null;
    private static String token = "";

    public static boolean conectar(String cuenta, String contrasenia) {
        token = iniciaSesion(cuenta, contrasenia);
        conectado = (token != null && token.length() > 0);
        if(conectado){
            _cuenta = cuenta;
            usuario = obtieneUsuarioConectado();
        }
        return conectado;
    }    
    
    private static WrapperUsuario obtieneUsuarioConectado(){        
        UsuarioServiciosService servicio = new UsuarioServiciosService();
        UsuarioServicios port = servicio.getUsuarioServiciosPort();
        List<WrapperUsuario> usuarios = port.usuariosActivos();
        for(WrapperUsuario u:usuarios){
            if (u.getDsusucon().equals(_cuenta)){
                return u;
            }
        }
        return null;
    }
    
    public static WrapperUsuarioDetalle detalleUsuario(){
        if (usuario!=null){
            return usuario.getUsuarioDetalle();
        }else{
            return null;
        }
    }
    
    public static void desconectar() {
        conectado = !cierraSesion(token);
    }

    public static WrapperUsuario getUsuario(){
        return usuario;
    }
    
    public static boolean isConectado() {
        return conectado;
    }

    public static String getToken() {
        return token;
    }

    private static String iniciaSesion(String usuario, String contrasenia) {
        SesionServiciosService servicio = new SesionServiciosService();
        SesionServicios port = servicio.getSesionServiciosPort();
        token = port.iniciarSesion(usuario, contrasenia);
        return token;
    }

    private static boolean cierraSesion(String token) {
        SesionServiciosService servicio = new SesionServiciosService();
        SesionServicios port = servicio.getSesionServiciosPort();
        return port.cierraSesion(token);
    }
    
}
