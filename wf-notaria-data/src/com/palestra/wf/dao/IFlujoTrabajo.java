package com.palestra.wf.dao;

import java.util.List;

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.FlujoTrabajo;

public interface IFlujoTrabajo {
	FlujoTrabajo registraFlujoTrabajo(FlujoTrabajo flujoTrabajo) throws WorkFlowException;
	FlujoTrabajo publicaFlujoTrabajo(String identificador) throws WorkFlowException;
	FlujoTrabajo obtenerUltimaVersion() throws WorkFlowException;
	List<FlujoTrabajo> listarFlujosTrabajo() throws WorkFlowException;
	FlujoTrabajo publicarVersion(int version) throws WorkFlowException;
	FlujoTrabajo obtenerVersion(int version) throws WorkFlowException;
}
