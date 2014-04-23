package com.palestra.wf.dao;

import java.util.List;

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Actividad;
import com.palestra.wf.model.Parametro;
import com.palestra.wf.model.Transicion;
import com.palestra.wf.model.TransicionDestino;

public interface IActividad {
	Actividad registraActividad(Actividad actividad) throws WorkFlowException;
	Actividad actualizaActividad(Actividad actividad) throws WorkFlowException;
	boolean eliminarActividad(Actividad actividad) throws WorkFlowException;
	List<Actividad> listar() throws WorkFlowException;
	Transicion asignarDestino(Actividad destino, List<Parametro> parametro) throws WorkFlowException;
	Transicion quitarDestino(Actividad destino) throws WorkFlowException;
	Transicion asignarDestinos(List<TransicionDestino> destinos) throws WorkFlowException;
}
