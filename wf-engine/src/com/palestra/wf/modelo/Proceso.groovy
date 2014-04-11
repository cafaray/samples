package com.palestra.wf.modelo

class Proceso {

	def String identificador
	def List<Transicion> transiciones
	def String archivo //solo si existe un archivo de configuracion
	public Proceso() {}

}
