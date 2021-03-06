package com.palestra.wf.dao;

import java.util.List;

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Transicion;
import com.palestra.wf.model.TransicionDestino;

public interface ITransicionDestino {
	TransicionDestino registraDestino(TransicionDestino destino) throws WorkFlowException;
	TransicionDestino actualizaDestino(TransicionDestino destino) throws WorkFlowException;
	boolean eliminaDestino(TransicionDestino destino) throws WorkFlowException;
	List<TransicionDestino> lista(Transicion transicion) throws WorkFlowException;
}
