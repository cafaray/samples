package com.palestra.wf.engine

import java.text.SimpleDateFormat;
import java.util.Date;

class WFEngine {

	private static Date today = new Date();
	private static SimpleDateFormat fecha = new SimpleDateFormat("dd MM yyyy HH:mm:ss")
	
	public WFEngine(){
		println "Engine created at " + fecha.format(today)
	}
	
	static main(args) {
		println "Engine started at " + fecha.format(today)
		WFEngine e = new WFEngine();
	}

}
