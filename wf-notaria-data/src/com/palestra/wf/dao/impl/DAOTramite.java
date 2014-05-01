package com.palestra.wf.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import com.palestra.wf.dao.ITramite;
import com.palestra.wf.enums.EstatusTramite;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Comentario;
import com.palestra.wf.model.Tarea;
import com.palestra.wf.model.Tramite;
import com.palestra.wf.model.util.DoSomething;

public class DAOTramite implements ITramite {

	private DoSomething ds;

	public DAOTramite() {
		ds = new DoSomething();
	}

	@Override
	public Tramite registraTramite(Tramite tramite) throws WorkFlowException {
		ds.insert(tramite);
		return tramite;
	}

	@Override
	public Tramite actualizaTramite(Tramite tramite) throws WorkFlowException {
		ds.update(tramite);
		return tramite;
	}

	@Override
	public boolean cancelarTramite(Tramite tramite, String razon)
			throws WorkFlowException {
		tramite.setEstatus(EstatusTramite.CANCELADO.getCodigo());
		ds.update(tramite);
		Comentario comentario = new Comentario();
		comentario.setComentario(razon);
		comentario.setFecha(new Date());
		comentario.setIdentificador();
		comentario.setIdusuario("0000000000000000");
		comentario.setTarea(tareaSiguiente(tramite));
		return true;
	}

	@Override
	public List<Tramite> listar() throws WorkFlowException {
		return ds.list("Tramite.findAll", Tramite.class);
	}

	@Override
	public List<Tramite> listar(String estatus) throws WorkFlowException {
		TypedQuery<Tramite> query = ds.getEntityManager().createNamedQuery(
				"Tramite.findByEstatus", Tramite.class);
		query.setParameter("estatus", estatus);
		return query.getResultList();
	}

	@Override
	public List<Tarea> listarTareas(String tramite) throws WorkFlowException {
		TypedQuery<Tarea> query = ds.getEntityManager().createNamedQuery(
				"Tramite.findByTramite", Tarea.class);
		query.setParameter("idtramite", tramite);
		return query.getResultList();
	}

	@Override
	public List<Tarea> listarTareas(String tramite, String estatus)
			throws WorkFlowException {
		TypedQuery<Tarea> query = ds.getEntityManager().createNamedQuery(
				"Tramite.findByTramiteEstatus", Tarea.class);
		query.setParameter("idtramite", tramite);
		query.setParameter("estatus", estatus);
		return query.getResultList();
	}

	@Override
	public Tarea tareaSiguiente(Tramite tramite) throws WorkFlowException {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@Override
	public List<Tarea> tareasSiguientes(Tramite tramite)
			throws WorkFlowException {
		throw new UnsupportedOperationException("Not yet implemented");
	}

}
