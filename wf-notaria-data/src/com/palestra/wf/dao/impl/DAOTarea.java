package com.palestra.wf.dao.impl;

import java.util.List;

import com.palestra.wf.dao.ITarea;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Comentario;
import com.palestra.wf.model.Rol;
import com.palestra.wf.model.Tarea;
import com.palestra.wf.model.Tramite;
import com.palestra.wf.model.Usuario;
import com.palestra.wf.model.util.DoSomething;

public class DAOTarea implements ITarea {
	
	DoSomething ds;
	
	public DAOTarea() {
		ds = new DoSomething();
	}

	@Override
	public Tarea registraTarea(Tramite tramite, Tarea tarea)
			throws WorkFlowException {
		
		return null;
	}

	@Override
	public Tarea actualizaTarea(Tramite tramite, Tarea tarea)
			throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminaTarea(Tramite tramite, Tarea tarea)
			throws WorkFlowException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Tarea> lista(Tramite tramite) throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rol tareaRol(Tarea tarea) throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rol> tareaRoles(Tarea tarea) throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario tareaUsuario(Tarea tarea) throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> tareaUsuarios(Tarea tarea) throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tarea agregarComentario(Tarea tarea, Comentario comentario)
			throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tarea quitarComentario(Tarea tarea, Comentario comentario)
			throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tarea tareaAnterior(Tarea tarea) throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tarea tareaSiguiente(Tarea tarea) throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tarea> tareasSiguientes(Tarea tarea) throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

}
