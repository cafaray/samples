package com.palestra.wf.services;

import java.util.List;

import javax.ws.rs.POST;
//import javax.jws.WebService;
//import javax.jws.WebMethod;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
import com.palestra.wf.model.util.ActividadArchivo;

@Path("/wfe/actividad/")
public class ManejaActividad {

	@POST
	@Path("/registrar")
	@Produces(MediaType.APPLICATION_JSON)
	public Actividad registrarActividad(Actividad actividad)
			throws WorkFlowException {
		DAOActividad dao = new DAOActividad();
		actividad = dao.registraActividad(actividad);
		return actividad;
	}

	@POST
	@Path("/actualizar")
	@Produces(MediaType.APPLICATION_JSON)
	public Actividad actualizaActividad(Actividad actividad)
			throws WorkFlowException {
		DAOActividad dao = new DAOActividad();
		actividad = dao.actualizaActividad(actividad);
		return actividad;
	}

	@POST
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)
	public void eliminaActividad(Actividad actividad) throws WorkFlowException {
		DAOActividad dao = new DAOActividad();
		dao.eliminarActividad(actividad);
	}

	@POST
	@Path("/eliminaxid")
	@Produces(MediaType.APPLICATION_JSON)
	public void eliminaActividadPorId(String idactividad) throws WorkFlowException {
		DAOActividad dao = new DAOActividad();
		dao.eliminarActividad(idactividad);
	}

	@POST
	@Path("/obtener")
	@Produces(MediaType.APPLICATION_JSON)
	public Actividad obtenerActividad(String idactividad)
			throws WorkFlowException {
		DAOActividad dao = new DAOActividad();
		return dao.obtenerActividad(idactividad);
	}

	@POST
	@Path("/registratransicion")
	@Produces(MediaType.APPLICATION_JSON)
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

	@POST
	@Path("/registratransicionfork")
	@Produces(MediaType.APPLICATION_JSON)
	public Transicion registraTransicionFork(String nombre, Actividad inicio,
			List<Actividad> destinos, boolean excluyente)
			throws WorkFlowException {
		Transicion t = new Transicion();
		t.setIdentificador();
		t.setNombre(nombre);
		if (excluyente) {
			t.setTipodestino(TipoDestino.FORK_AND.getCodigo());
		} else {
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

	@POST
	@Path("/registratransicionunion")
	@Produces(MediaType.APPLICATION_JSON)
	public Transicion registraTransicionUnion(String nombre, Actividad inicio,
			List<Actividad> destinos, boolean excluyente)
			throws WorkFlowException {
		Transicion t = new Transicion();
		t.setIdentificador();
		t.setNombre(nombre);
		if (excluyente) {
			t.setTipodestino(TipoDestino.UNION_AND.getCodigo());
		} else {
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

	@POST
	@Path("/cargaractividades")
	@Produces(MediaType.APPLICATION_JSON)
	public int cargarActividades(List<Actividad> actividades)
			throws WorkFlowException {
		int cuentaActividad = 0;
		if (actividades != null && actividades.size() > 0) {
			DAOActividad dao = new DAOActividad();
			for (Actividad actividad : actividades) {
				dao.registraActividad(actividad);
				cuentaActividad++;
			}
		}
		return cuentaActividad;
	}

	@POST
	@Path("/cargardesdearchivo")
	@Produces(MediaType.APPLICATION_JSON)
	public int cargarActividadesArchivo(List<ActividadArchivo> actividades)
			throws WorkFlowException {
		int cuentaActividad = 0;
		if (actividades != null && actividades.size() > 0) {
			DAOActividad dao = new DAOActividad();
			for (ActividadArchivo actividad : actividades) {
				dao.registraActividad(actividad.getActividad());
				dao.actualizarParametros(actividad.getActividad(),
						actividad.getParametros());
				cuentaActividad++;
			}
		}
		return cuentaActividad;
	}

	@POST
	@Path("/registraparams")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ActividadParametro> registraParametros(Actividad actividad,
			List<Parametro> parametros) throws WorkFlowException {
		DAOActividad dao = new DAOActividad();
		return dao.asignarParametros(actividad, parametros);
	}

	@POST
	@Path("/registraparam")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ActividadParametro> registraParametro(Actividad actividad,
			Parametro parametro) throws WorkFlowException {
		DAOActividad dao = new DAOActividad();
		return dao.asignarParametro(actividad, parametro);
	}

	@POST
	@Path("/quitaparam")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ActividadParametro> quitaParametro(
			ActividadParametro actividadParametro) throws WorkFlowException {
		DAOActividad dao = new DAOActividad();
		dao.quitarParametro(actividadParametro);
		return dao.listarParametros(actividadParametro.getActividad());
	}

	@POST
	@Path("/listaparams")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ActividadParametro> listarParaetros(Actividad actividad)
			throws WorkFlowException {
		DAOActividad dao = new DAOActividad();
		return dao.listarParametros(actividad);
	}

}