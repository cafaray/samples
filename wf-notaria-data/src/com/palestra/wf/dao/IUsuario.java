package com.palestra.wf.dao;

import java.util.List;

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Actividad;
import com.palestra.wf.model.Rol;
import com.palestra.wf.model.Usuario;

public interface IUsuario {
	Usuario registraUsuario(Usuario usuario) throws WorkFlowException;
	Usuario actualizaUsuario(Usuario usuario) throws WorkFlowException;
	Usuario desactivaUsuario(Usuario usuario) throws WorkFlowException;
	Usuario suspendeUsuario(Usuario usuario) throws WorkFlowException;
	Usuario reactivaUsuario(Usuario usuario) throws WorkFlowException;
	List<Usuario> lista() throws WorkFlowException;
	Usuario asignaRol(Usuario usuario, Rol rol) throws WorkFlowException;
	Usuario asignaActividad(Usuario usuario, Actividad actividad) throws WorkFlowException;
}
