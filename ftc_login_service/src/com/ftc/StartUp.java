package com.ftc;

import com.ftc.aspel.dao.ManejaSesion;
import com.ftc.aspel.dao.impl.ManejaSesionImpl;
import com.ftc.aspel.exception.AspelException;
import com.ftc.aspel.model.Sesion;
import com.ftc.aspel.model.Usuario;
import com.ftc.aspel.model.UsuarioDetalle;
import com.ftc.aspel.ws.UsuarioServicios;
import java.util.List;

public class StartUp {

    public static void main(String[] args) {
        try {
//            Usuario usuario = new Usuario();
//            usuario.setDsusucon("sysadmin");
//            usuario.setDsvalcon("sysadm");
//            RegistroUsuarioService ru = new RegistroUsuarioService();
//            UsuarioDetalle ud = new UsuarioDetalle();
//            ud.setDsusunom("Administrador");
//            ud.setDsusuape("Biotecsa");
//            ud.setDsusuasp("admin");
//            usuario.setUsuarioDetalle(ud);
//            ru.registraUsuario(usuario);
            ManejaSesion ms = new ManejaSesionImpl();
            String sesion = ms.iniciaSesion("sysadmin", "sysadm");
            System.out.println("Sesion: "+sesion);
            List<Sesion> sesiones = ms.listar();
            System.out.println("Sesiones activas: "+sesiones.size());
        } catch (AspelException ae) {
            ae.printStackTrace(System.out);
        }
    }

}
