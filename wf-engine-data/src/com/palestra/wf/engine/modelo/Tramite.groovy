package com.palestra.wf.engine.modelo

import com.palestra.wf.modelo.FlujoTrabajo;
import com.palestra.wf.modelo.Actividad;
import com.palestra.wf.modelo.Parametro;

class Tramite {

	def String identificador
	def FlujoTrabajo flujo
	def String idTramite
	def String idusuario
	def String idsesion
	def String ststus
	def List<Tarea> tareas
	 
	public Tramite() {}

}
