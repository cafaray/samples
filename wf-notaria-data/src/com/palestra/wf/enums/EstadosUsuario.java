package com.palestra.wf.enums;

public enum EstadosUsuario {
	ACTIVO("A", "Usuario activado"),
	INACTIVO("I", "Usuario inactio"),
	SUSPENDIDO("S", "Usuario suspendido");
	
	private String codigo;
	private String descripcion;
	
	EstadosUsuario(String codigo, String descripcion){
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public String getCodigo(){
		return this.codigo;
	}
	
	public String getDescripcion(){
		return this.descripcion;
	}
}
