package com.palestra.wf.services;

import java.util.List;

import com.palestra.wf.dao.impl.DAOFlujoTrabajo;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.FlujoTrabajo;
import com.palestra.wf.model.FlujoTrabajoProcesos;
import com.palestra.wf.model.Proceso;

public class ManejaWorkflow {

	public ManejaWorkflow() {}
	
	public FlujoTrabajo registrarFlujoTrabao(FlujoTrabajo flujoTrabajo)throws WorkFlowException{
		DAOFlujoTrabajo dao = new DAOFlujoTrabajo();
		return dao.registraFlujoTrabajo(flujoTrabajo);
	}

	public FlujoTrabajo versionar(String identificador) throws WorkFlowException{
		DAOFlujoTrabajo dao = new DAOFlujoTrabajo();
		return dao.publicaFlujoTrabajo(identificador); 
	}
	
	public FlujoTrabajo ultimaVersion(String identificador) throws WorkFlowException{
		DAOFlujoTrabajo dao = new DAOFlujoTrabajo();
		return dao.obtenerUltimaVersion(identificador);
	}
	
	public FlujoTrabajoProcesos agregarProceso(FlujoTrabajo flujoTrabajo, Proceso proceso)throws WorkFlowException{
		DAOFlujoTrabajo dao = new DAOFlujoTrabajo();
		return dao.agregarProceso(flujoTrabajo, proceso);
	}
	
	public List<Proceso> procesos(FlujoTrabajo flujoTrabajo)throws WorkFlowException{
		DAOFlujoTrabajo dao = new DAOFlujoTrabajo();
		return dao.listarProcesos(flujoTrabajo);
	}
	
}
