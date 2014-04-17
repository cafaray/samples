package com.palestra.wf.dao

import com.palestra.wf.engine.modelo.Comentario;
import com.palestra.wf.engine.modelo.Tarea;
import com.palestra.wf.engine.modelo.Tramite;
import com.palestra.wf.exception.WorkFlowException;


interface IComentario {
	Comentario registraComentario(Comentario comentario, Tarea tarea) throws WorkFlowException
	Comentario actualizaComentario(Comentario comentario, Tarea tarea) throws WorkFlowException
	boolean quitarComentario(Comentario comentario, Tarea tarea) throws WorkFlowException
	List<Comentario> listar(Tramite tramite) throws WorkFlowException
}
