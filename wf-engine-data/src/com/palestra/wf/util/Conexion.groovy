package com.palestra.wf.util

import java.sql.SQLException;
import groovy.sql.Sql;

class Conexion {

	private static List<Sql> connections = null
	private static int actual = 0
	private final static int MAX_CONNECTIONS = 30
	private static String server, database, user, password

	static def getConecction() throws SQLException {
		return putConnection()
	}
	
	private static def putConnection(){
		if (connections == null) {
			readParameters()
			if(server.length()>0){
				connections = new ArrayList<Sql>()
			}else{
				throw new Exception("The connection file was not load, review configuration system.")
			}
		}else{
			if (connections.size()<MAX_CONNECTIONS) {
				def connection = Sql.newInstance('jdbc:mysql://'+server, user,password,'com.mysql.jdbc.Driver')
				connections.add(connection)
				return connection
			}else{
				throw new Exception("The limit was exceeded, it is no possible to get new instance")
			}
		}
	}
	
	static def freeConnection(Sql connection){
		closeConnection(connection)
		connections.remove(connection)
	}
	
	private static def readParameters(){
		//obtiene variables del archivo de configuracion
		Properties props = new Properties();
		props.load(new InputStreamReader(new File("/devpal/.wf/.config")))
		server = props['server']
		database = props['server']
		user = props['server']
		password = props['password']
		props.close()
	}
	
	private static def closeConnection(Sql connection){
		if (!connection.isClose()) {
			connection.close()
		}
	}
}
