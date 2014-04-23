package com.palestra.wf.dao;

import java.util.List;

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Parametro;

public interface IParametro {
	Parametro registraParametro(Parametro parametro) throws WorkFlowException;
	Parametro actualizaParametro(Parametro parametro) throws WorkFlowException;
	boolean eliminaParametro(Parametro parametro) throws WorkFlowException;
	List<Parametro> listar() throws WorkFlowException;
}
