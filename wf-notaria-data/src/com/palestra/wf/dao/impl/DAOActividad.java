package com.palestra.wf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import com.palestra.wf.dao.IActividad;

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Actividad;
import com.palestra.wf.model.ActividadParametro;
import com.palestra.wf.model.Parametro;
import com.palestra.wf.model.util.DoSomething;

public class DAOActividad implements IActividad {
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
	public boolean eliminarActividad(String idactividad)
			throws WorkFlowException {
		Actividad actividad = ds.findById(Actividad.class, idactividad);
		if (actividad != null) {
			ds.remove(actividad);
		} else {
			return false;
		}
		return true;
	}

	@Override
	public Actividad obtenerActividad(String idactividad)
			throws WorkFlowException {
		return ds.findById(Actividad.class, idactividad);
	}

	@Override
	public List<Actividad> listar() throws WorkFlowException {
		return ds.list("Actividad.findAll", Actividad.class);
	}

	@Override
	public List<ActividadParametro> asignarParametros(Actividad actividad,
			List<Parametro> parametros) throws WorkFlowException {
		List<ActividadParametro> vuelta = new ArrayList<ActividadParametro>();
		for (Parametro parametro : parametros) {
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
	public List<ActividadParametro> asignarParametro(Actividad actividad, Parametro parametro) throws WorkFlowException {
		ActividadParametro ap = new ActividadParametro();
		ap.setIdentificador();
		ap.setActividad(actividad);
		ap.setParametro(parametro);
		ds.insert(ap);
		return listarParametros(actividad);
	}	
	
	@Override
	public boolean quitarParametro(ActividadParametro actividadParametro)
			throws WorkFlowException {
		ds.remove(actividadParametro);
		return true;
	}

	@Override
	public List<ActividadParametro> actualizarParametros(Actividad actividad,
			List<Parametro> parametros) throws WorkFlowException {
		List<ActividadParametro> trabajo = listarParametros(actividad);

		for (ActividadParametro parametro : trabajo) {
			ds.remove(parametro);
		}
		return asignarParametros(actividad, parametros);
	}

	@Override
	public List<ActividadParametro> listarParametros(Actividad actividad)
			throws WorkFlowException {
		String sql = "SELECT ap FROM ActividadParametro ap WHERE ap.idactividad = :actividad";
		TypedQuery<ActividadParametro> query = ds.getEntityManager()
				.createQuery(sql, ActividadParametro.class);
		query.setParameter("actividad", actividad.getIdentificador());
		return query.getResultList();
	}

}
