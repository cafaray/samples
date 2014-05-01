package com.palestra.wf.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.palestra.wf.dao.ITarea;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Actividad;
import com.palestra.wf.model.Comentario;
import com.palestra.wf.model.Rol;
import com.palestra.wf.model.Tarea;
import com.palestra.wf.model.Tramite;
import com.palestra.wf.model.TransicionActividad;
import com.palestra.wf.model.TransicionDestino;
import com.palestra.wf.model.Usuario;
import com.palestra.wf.model.util.DoSomething;

public class DAOTarea implements ITarea {
	
	DoSomething ds;
	
	public DAOTarea() {
		ds = new DoSomething();
	}

	@Override
	public Tarea registraTarea(Tarea tarea)
			throws WorkFlowException {
		ds.insert(tarea);
		return tarea;
	}

	@Override
	public Tarea actualizaTarea(Tarea tarea)
			throws WorkFlowException {
		ds.update(tarea);
		return tarea;
	}

	@Override
	public boolean eliminaTarea(Tarea tarea)
			throws WorkFlowException {
		ds.remove(tarea);
		return true;
	}

	@Override
	public List<Tarea> lista(Tramite tramite) throws WorkFlowException {
		String sql = "SELECT t FROM Tarea t WHERE t.idtramite = :tramite";
		TypedQuery<Tarea> query = ds.getEntityManager().createNamedQuery(sql, Tarea.class);
		query.setParameter("tramite", tramite.getIdentificador());
		return query.getResultList();
	}

	@Override
	public Rol tareaRol(Tarea tarea) throws WorkFlowException {
		List<Rol> roles = tareaRoles(tarea);
		if (roles!=null && roles.size()>0){
			return roles.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<Rol> tareaRoles(Tarea tarea) throws WorkFlowException {
		String sql = "SELECT r FROM Rol r, (SELECT ar.idrol FROM ActividadRoles ar WHERE idactividad = :actividad) a "
				+ " WHERE r.identificador = a.idrol";
		TypedQuery<Rol> query = ds.getEntityManager().createQuery(sql, Rol.class);
		query.setParameter("actividad", tarea.getActividad().getIdentificador());
		return query.getResultList();
	}

	@Override
	public Usuario tareaUsuario(Tarea tarea) throws WorkFlowException {
		List<Usuario> usuarios = tareaUsuarios(tarea);
		if (usuarios!=null && usuarios.size()>0){
			return usuarios.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<Usuario> tareaUsuarios(Tarea tarea) throws WorkFlowException {
		String sql = "SELECT u FROM Usuario u, (SELECT au.idusuario FROM ActividadUsuarios au WHERE idactividad = :actividad) a "
				+ " WHERE u.identificador = a.idusuario";
		TypedQuery<Usuario> query = ds.getEntityManager().createQuery(sql, Usuario.class);
		query.setParameter("actividad", tarea.getActividad().getIdentificador());
		return query.getResultList();
	}

	@Override
	public Comentario agregarComentario(Tarea tarea, String comentario)
			throws WorkFlowException {
		Comentario c = new Comentario();
		c.setComentario(comentario);
		c.setFecha(new Date());
		c.setIdentificador();
		c.setIdusuario(tarea.getIdusuario());
		c.setTarea(tarea);
		ds.insert(c);
		return c;
	}

	@Override
	public Tarea tareaAnterior(Tarea tarea) throws WorkFlowException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Actividad actividadSiguiente(Tarea tarea) throws WorkFlowException {
		String sql = "SELECT ta FROM TransicionActividad t WHERE t.idactividad = :actividad";
		Query query = ds.getEntityManager().createNamedQuery(sql, TransicionActividad.class);
		query.setParameter("actividad", tarea.getActividad().getIdentificador());
		TransicionActividad ta = (TransicionActividad)query.getSingleResult();
		
		sql = "SELECT td FROM TransicionDestino td WHERE td.idtransicion = :transicion";
		query = ds.getEntityManager().createQuery(sql, TransicionDestino.class);
		query.setParameter("transicion", ta.getTransicion().getIdentificador());
		TransicionDestino td = (TransicionDestino)query.getSingleResult();
		return td.getActividad();
	}

	@Override
	public List<Actividad> actividadSiguientes(Tarea tarea) throws WorkFlowException {
		String sql = "SELECT ta FROM TransicionActividad t WHERE t.idactividad = :actividad";
		Query query = ds.getEntityManager().createNamedQuery(sql, TransicionActividad.class);
		query.setParameter("actividad", tarea.getActividad().getIdentificador());
		TransicionActividad ta = (TransicionActividad)query.getSingleResult();
		
		sql = "SELECT td FROM TransicionDestino td WHERE td.idtransicion = :transicion";
		query = ds.getEntityManager().createQuery(sql, TransicionDestino.class);
		query.setParameter("transicion", ta.getTransicion().getIdentificador());
		@SuppressWarnings("unchecked")
		List<TransicionDestino> tds = query.getResultList();
		
		List<Actividad> actividades = new ArrayList<Actividad>();
		for(TransicionDestino td : tds){
			actividades.add(td.getActividad());
		}
		return actividades;
	}

}
