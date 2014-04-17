package com.palestra.wf.dao

import com.palestra.wf.exception.WorkFlowException;import com.palestra.wf.modelo.Parametro;import com.palestra.wf.modelo.TransicionDestino;

import com.palestra.wf.modelo.Transicion;
import com.palestra.wf.modelo.Actividad;


interface IActividad {
	Actividad registraActividad(Actividad actividad) throws WorkFlowException
	Actividad actualizaActividad(Actividad actividad) throws WorkFlowException
	boolean eliminarActividad(Actividad actividad) throws WorkFlowException
	List<Actividad> listar() throws WorkFlowException
	Transicion asignarDestino(Actividad destino, List<Parametro> parametro) throws WorkFlowException
	Transicion quitarDestino(Actividad destino) throws WorkFlowException
	Transicion asignarDestinos(List<TransicionDestino> destinos) throws WorkFlowException
}
