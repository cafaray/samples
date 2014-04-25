package com.palestra.wf.enums;

public enum TipoDestino {
	ACTIVIDAD("HA","Definido como otra actividad"),
	FORK_OR("FO","Definido como un FORK excluyente"),
	FORK_AND("FA","Definido como un FORK incluyente"),
	UNION_OR("UO","Definido como una UNION donde el primero que llega permite el avance"),
	UNION_AND("UA","Definido como una UNION donde dos actividades tienen que llegar para el avance");
	
	private String codigo;
	private String descripcion;
	TipoDestino(String codigo, String descripcion){
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public String getCodigo(){
		return codigo;
	}
	public String getDescripcion(){
		return descripcion;
	}
}
