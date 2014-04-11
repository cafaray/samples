package com.palestra.wf.modelo

import java.util.List;

class TransicionDestino {

	def String identificador
	def List<Actividad> destinos
	def List<Integer> registros
	def List<Parametro> parametros 
	
	public TransicionDestino() {}
	

}
