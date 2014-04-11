package com.palestra.wf.engine

import com.palestra.wf.modelo.FlujoTrabajo;
import com.palestra.wf.modelo.Actividad;
import com.palestra.wf.modelo.Parametro;

class ArranqueFlujo {

	def String identificador
	def FlujoTrabajo flujo
	def Actividad actividadInicio
	def List<Parametro> parametros  //valores de tramite, sesion, usuario, expediente
	
	public ArranqueFlujo() {}

}
