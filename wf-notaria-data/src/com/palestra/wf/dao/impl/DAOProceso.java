package com.palestra.wf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import com.palestra.wf.dao.IProceso;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Actividad;
import com.palestra.wf.model.Proceso;
import com.palestra.wf.model.ProcesoTransiciones;
import com.palestra.wf.model.Transicion;
import com.palestra.wf.model.TransicionActividad;
import com.palestra.wf.model.TransicionDestino;
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
	public ProcesoTransiciones agregarTransicion(Proceso proceso,
			Transicion transicion) throws WorkFlowException {
		ProcesoTransiciones pt = new ProcesoTransiciones();
		pt.setProceso(proceso);
		pt.setTransicion(transicion);
		ds.insert(pt);
		return pt;
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
	public List<ProcesoTransiciones> asignarTransiciones(Proceso proceso,
			List<Transicion> transiciones) throws WorkFlowException {
		for (Transicion transicion : transiciones) {
			agregarTransicion(proceso, transicion);
		}
		return listarTransiciones(proceso);
	}

	@Override
	public List<ProcesoTransiciones> listarTransiciones(Proceso proceso)
			throws WorkFlowException {
		TypedQuery<ProcesoTransiciones> query = ds.getEntityManager()
				.createNamedQuery("ProcesoTransiciones.findByProceso",
						ProcesoTransiciones.class);
		query.setParameter("idproceso", proceso.getIdentificador());
		return query.getResultList();
	}

	@Override
	public List<TransicionDestino> actividadesSiguiente(Proceso proceso, Actividad actividad)
			throws WorkFlowException {
		TypedQuery<TransicionActividad> query = ds.getEntityManager()
				.createNamedQuery("ProcesoTransiciones.findByActividad",
						TransicionActividad.class);
		query.setParameter("actividad", actividad);
		query.setParameter("proceso", proceso);
		List<TransicionActividad> transiciones = query.getResultList();
		if (transiciones != null && transiciones.size() > 0) {
			List<TransicionDestino> vuelta = new ArrayList<TransicionDestino>();
			for (TransicionActividad ta : transiciones) {
				TypedQuery<TransicionDestino> queryDestinos = ds.getEntityManager().createNamedQuery("TransicionDestino.findByTransicion", TransicionDestino.class);
				queryDestinos.setParameter("transicion", ta.getTransicion());
				List<TransicionDestino> tds = queryDestinos.getResultList();
				for(TransicionDestino td:tds){
					vuelta.add(td);
				}
			}
			return vuelta;
		} else {
			throw new WorkFlowException(
					"This activity does not exists in the process.");
		}
	}

	@Override
	public Proceso desdeArchivo(String archivo) throws WorkFlowException {
		throw new UnsupportedOperationException();
	}

}
