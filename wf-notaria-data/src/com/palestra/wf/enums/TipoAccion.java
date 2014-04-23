package com.palestra.wf.enums;

public enum TipoAccion {
	ACTIVIDAD("HA","Intervencion humana"),
	SERVICIO("SV","Servicio que se ejecuta sin intervencion del usuario"),
	MENSAJE("MS","Mensaje enviado a traves de la aplicacion"),
	PAUSA("WT","Se detine la actividad hasta que reinicia la actividad"),
	REINICIO("RS","Solo se puede ejecutar cuando se ha pausado el proceso");
	
	private String descripcion;
	private String codigo;
	
	TipoAccion(String codigo, String descripcion){
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	
	public String getDescripcion(){
		return descripcion;
	}
	
	public String getCodigo(){
		return codigo;
	}
}
