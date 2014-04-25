package com.palestra.wf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.palestra.wf.dao.IActividad;
import com.palestra.wf.enums.TipoDestino;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Actividad;
import com.palestra.wf.model.ActividadParametro;
import com.palestra.wf.model.ActividadParametroPK;
import com.palestra.wf.model.Parametro;
import com.palestra.wf.model.Transicion;
import com.palestra.wf.model.TransicionDestino;
import com.palestra.wf.model.TransicionDestinoParametro;
import com.palestra.wf.model.TransicionDestinoParametroPK;
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
	public Transicion asignarDestino(Actividad destino,
			List<Parametro> parametros) throws WorkFlowException {
		
		Transicion transicion = new Transicion();
		transicion.setIdentificador();
		transicion.setNombre("Destino "+destino.getNombre());
		transicion.setSesion("sesion");
		transicion.setTipodestino(TipoDestino.ACTIVIDAD.getCodigo());
		ds.insert(transicion);
		
		TransicionDestino td = new TransicionDestino();
		td.setActividad(destino);
		td.setIdentificador();
		td.setSesion("sesion");
		td.setTransicion(transicion);
		ds.insert(td);
		
		for(Parametro parametro:parametros){
			TransicionDestinoParametro tdp = new TransicionDestinoParametro();
			tdp.setId(new TransicionDestinoParametroPK(td.getIdentificador(), parametro.getIdentificador()));
			tdp.setParametro(parametro);
			tdp.setTransicionDestino(td);
			ds.insert(tdp);
		}
		return transicion;
	}

	@Override
	public List<ActividadParametro> asignarParametros(Actividad actividad,
			List<Parametro> parametros) throws WorkFlowException {
		List<ActividadParametro> vuelta = new ArrayList<ActividadParametro>();
		for(Parametro parametro: parametros){
			ActividadParametro ap = new ActividadParametro();
			ap.setActividad(actividad);
			ap.setParametro(parametro);
			ap.setSesion("sesion");
			ap.setId(new ActividadParametroPK(actividad.getIdentificador(), parametro.getIdentificador()));
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

	@SuppressWarnings("unchecked")
	@Override
	public List<ActividadParametro> listarParametros(Actividad actividad)
			throws WorkFlowException {
		String sql = "SELECT ap FROM ActividadParametro ap WHERE ap.idactividad = :actividad";
		Query query = ds.getEntityManager().createQuery(sql, ActividadParametro.class);
		query.setParameter("actividad", actividad.getIdentificador());
		return query.getResultList();
	}



}
