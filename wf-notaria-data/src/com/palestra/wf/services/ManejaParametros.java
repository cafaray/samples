package com.palestra.wf.services;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.palestra.wf.dao.impl.DAOParametro;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Parametro;

@Path("/wfe/parametros")
public class ManejaParametros {

	public ManejaParametros() {}

	@POST
	@Path("/registrar")
	@Produces(MediaType.APPLICATION_JSON)
	public Parametro registraParametro(Parametro parametro)throws WorkFlowException{		
		DAOParametro dao = new DAOParametro();
		return dao.registraParametro(parametro);
	}
	
	@POST
	@Path("/actualizar")
	@Produces(MediaType.APPLICATION_JSON)
	public Parametro actualizaParametro(Parametro parametro)throws WorkFlowException{		
		DAOParametro dao = new DAOParametro();
		return dao.actualizaParametro(parametro);		
	}

	@POST
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean eliminaParametro(Parametro parametro)throws WorkFlowException{		
		DAOParametro dao = new DAOParametro();
		return dao.eliminaParametro(parametro);		
	}
	
	@POST
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Parametro> parametros()throws WorkFlowException{
		DAOParametro dao = new DAOParametro();
		return dao.listar();
	}
	
}
