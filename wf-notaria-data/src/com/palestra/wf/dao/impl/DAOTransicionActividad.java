package com.palestra.wf.dao.impl;

import java.util.List;

import com.palestra.wf.dao.ITransicionActividad;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.TransicionActividad;
import com.palestra.wf.model.util.DoSomething;

public class DAOTransicionActividad implements ITransicionActividad {

	private DoSomething ds;
	
	public DAOTransicionActividad() {
		ds = new DoSomething();
	}

	@Override
	public TransicionActividad registraTransicionActividad(
			TransicionActividad transicionActividad) throws WorkFlowException {
		ds.insert(transicionActividad);
		return transicionActividad;
	}

	@Override
	public TransicionActividad actualizaTransicion(
			TransicionActividad transicionActividad) throws WorkFlowException {
		ds.update(transicionActividad);
		return transicionActividad;
	}

	@Override
	public boolean eliminaTransicion(TransicionActividad transicionActividad)
			throws WorkFlowException {
		ds.remove(transicionActividad);
		return true;
	}

	@Override
	public List<TransicionActividad> lista() throws WorkFlowException {		
		return ds.list("TransicionActividad.findAll", TransicionActividad.class);
	}

}
