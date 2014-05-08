package com.ftc.aspel.ws.util;

import com.ftc.aspel.model.Usuario;

public class WrapperUsuario {
    
    private int idusucon;
    private String dsusucon;
    private String dsvalcon;
    private String instatus;
    private WrapperUsuarioDetalle usuarioDetalle;
    
    public WrapperUsuario(){}
    public WrapperUsuario(Usuario usuario){
        this.idusucon = usuario.getIdusucon();
        this.dsusucon = usuario.getDsusucon();
        this.dsvalcon = usuario.getDsvalcon();
        this.instatus = usuario.getInstatus();   
        usuarioDetalle = new WrapperUsuarioDetalle(usuario.getUsuarioDetalle());
    }

    public int getIdusucon() {
        return idusucon;
    }

    public void setIdusucon(int idusucon) {
        this.idusucon = idusucon;
    }

    public String getDsusucon() {
        return dsusucon;
    }

    public void setDsusucon(String dsusucon) {
        this.dsusucon = dsusucon;
    }

    public String getDsvalcon() {
        return dsvalcon;
    }

    public void setDsvalcon(String dsvalcon) {
        this.dsvalcon = dsvalcon;
    }

    public String getInstatus() {
        return instatus;
    }

    public void setInstatus(String instatus) {
        this.instatus = instatus;
    }

    public WrapperUsuarioDetalle getUsuarioDetalle() {
        return usuarioDetalle;
    }

    public void setUsuarioDetalle(WrapperUsuarioDetalle usuarioDetalle) {
        this.usuarioDetalle = usuarioDetalle;
    }
}
