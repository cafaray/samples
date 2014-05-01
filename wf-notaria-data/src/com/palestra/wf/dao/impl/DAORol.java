package com.palestra.wf.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import com.palestra.wf.dao.IRol;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Rol;
import com.palestra.wf.model.Usuario;
import com.palestra.wf.model.util.DoSomething;

public class DAORol implements IRol {

	private DoSomething ds;
	
	public DAORol() {
		ds = new DoSomething();
	}

	@Override
	public Rol registraRol(Rol rol) throws WorkFlowException {
		ds.insert(rol);
		return rol;
	}

	@Override
	public Rol actualizaRol(Rol rol) throws WorkFlowException {
		ds.update(rol);
		return rol;
	}

	@Override
	public boolean eliminaRol(Rol rol) throws WorkFlowException {
		ds.remove(rol);
		return true;
	}

	@Override
	public List<Rol> lista() throws WorkFlowException {
		return ds.list("Rol.findAll", Rol.class);
	}

	@Override
	public Rol agregarUsuario(Rol rol, Usuario usuario)
			throws WorkFlowException {
		DAOUsuario dao = new DAOUsuario();
		dao.asignaRol(usuario, rol);
		return rol;
	}

	@Override
	public Rol quitarUsuario(Rol rol, Usuario usuario) throws WorkFlowException {
		usuario.setRol(rol);
		ds.update(usuario);
		return rol;
	}

	@Override
	public List<Usuario> listarUsuarios(Rol rol) throws WorkFlowException {
		@SuppressWarnings("unused")
		String idrol = rol.getIdentificador();
		TypedQuery<Usuario> query = ds.getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.idrol = :idrol",Usuario.class);
		List<Usuario> vuelta = query.getResultList();
		return vuelta;
	}

}
