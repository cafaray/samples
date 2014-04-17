package com.palestra.wf.dao

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.modelo.FlujoTrabajo;

interface IFlujoTrabajo {
	FlujoTrabajo registraFlujoTrabajo(FlujoTrabajo flujoTrabajo) throws WorkFlowException;
	FlujoTrabajo publicaFlujoTrabajo(String identificador) throws WorkFlowException;
	FlujoTrabajo obtenerUltimaVersion() throws WorkFlowException;
	List<FlujoTrabajo> listarFlujosTrabajo() throws WorkFlowException;
	FlujoTrabajo publicarVersion(int version) throws WorkFlowException;
	FlujoTrabajo obtenerVersion(int version) throws WorkFlowException;
}
