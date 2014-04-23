package com.palestra.wf.dao;

import java.util.List;

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Comentario;
import com.palestra.wf.model.Tarea;
import com.palestra.wf.model.Tramite;

public interface IComentario {
	Comentario registraComentario(Comentario comentario, Tarea tarea) throws WorkFlowException;
	Comentario actualizaComentario(Comentario comentario, Tarea tarea) throws WorkFlowException;
	boolean quitarComentario(Comentario comentario, Tarea tarea) throws WorkFlowException;
	List<Comentario> listar(Tramite tramite) throws WorkFlowException;
}
