package com.palestra.groovy

import com.palestra.groovy.util.Conexion;

class Persona {
	static def getPersonas() {
		def personas = []
		def sql = Conexion.getSql()
		sql.eachRow("SELECT identificador, CONCAT(nombre, ' ', apellidos) nombre, rfc FROM persona;") {
			personas << it.toRowResult()
		}
		personas
	}
	static def getPersonas(nombre) {
		def personas = []
		def sql = Conexion.getSql()
		sql.eachRow("SELECT identificador, CONCAT(nombre, ' ', apellidos) nombre, rfc FROM persona WHERE nombre = ${nombre};") {
			personas << it.toRowResult()
		}
		personas
	}
}
