package com.ftc.iaspel.enums;

public enum TipoUsuario {
    ADMINISTRADOR("admin","Administrador de iaspel"),
    USUARIO_COMPRAS("ucomp","Usuario de compras"),
    USUARIO_VENTAS("uvent","Usuario de ventas"),
    USUARIO_REPORTES("urept","Usuario que solo ve los reportes"),
    SUPER_USUARIO("usudo","Usuario que ve todo excepto gestion de usuarios");
    
    TipoUsuario(String codigo, String descripcion){
        this.codigo = codigo;
        this.descripcion = descripcion;
    }
    
    private String getCodigo(){
        return this.codigo;
    }
    
    private String getDescripcion(){
        return this.descripcion;
    }
    
    private String codigo;
    private String descripcion;
}
