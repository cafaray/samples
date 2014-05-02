package com.palestra.wf.dao;

import java.util.List;

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Actividad;
import com.palestra.wf.model.Proceso;
import com.palestra.wf.model.ProcesoTransiciones;
import com.palestra.wf.model.Transicion;
import com.palestra.wf.model.TransicionDestino;

public interface IProceso {
	Proceso registraProceso(Proceso proceso) throws WorkFlowException;
	Proceso actualizaProceso(Proceso proceso) throws WorkFlowException;
	boolean eliminarProceso(Proceso proceso) throws WorkFlowException;
	List<Proceso> listar() throws WorkFlowException;
	ProcesoTransiciones agregarTransicion(Proceso proceso, Transicion transicion) throws WorkFlowException;
	Proceso quitarTransicion(Proceso proceso, Transicion transicion) throws WorkFlowException;
	List<ProcesoTransiciones> asignarTransiciones(Proceso proceso, List<Transicion> transiciones) throws WorkFlowException;
	Proceso desdeArchivo(String archivo) throws WorkFlowException;
	List<ProcesoTransiciones> listarTransiciones(Proceso proceso)
			throws WorkFlowException;
	List<TransicionDestino> actividadesSiguiente(Proceso proceso,
			Actividad actividad) throws WorkFlowException;

}
