package com.palestra.wf.enums;

public enum EstatusTramite {
	ABIERTO("A", "Abierto"),
	CERRADO("T", "Cerrado"),
	CANCELADO("C", "Cancelado"),
	PENDIENTE("P","Pendiente");
	
	private String codigo;
	private String descripcion;
	
	private EstatusTramite(String codigo, String descripcion) {
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
