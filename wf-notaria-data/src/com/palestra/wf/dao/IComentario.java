package com.palestra.wf.dao;

import java.util.List;

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Comentario;
import com.palestra.wf.model.Tramite;

public interface IComentario {
	Comentario registraComentario(Comentario comentario) throws WorkFlowException;
	Comentario actualizaComentario(Comentario comentario) throws WorkFlowException;
	boolean quitarComentario(Comentario comentario) throws WorkFlowException;
	List<Comentario> listar(Tramite tramite) throws WorkFlowException;
}
