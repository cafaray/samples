package com.palestra.wf.dao.impl;

import java.util.List;

import com.palestra.wf.dao.IUsuario;
import com.palestra.wf.enums.EstadosUsuario;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Actividad;
import com.palestra.wf.model.Rol;
import com.palestra.wf.model.Usuario;
import com.palestra.wf.model.util.DoSomething;

public class DAOUsuario implements IUsuario {

	private DoSomething ds;
	
	public DAOUsuario() {
		ds = new DoSomething();
	}

	@Override
	public Usuario registraUsuario(Usuario usuario) throws WorkFlowException {
		ds.insert(usuario);
		return usuario;
	}

	@Override
	public Usuario actualizaUsuario(Usuario usuario) throws WorkFlowException {
		ds.update(usuario);
		return usuario;
	}

	@Override
	public Usuario desactivaUsuario(Usuario usuario) throws WorkFlowException {
		usuario.setEsActivo(EstadosUsuario.INACTIVO.getCodigo());
		ds.update(usuario);
		return usuario;
	}

	@Override
	public Usuario suspendeUsuario(Usuario usuario) throws WorkFlowException {
		usuario.setEsActivo(EstadosUsuario.SUSPENDIDO.getCodigo());
		ds.update(usuario);
		return usuario;
	}

	@Override
	public Usuario reactivaUsuario(Usuario usuario) throws WorkFlowException {
		usuario.setEsActivo(EstadosUsuario.ACTIVO.getCodigo());
		ds.update(usuario);
		return usuario;
	}

	@Override
	public List<Usuario> lista() throws WorkFlowException {
		return ds.list("Usuario.findAll", Usuario.class);
	}

	@Override
	public Usuario asignaRol(Usuario usuario, Rol rol) throws WorkFlowException {
		usuario.setRol(rol);
		ds.update(usuario);
		return usuario;
	}

	@Override
	public Usuario asignaActividad(Usuario usuario, Actividad actividad)
			throws WorkFlowException {
		// TODO Auto-generated method stub
		return null;
	}

}
