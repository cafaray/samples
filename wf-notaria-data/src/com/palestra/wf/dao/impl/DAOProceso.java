package com.palestra.wf.dao.impl;

import java.util.List;

import com.palestra.wf.dao.IProceso;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Proceso;
import com.palestra.wf.model.ProcesoTransiciones;
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
		ProcesoTransiciones pt = new ProcesoTransiciones();
		pt.setProceso(proceso);
		pt.setTransicion(transicion);
		ds.insert(pt);
		return proceso;
	}

	@Override
	public Proceso quitarTransicion(Proceso proceso, Transicion transicion)
			throws WorkFlowException {
		ProcesoTransiciones pt = new ProcesoTransiciones();
		pt.setProceso(proceso);
		pt.setTransicion(transicion);
		ds.remove(pt);
		return proceso;
	}

	@Override
	public Proceso asignarTransiciones(Proceso proceso,
			List<Transicion> transiciones) throws WorkFlowException {
		for(Transicion transicion:transiciones){
			agregarTransicion(proceso, transicion);
		}
		return proceso;
	}

	@Override
	public Proceso desdeArchivo(String archivo) throws WorkFlowException {
		throw new UnsupportedOperationException();
	}

}
