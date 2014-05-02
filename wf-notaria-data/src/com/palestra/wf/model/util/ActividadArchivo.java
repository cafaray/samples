package com.palestra.wf.model.util;

import java.util.List;

import com.palestra.wf.model.Actividad;
import com.palestra.wf.model.Parametro;

public class ActividadArchivo {

	private Actividad actividad;
	private List<Parametro> parametros;
	
	public ActividadArchivo() {}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public List<Parametro> getParametros() {
		return parametros;
	}

	public void setParametros(List<Parametro> parametros) {
		this.parametros = parametros;
	}

}
