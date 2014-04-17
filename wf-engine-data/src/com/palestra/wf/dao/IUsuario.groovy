package com.palestra.wf.dao

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.modelo.Actividad;
import com.palestra.wf.modelo.Rol;
import com.palestra.wf.modelo.Usuario;


interface IUsuario {
	Usuario registraUsuario(Usuario usuario) throws WorkFlowException
	Usuario actualizaUsuario(Usuario usuario) throws WorkFlowException
	Usuario desactivaUsuario(Usuario usuario) throws WorkFlowException
	Usuario suspendeUsuario(Usuario usuario) throws WorkFlowException
	Usuario reactivaUsuario(Usuario usuario) throws WorkFlowException
	List<Usuario> lista() throws WorkFlowException
	Usuario asignaRol(Usuario usuario, Rol rol) throws WorkFlowException
	Usuario asignaActividad(Usuario usuario, Actividad actividad) throws WorkFlowException
}
