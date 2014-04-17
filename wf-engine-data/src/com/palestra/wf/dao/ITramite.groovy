package com.palestra.wf.dao

import com.palestra.wf.engine.modelo.Tramite;
import com.palestra.wf.engine.modelo.Tarea;
import com.palestra.wf.exception.WorkFlowException;


interface ITramite {
	Tramite registraTramite(Tramite tramite) throws WorkFlowException
	Tramite actualizaTramite(Tramite tramite) throws WorkFlowException
	boolean cancelarTramite(Tramite tramite, String razon) throws WorkFlowException
	List<Tramite> listar() throws WorkFlowException
	List<Tramite> listar(String estatus) throws WorkFlowException
	List<Tarea> listarTareas() throws WorkFlowException
	List<Tarea> listarTareas(String estatus) throws WorkFlowException
	Tarea tareaSiguiente(Tramite tramite) throws WorkFlowException
	List<Tarea> tareasSiguientes(Tramite tramite) throws WorkFlowException
}
