package com.palestra.wf.dao.impl;

import java.util.List;

import com.palestra.wf.dao.ITransicion;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Transicion;
import com.palestra.wf.model.util.DoSomething;

public class DAOTransicion implements ITransicion {

	private DoSomething ds;
	
	public DAOTransicion() {
		ds = new DoSomething();
	}

	@Override
	public Transicion registraTransicion(Transicion transicion)
			throws WorkFlowException {
		ds.insert(transicion);
		return transicion;
	}

	@Override
	public Transicion actualizaTransicion(Transicion transicion)
			throws WorkFlowException {
		ds.update(transicion);
		return transicion;
	}

	@Override
	public boolean eliminaTransicion(Transicion transicion)
			throws WorkFlowException {
		ds.remove(transicion);
		return true;
	}

	@Override
	public List<Transicion> lista() throws WorkFlowException {		
		return ds.list("Transicion.findAll", Transicion.class);
	}
	
}
