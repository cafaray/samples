package com.palestra.wf.config

import java.text.SimpleDateFormat;

class Engine {
	private static Date today = new Date();
	private static SimpleDateFormat fecha = new SimpleDateFormat("dd MM yyyy HH:mm:ss")
	
	public Engine() {
		println "Engine created at " + fecha.format(today)
	}
	
	def registrarActividad(){
		//recoger los paramatros para registrar la actividad y persistirla
	}
	
	def registrarTransicion(){
		//recoger los parametros para registrar la transicion de tareas
	}

	static main(args) {
		println "Engine started at " + fecha.format(today)
		Engine e = new Engine();
	}

}
