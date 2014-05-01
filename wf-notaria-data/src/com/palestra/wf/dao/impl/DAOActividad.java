package com.palestra.wf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import com.palestra.wf.dao.IActividad;
import com.palestra.wf.enums.TipoDestino;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Actividad;
import com.palestra.wf.model.ActividadParametro;
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
		ds.remove(actividad);
		return true;
	}

	@Override
	public List<Actividad> listar() throws WorkFlowException {
		return ds.list("Actividad.findAll", Actividad.class);
	}

	
	@Override
	public Transicion asignarDestino(Actividad destino) throws WorkFlowException {
		
		Transicion transicion = new Transicion();
		transicion.setIdentificador();
		transicion.setNombre("Destino "+destino.getNombre());
		transicion.setTipodestino(TipoDestino.ACTIVIDAD.getCodigo());
		ds.insert(transicion);
		
		TransicionDestino td = new TransicionDestino();
		td.setActividad(destino);
		td.setIdentificador();
		td.setTransicion(transicion);
		ds.insert(td);
		
		return transicion;
	}

	@Override
	public List<ActividadParametro> asignarParametros(Actividad actividad,
			List<Parametro> parametros) throws WorkFlowException {
		List<ActividadParametro> vuelta = new ArrayList<ActividadParametro>();
		for(Parametro parametro: parametros){
			ActividadParametro ap = new ActividadParametro();
			ap.setIdentificador();
			ap.setActividad(actividad);
			ap.setParametro(parametro);
			ds.insert(ap);
			vuelta.add(ap);
		}
		return vuelta;
	}

	@Override
	public boolean quitarParametro(ActividadParametro actividadParametro) throws WorkFlowException {
		ds.remove(actividadParametro);
		return true;
	}

	@Override
	public List<ActividadParametro> actualizarParametros(Actividad actividad,
			List<Parametro> parametros) throws WorkFlowException {		
		List<ActividadParametro> trabajo = listarParametros(actividad);
		
		for(ActividadParametro parametro: trabajo){
			ds.remove(parametro);
		}
		return asignarParametros(actividad, parametros);
	}

	@Override
	public List<ActividadParametro> listarParametros(Actividad actividad)
			throws WorkFlowException {
		String sql = "SELECT ap FROM ActividadParametro ap WHERE ap.idactividad = :actividad";
		TypedQuery<ActividadParametro> query = ds.getEntityManager().createQuery(sql, ActividadParametro.class);
		query.setParameter("actividad", actividad.getIdentificador());
		return query.getResultList();
	}



}
