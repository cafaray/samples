package com.palestra.wf.dao;

import java.util.List;

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.FlujoTrabajo;
import com.palestra.wf.model.FlujoTrabajoPK;
import com.palestra.wf.model.FlujoTrabajoProcesos;
import com.palestra.wf.model.Proceso;

public interface IFlujoTrabajo {
	FlujoTrabajo registraFlujoTrabajo(FlujoTrabajo flujoTrabajo) throws WorkFlowException;
	FlujoTrabajo publicaFlujoTrabajo(String identificador) throws WorkFlowException;
	FlujoTrabajo obtenerUltimaVersion(String identificador) throws WorkFlowException;
	List<FlujoTrabajo> listarFlujosTrabajo() throws WorkFlowException;
	FlujoTrabajo publicarVersion(FlujoTrabajoPK primaryKey) throws WorkFlowException;
	FlujoTrabajo obtenerVersion(FlujoTrabajoPK primaryKey) throws WorkFlowException;
	FlujoTrabajo obtenerVersionPublicada(String identificador) throws WorkFlowException;
	FlujoTrabajoProcesos agregarProceso(FlujoTrabajo flujoTrabajo, Proceso proceso)
			throws WorkFlowException;
	List<Proceso> listarProcesos(FlujoTrabajo flujoTrabajo)
			throws WorkFlowException; 
}
