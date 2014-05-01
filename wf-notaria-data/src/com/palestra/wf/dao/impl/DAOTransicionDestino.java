package com.palestra.wf.dao.impl;

import java.util.List;


import javax.persistence.TypedQuery;

import com.palestra.wf.dao.ITransicionDestino;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Transicion;
import com.palestra.wf.model.TransicionDestino;
import com.palestra.wf.model.util.DoSomething;

public class DAOTransicionDestino implements ITransicionDestino {

	private DoSomething ds;
	
	public DAOTransicionDestino() {
		ds = new DoSomething();
	}

	@Override
	public TransicionDestino registraDestino(TransicionDestino destino) throws WorkFlowException {
		ds.insert(destino);
		return null;
	}

	@Override
	public TransicionDestino actualizaDestino(TransicionDestino destino) throws WorkFlowException {
		ds.update(destino);
		return destino;
	}

	@Override
	public boolean eliminaDestino(TransicionDestino destino) throws WorkFlowException {
		ds.remove(destino);
		return true;
	}

	@Override
	public List<TransicionDestino> lista(Transicion transicion)
			throws WorkFlowException {
		String sql = "SELECT td FROM TransicionDestino td WHERE td.idtransicion = :identificador";
		TypedQuery<TransicionDestino> query = ds.getEntityManager().createQuery(sql, TransicionDestino.class);
		query.setParameter("identificador", transicion.getIdentificador());
		return query.getResultList();
	}

}
