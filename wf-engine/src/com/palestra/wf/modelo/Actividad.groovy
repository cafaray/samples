package com.palestra.wf.modelo

import com.palestra.wf.enums.TipoAccion;
import com.palestra.wf.enums.TipoDestino;

class Actividad {

	def String proceso
	def int version
	
	def String identificador
	def String nombre
	def String tarea
	def List<Parametro> parametros
	def List<Rol> roles
	def List<Usuario> usuarios
	def TipoAccion tipoAccion //manual | servicio | mensaje | pausa 
	def tiempoEstandar
	def tiempoLimite
	
	public Actividad() {}

	public String getIdentificador(){
		return proceso+'.'+tarea
	}
	
}
