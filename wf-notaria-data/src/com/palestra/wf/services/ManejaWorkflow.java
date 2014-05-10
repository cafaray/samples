package com.palestra.wf.services;

import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.palestra.wf.dao.impl.DAOFlujoTrabajo;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.FlujoTrabajo;
import com.palestra.wf.model.FlujoTrabajoProcesos;
import com.palestra.wf.model.Proceso;

@Path("/wfe")
public class ManejaWorkflow {

	public ManejaWorkflow() {}
	
	@POST
	@Path("/registrar")
	@Produces(MediaType.APPLICATION_JSON)
	public FlujoTrabajo registrarFlujoTrabao(FlujoTrabajo flujoTrabajo)throws WorkFlowException{
		DAOFlujoTrabajo dao = new DAOFlujoTrabajo();
		return dao.registraFlujoTrabajo(flujoTrabajo);
	}

	@POST
	@Path("/versionar")
	@Produces(MediaType.APPLICATION_JSON)
	public FlujoTrabajo versionar(String identificador) throws WorkFlowException{
		DAOFlujoTrabajo dao = new DAOFlujoTrabajo();
		return dao.publicaFlujoTrabajo(identificador); 
	}
	
	@POST
	@Path("/ultimaversion")
	@Produces(MediaType.APPLICATION_JSON)
	public FlujoTrabajo ultimaVersion(String identificador) throws WorkFlowException{
		DAOFlujoTrabajo dao = new DAOFlujoTrabajo();
		return dao.obtenerUltimaVersion(identificador);
	}
	
	@POST
	@Path("/registraproceso")
	@Produces(MediaType.APPLICATION_JSON)
	public FlujoTrabajoProcesos agregarProceso(FlujoTrabajo flujoTrabajo, Proceso proceso)throws WorkFlowException{
		DAOFlujoTrabajo dao = new DAOFlujoTrabajo();
		return dao.agregarProceso(flujoTrabajo, proceso);
	}
	
	@POST
	@Path("/listaprocesos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Proceso> procesos(FlujoTrabajo flujoTrabajo)throws WorkFlowException{
		DAOFlujoTrabajo dao = new DAOFlujoTrabajo();
		return dao.listarProcesos(flujoTrabajo);
	}
	
}
