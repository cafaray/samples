package com.palestra.wf.services;

import java.util.List;

import com.palestra.wf.dao.impl.DAOParametro;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Parametro;

public class ManejaParametros {

	public ManejaParametros() {}

	public Parametro registraParametro(Parametro parametro)throws WorkFlowException{		
		DAOParametro dao = new DAOParametro();
		return dao.registraParametro(parametro);
	}
	
	public Parametro actualizaParametro(Parametro parametro)throws WorkFlowException{		
		DAOParametro dao = new DAOParametro();
		return dao.actualizaParametro(parametro);		
	}

	public boolean eliminaParametro(Parametro parametro)throws WorkFlowException{		
		DAOParametro dao = new DAOParametro();
		return dao.eliminaParametro(parametro);		
	}
	
	public List<Parametro> parametros()throws WorkFlowException{
		DAOParametro dao = new DAOParametro();
		return dao.listar();
	}
	
}
