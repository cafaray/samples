package com.palestra.wf.dao.impl

import groovy.sql.Sql;

import com.palestra.wf.dao.IActividad;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.modelo.Actividad;
import com.palestra.wf.modelo.Parametro;
import com.palestra.wf.modelo.Transicion;
import com.palestra.wf.modelo.TransicionDestino;
import com.palestra.wf.util.Conexion;

class DAOActividad implements IActividad {

	public Actividad registraActividad(Actividad actividad)
			throws WorkFlowException {

		return actividad;
	}

	public Actividad actualizaActividad(Actividad actividad)
			throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean eliminarActividad(Actividad actividad)
			throws WorkFlowException {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Actividad> listar() throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

	public Transicion asignarDestino(Actividad destino,
			List<Parametro> parametro) throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

	public Transicion quitarDestino(Actividad destino) throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

	public Transicion asignarDestinos(List<TransicionDestino> destinos)
			throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
