package com.palestra.wf.modelo

class FlujoTrabajo {

	def String identificador
	def String descripcion
	def List<Proceso> procesos
	def int version
	def boolean publicada
	def fechaInicio
	def fechaTermino
	def String estatus

	
	
	public FlujoTrabajo() {	}

	def boolean flujosActivos(){}
	
}
