package com.palestra.wf.enums;

public enum EstatusPublicacion {
	PUBLICADO("P","El elemento ha sido publicado"),
	VERSIONADO("V","El elemento es una version no publicada"),
	NUEVO("N","Es un elemento nuevo y no hay version ni esta publicado"),
	DESPUBLICADA("D","Se reemplazo por una nueva publicacion.");
	
	private String codigo;
	private String descripcion;
	
	private EstatusPublicacion(String codigo, String descripcion) {	
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
