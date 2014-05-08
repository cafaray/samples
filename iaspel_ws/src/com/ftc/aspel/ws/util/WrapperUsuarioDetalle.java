package com.ftc.aspel.ws.util;

import com.ftc.aspel.model.UsuarioDetalle;

public class WrapperUsuarioDetalle {
    
    private int idusudet;
    private String dsusunom;
    private String dsusuape;
    private String dsusuasp;    
    
    public WrapperUsuarioDetalle(){}
    public WrapperUsuarioDetalle(UsuarioDetalle usuarioDetalle){
        this.idusudet = usuarioDetalle.getIdusudet();
        this.dsusunom = usuarioDetalle.getDsusunom() ;
        this.dsusuape = usuarioDetalle.getDsusuape();
        this.dsusuasp = usuarioDetalle.getDsusuasp();
    }

    public int getIdusudet() {
        return idusudet;
    }

    public void setIdusudet(int idusudet) {
        this.idusudet = idusudet;
    }

    public String getDsusunom() {
        return dsusunom;
    }

    public void setDsusunom(String dsusunom) {
        this.dsusunom = dsusunom;
    }

    public String getDsusuape() {
        return dsusuape;
    }

    public void setDsusuape(String dsusuape) {
        this.dsusuape = dsusuape;
    }

    public String getDsusuasp() {
        return dsusuasp;
    }

    public void setDsusuasp(String dsusuasp) {
        this.dsusuasp = dsusuasp;
    }
}
