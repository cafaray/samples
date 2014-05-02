package com.palestra.wf.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.palestra.wf.dao.impl.DAOActividad;
import com.palestra.wf.dao.impl.DAOTransicion;
import com.palestra.wf.dao.impl.DAOTransicionActividad;
import com.palestra.wf.dao.impl.DAOTransicionDestino;
import com.palestra.wf.enums.TipoDestino;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Actividad;
import com.palestra.wf.model.ActividadParametro;
import com.palestra.wf.model.Parametro;
import com.palestra.wf.model.Transicion;
import com.palestra.wf.model.TransicionActividad;
import com.palestra.wf.model.TransicionDestino;

@WebService
public class ManejaActividad {

	@WebMethod
	public Actividad registrarActividad(Actividad actividad)
			throws WorkFlowException {
		DAOActividad dao = new DAOActividad();
		actividad = dao.registraActividad(actividad);
		return actividad;
	}

	@WebMethod
	public Actividad actualizaActividad(Actividad actividad)
			throws WorkFlowException {
		DAOActividad dao = new DAOActividad();
		actividad = dao.actualizaActividad(actividad);
		return actividad;
	}

	@WebMethod
	public void eliminaActividad(Actividad actividad) throws WorkFlowException {
		DAOActividad dao = new DAOActividad();
		dao.eliminarActividad(actividad);
	}

	@WebMethod
	public void eliminaActividad(String idactividad) throws WorkFlowException {
		DAOActividad dao = new DAOActividad();
		dao.eliminarActividad(idactividad);
	}

	@WebMethod
	public Actividad obtenerActividad(String idactividad)
			throws WorkFlowException {
		DAOActividad dao = new DAOActividad();
		return dao.obtenerActividad(idactividad);
	}

	@WebMethod
	public Transicion registraTransicion(String nombre, Actividad inicio,
			Actividad destino) throws WorkFlowException {
		Transicion t = new Transicion();
		t.setIdentificador();
		t.setNombre(nombre);
		t.setTipodestino(TipoDestino.ACTIVIDAD.getCodigo());
		DAOTransicion dao = new DAOTransicion();
		t = dao.registraTransicion(t);

		TransicionActividad ta = new TransicionActividad();
		ta.setIdentificador();
		ta.setTransicion(t);
		ta.setActividad(inicio);
		DAOTransicionActividad daota = new DAOTransicionActividad();
		daota.registraTransicionActividad(ta);

		TransicionDestino td = new TransicionDestino();
		td.setIdentificador();
		td.setActividad(destino);
		td.setTransicion(t);
		DAOTransicionDestino daotd = new DAOTransicionDestino();
		daotd.registraDestino(td);

		return t;
	}

	@WebMethod
	public Transicion registraTransicionFork(String nombre, Actividad inicio,
			List<Actividad> destinos, boolean excluyente) throws WorkFlowException {
		Transicion t = new Transicion();
		t.setIdentificador();
		t.setNombre(nombre);
		if (excluyente){
			t.setTipodestino(TipoDestino.FORK_AND.getCodigo());
		}else{
			t.setTipodestino(TipoDestino.FORK_OR.getCodigo());
		}
		DAOTransicion dao = new DAOTransicion();
		t = dao.registraTransicion(t);

		TransicionActividad ta = new TransicionActividad();
		ta.setIdentificador();
		ta.setTransicion(t);
		ta.setActividad(inicio);
		DAOTransicionActividad daota = new DAOTransicionActividad();
		daota.registraTransicionActividad(ta);

		for (Actividad destino : destinos) {
			TransicionDestino td = new TransicionDestino();
			td.setIdentificador();
			td.setActividad(destino);
			td.setTransicion(t);
			DAOTransicionDestino daotd = new DAOTransicionDestino();
			daotd.registraDestino(td);
		}

		return t;
	}

	@WebMethod
	public Transicion registraTransicionUnion(String nombre, Actividad inicio,
			List<Actividad> destinos, boolean excluyente) throws WorkFlowException {
		Transicion t = new Transicion();
		t.setIdentificador();
		t.setNombre(nombre);
		if (excluyente){
			t.setTipodestino(TipoDestino.UNION_AND.getCodigo());
		}else{
			t.setTipodestino(TipoDestino.UNION_OR.getCodigo());
		}
		DAOTransicion dao = new DAOTransicion();
		t = dao.registraTransicion(t);

		TransicionActividad ta = new TransicionActividad();
		ta.setIdentificador();
		ta.setTransicion(t);
		ta.setActividad(inicio);
		DAOTransicionActividad daota = new DAOTransicionActividad();
		daota.registraTransicionActividad(ta);

		for (Actividad destino : destinos) {
			TransicionDestino td = new TransicionDestino();
			td.setIdentificador();
			td.setActividad(destino);
			td.setTransicion(t);
			DAOTransicionDestino daotd = new DAOTransicionDestino();
			daotd.registraDestino(td);
		}

		return t;
	}	
	
	@WebMethod
	public List<ActividadParametro> registraParametros(Actividad actividad,
			List<Parametro> parametros) throws WorkFlowException {
		DAOActividad dao = new DAOActividad();
		return dao.asignarParametros(actividad, parametros);
	}
	
	@WebMethod
	public List<ActividadParametro> registraParametro(Actividad actividad, Parametro parametro) throws WorkFlowException{
		DAOActividad dao = new DAOActividad();
		return dao.asignarParametro(actividad, parametro);
	}

	@WebMethod
	public List<ActividadParametro> quitaParametro(ActividadParametro actividadParametro ) throws WorkFlowException{		
		DAOActividad dao = new DAOActividad();
		dao.quitarParametro(actividadParametro);
		return dao.listarParametros(actividadParametro.getActividad());
	}	
	
	@WebMethod
	public List<ActividadParametro> listarParaetros(Actividad actividad) throws WorkFlowException{		
		DAOActividad dao = new DAOActividad();
		return dao.listarParametros(actividad);
	}
	
	
}