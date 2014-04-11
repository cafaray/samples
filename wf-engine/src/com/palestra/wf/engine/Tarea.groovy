package com.palestra.wf.engine

import com.palestra.wf.modelo.Actividad;
import com.palestra.wf.modelo.Parametro;

class Tarea {

	def String idArranqueFlujo
	def Actividad actividadActual
	def Map<Parametro, Object> parametros
	def String status // pendiente | ejecutado | cancelado
	
	public Tarea() {}

}
