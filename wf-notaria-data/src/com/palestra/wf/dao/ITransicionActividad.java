package com.palestra.wf.dao;

import java.util.List;

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Actividad;
import com.palestra.wf.model.TransicionActividad;

public interface ITransicionActividad {
	TransicionActividad registraTransicionActividad(TransicionActividad transicionActividad) throws WorkFlowException;
	TransicionActividad actualizaTransicion(TransicionActividad transicionActividad) throws WorkFlowException;
	boolean eliminaTransicion(TransicionActividad transicionActividad) throws WorkFlowException;
	List<TransicionActividad> lista() throws WorkFlowException;
	List<TransicionActividad> listaActividades(Actividad actividad)
			throws WorkFlowException;
	
}
