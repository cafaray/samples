package com.palestra.wf.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import com.palestra.wf.dao.IComentario;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Comentario;
import com.palestra.wf.model.Tramite;
import com.palestra.wf.model.util.DoSomething;

public class DAOComentario implements IComentario {

	private DoSomething ds;
	
	public DAOComentario() {
		ds = new DoSomething();
	}

	@Override
	public Comentario registraComentario(Comentario comentario)
			throws WorkFlowException {
		ds.insert(comentario);
		return comentario;
	}

	@Override
	public Comentario actualizaComentario(Comentario comentario)
			throws WorkFlowException {
		ds.update(comentario);
		return comentario;
	}

	@Override
	public boolean quitarComentario(Comentario comentario)
			throws WorkFlowException {
		ds.remove(comentario);
		return true;
	}

	@Override
	public List<Comentario> listar(Tramite tramite) throws WorkFlowException {
		String sql = "SELECT c FROM Comentario c WHERE c.idtarea IN (SELECT t.idtarea FROM Tarea WHERE idtramite = :tramite) OREDER BY c.tmstmp";
		TypedQuery<Comentario> query = ds.getEntityManager().createQuery(sql, Comentario.class);
		query.setParameter("tramite", tramite.getIdentificador());
		return query.getResultList();
	}

}
