package com.palestra.wf.dao.impl;

import java.util.List;

import com.palestra.wf.dao.IProceso;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Proceso;
import com.palestra.wf.model.Transicion;
import com.palestra.wf.model.util.DoSomething;

public class DAOProceso implements IProceso {

	DoSomething ds;
	
	public DAOProceso() {
		ds = new DoSomething();
	}

	@Override
	public Proceso registraProceso(Proceso proceso) throws WorkFlowException {
		ds.insert(proceso);
		return proceso;
	}

	@Override
	public Proceso actualizaProceso(Proceso proceso) throws WorkFlowException {
		ds.update(proceso);
		return proceso;
	}

	@Override
	public boolean eliminarProceso(Proceso proceso) throws WorkFlowException {
		ds.remove(proceso);
		return true;
	}

	@Override
	public List<Proceso> listar() throws WorkFlowException {
		return ds.list("Proceso.findAll", Proceso.class);
	}

	@Override
	public Proceso agregarTransicion(Proceso proceso, Transicion transicion)
			throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proceso quitarTransicion(Proceso proceso, Transicion transicion)
			throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proceso asignarTransiciones(Proceso proceso,
			List<Transicion> transiciones) throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proceso desdeArchivo(String archivo) throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

}