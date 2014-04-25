package com.palestra.wf.dao;

import java.util.List;

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Transicion;


public interface ITransicion {
	Transicion registraTransicion(Transicion transicion) throws WorkFlowException;
	Transicion actualizaTransicion(Transicion transicion) throws WorkFlowException;
	boolean eliminaTransicion(Transicion transicion) throws WorkFlowException;
	List<Transicion> lista() throws WorkFlowException;
	
}
