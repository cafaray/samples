package com.palestra.wf.dao

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.modelo.Parametro;

interface IParametro {

	Parametro registraParametro(Parametro parametro) throws WorkFlowException
	Parametro actualizaParametro(Parametro parametro) throws WorkFlowException
	boolean eliminaParametro(Parametro parametro) throws WorkFlowException
	List<Parametro> listar() throws WorkFlowException
	
}
