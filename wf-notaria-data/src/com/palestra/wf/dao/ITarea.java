package com.palestra.wf.dao;

import java.util.List;

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Actividad;
import com.palestra.wf.model.Comentario;
import com.palestra.wf.model.Rol;
import com.palestra.wf.model.Tarea;
import com.palestra.wf.model.Tramite;
import com.palestra.wf.model.Usuario;

public interface ITarea {
	Tarea registraTarea(Tarea tarea) throws WorkFlowException;
	Tarea actualizaTarea(Tarea tarea) throws WorkFlowException;
	boolean eliminaTarea(Tarea tarea) throws WorkFlowException;
	List<Tarea> lista(Tramite tramite) throws WorkFlowException;
	Rol tareaRol(Tarea tarea) throws WorkFlowException;
	List<Rol> tareaRoles(Tarea tarea) throws WorkFlowException;
	Usuario tareaUsuario(Tarea tarea) throws WorkFlowException;
	List<Usuario> tareaUsuarios(Tarea tarea) throws WorkFlowException;
	Comentario agregarComentario(Tarea tarea, String comentario) throws WorkFlowException;
	Tarea tareaAnterior(Tarea tarea) throws WorkFlowException;
	Actividad actividadSiguiente(Tarea tarea) throws WorkFlowException;
	List<Actividad> actividadSiguientes(Tarea tarea) throws WorkFlowException;
}
