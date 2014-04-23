package com.palestra.wf.enums;

public enum TipoDestino {
	ACTIVIDAD("Definido como otra actividad"),
	FORK_OR("Definido como un FORK excluyente"),
	FORK_AND("Definido como un FORK incluyente"),
	UNION_OR("Definido como una UNION donde el primero que llega permite el avance"),
	UNION_AND("Definido como una UNION donde dos actividades tienen que llegar para el avance");
	
	private String descripcion;
	TipoDestino(String descripcion){
		this.descripcion = descripcion;
	}
	
	public String getDescripcion(){
		return descripcion;
	}
}
