package com.palestra.groovy.util

import com.mysql.jdbc.PreparedStatement;

import groovy.sql.Sql;

class Conexion {

	static def getSql(){
		def sql = Sql.newInstance( 'jdbc:mysql://localhost:3306/test', 'root', 'cfar21MySql', 'com.mysql.jdbc.Driver' )
		sql
	}
	
}
