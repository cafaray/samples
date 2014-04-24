package com.palestra.wf.dao.impl;

import java.util.List;

import com.palestra.wf.dao.IParametro;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Parametro;
import com.palestra.wf.model.util.DoSomething;

public class DAOParametro implements IParametro {

	DoSomething ds;
	
	public DAOParametro() {
		ds = new DoSomething();
	}

	@Override
	public Parametro registraParametro(Parametro parametro)
			throws WorkFlowException {
		ds.insert(parametro);
		return parametro;
	}

	@Override
	public Parametro actualizaParametro(Parametro parametro)
			throws WorkFlowException {
		ds.update(parametro);
		return parametro;
	}

	@Override
	public boolean eliminaParametro(Parametro parametro)
			throws WorkFlowException {
		ds.remove(parametro);
		return true;
	}

	@Override
	public List<Parametro> listar() throws WorkFlowException {
		return ds.list("Parametro.findAll", Parametro.class);
	}

}
