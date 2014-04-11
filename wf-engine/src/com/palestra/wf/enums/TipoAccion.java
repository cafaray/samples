package com.palestra.wf.enums;

public enum TipoAccion {
	ACTIVIDAD("Intervencion humana"),
	SERVICIO("Servicio que se ejecuta sin intervencion del usuario"),
	MENSAJE("Mensaje enviado a traves de la aplicacion"),
	PAUSA("Se detine la actividad hasta que reinicia la actividad"),
	REINICIO("Solo se puede ejecutar cuando se ha pausado el proceso");
	
	private String descripcion; 
	
	TipoAccion(String descripcion){
		this.descripcion = descripcion;
	}
	
	public String getDescripcion(){
		return descripcion;
	}
	
}
