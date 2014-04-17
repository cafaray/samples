package com.palestra.wf.dao

import com.palestra.wf.exception.WorkFlowException;import com.palestra.wf.modelo.Transicion;

import com.palestra.wf.modelo.Proceso;

interface IProceso {
	Proceso registraProceso(Proceso proceso) throws WorkFlowException
	Proceso actualizaProceso(Proceso proceso) throws WorkFlowException
	boolean eliminarProceso(Proceso proceso) throws WorkFlowException
	List<Proceso> listar() throws WorkFlowException
	Proceso agregarTransicion(Proceso proceso, Transicion transicion) throws WorkFlowException
	Proceso quitarTransicion(Proceso proceso, Transicion transicion) throws WorkFlowException
	Proceso asignarTransiciones(Proceso proceso, List<Transicion> transiciones) throws WorkFlowException
	Proceso desdeArchivo(String archivo) throws WorkFlowException
}
