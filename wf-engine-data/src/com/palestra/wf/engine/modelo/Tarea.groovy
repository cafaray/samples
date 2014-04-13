package com.palestra.wf.engine.modelo

import com.palestra.wf.modelo.Actividad;
import com.palestra.wf.modelo.Parametro;

class Tarea {

	def String identificador
	def Actividad actividad
	def Map<Parametro, Object> parametros
	def String status // pendiente | ejecutado | cancelado
	
	public Tarea() {}

}
