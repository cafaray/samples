package com.palestra.wf.dao

import com.palestra.wf.engine.modelo.Comentario;
import com.palestra.wf.engine.modelo.Tarea;
import com.palestra.wf.engine.modelo.Tramite;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.modelo.Rol;
import com.palestra.wf.modelo.Usuario;

interface ITarea {
	Tarea registraTarea(Tramite tramite, Tarea tarea) throws WorkFlowException
	Tarea actualizaTarea(Tramite tramite, Tarea tarea) throws WorkFlowException
	boolean eliminaTarea(Tramite tramite, Tarea tarea) throws WorkFlowException
	List<Tarea> lista(Tramite tramite) throws WorkFlowException
	Rol tareaRol(Tarea tarea) throws WorkFlowException
	List<Rol> tareaRoles(Tarea tarea) throws WorkFlowException
	Usuario tareaUsuario(Tarea tarea) throws WorkFlowException
	List<Usuario> tareaUsuarios(Tarea tarea) throws WorkFlowException
	Tarea agregarComentario(Tarea tarea, Comentario comentario) throws WorkFlowException
	Tarea quitarComentario(Tarea tarea, Comentario comentario) throws WorkFlowException
	Tarea tareaAnterior(Tarea tarea) throws WorkFlowException
	Tarea tareaSiguiente(Tarea tarea) throws WorkFlowException
	List<Tarea> tareasSiguientes(Tarea tarea) throws WorkFlowException
}
