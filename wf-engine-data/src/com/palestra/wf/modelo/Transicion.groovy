package com.palestra.wf.modelo

import com.palestra.wf.enums.TipoDestino

class Transicion {

	def String identificador
	def Actividad origen
	def TipoDestino tipoDestino
	def List<TransicionDestino> destinos
	
	public Transicion() {}

}
