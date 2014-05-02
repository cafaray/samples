package com.palestra.wf.dao;

import java.util.List;

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Actividad;
import com.palestra.wf.model.ActividadParametro;
import com.palestra.wf.model.Parametro;

public interface IActividad {
	Actividad registraActividad(Actividad actividad) throws WorkFlowException;
	Actividad actualizaActividad(Actividad actividad) throws WorkFlowException;
	boolean eliminarActividad(Actividad actividad) throws WorkFlowException;
	List<Actividad> listar() throws WorkFlowException;
	
	/*
	 * Definiciones para trabajo con Parametro
	 */
	List<ActividadParametro> asignarParametros(Actividad actividad, List<Parametro> parametros) throws WorkFlowException;
	boolean quitarParametro(ActividadParametro actividadParametro) throws WorkFlowException;
	List<ActividadParametro> actualizarParametros(Actividad actividad, List<Parametro> parametros) throws WorkFlowException;
	List<ActividadParametro> listarParametros(Actividad actividad) throws WorkFlowException;
	
	boolean eliminarActividad(String idactividad) throws WorkFlowException;
	Actividad obtenerActividad(String idactividad) throws WorkFlowException;
	List<ActividadParametro> asignarParametro(Actividad actividad, Parametro parametro) throws WorkFlowException;	
	
}
