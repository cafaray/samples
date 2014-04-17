package com.palestra.wf.dao

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.modelo.Transicion;
import com.palestra.wf.modelo.TransicionDestino;


interface ITransicionDestino {
	TransicionDestino registraDestino(Transicion transicion, TransicionDestino destino) throws WorkFlowException
	TransicionDestino actualizaDestino(Transicion trancision, TransicionDestino destino) throws WorkFlowException
	boolean eliminaDestino(Transicion transicion, TransicionDestino destino) throws WorkFlowException
	List<TransicionDestino> lista(Transicion transicion) throws WorkFlowException
	
}
