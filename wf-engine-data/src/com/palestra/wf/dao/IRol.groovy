package com.palestra.wf.dao

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.modelo.Rol;
import com.palestra.wf.modelo.Usuario;

interface IRol {
	Rol registraRol(Rol rol) throws WorkFlowException
	Rol actualizaRol(Rol rol) throws WorkFlowException
	boolean eliminaRol(Rol rol) throws WorkFlowException
	List<Rol> lista() throws WorkFlowException
	Rol agregarUsuario(Rol rol, Usuario usuario) throws WorkFlowException
	Rol quitarUsuario(Rol rol, Usuario usuario) throws WorkFlowException
	List<Usuario> listarUsuarios(Rol rol) throws WorkFlowException 
}
