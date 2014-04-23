package com.palestra.wf.dao.impl;

import java.util.List;

import com.palestra.wf.dao.IActividad;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Actividad;
import com.palestra.wf.model.Parametro;
import com.palestra.wf.model.Transicion;
import com.palestra.wf.model.TransicionDestino;
import com.palestra.wf.model.util.DoSomething;

public class DAOActividad implements IActividad{
	DoSomething ds; 
	
	public DAOActividad() {
		ds = new DoSomething();
	}

	@Override
	public Actividad registraActividad(Actividad actividad)
			throws WorkFlowException {
		ds.insert(actividad);
		return actividad;
	}

	@Override
	public Actividad actualizaActividad(Actividad actividad)
			throws WorkFlowException {
		ds.update(actividad);
		return actividad;
	}

	@Override
	public boolean eliminarActividad(Actividad actividad)
			throws WorkFlowException {
		// TODO verificar que no este incluida en una transicion
		ds.remove(actividad);
		return true;
	}

	@Override
	public List<Actividad> listar() throws WorkFlowException {
		return ds.list("Actividad.findAll", Actividad.class);
	}

	@Override
	public Transicion asignarDestino(Actividad destino,
			List<Parametro> parametro) throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transicion quitarDestino(Actividad destino) throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transicion asignarDestinos(List<TransicionDestino> destinos)
			throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

}
