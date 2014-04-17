package com.palestra.wf.dao

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.modelo.Actividad;
import com.palestra.wf.modelo.Transicion;
import com.palestra.wf.modelo.TransicionDestino;

interface ITransicion {
	Transicion registraTransicion(Transicion transicion) throws WorkFlowException
	Transicion actualizaTransicion(Transicion transicion) throws WorkFlowException
	boolean eliminaTransicion(Transicion transicion) throws WorkFlowException
	List<Transicion> lista() throws WorkFlowException
	Transicion asignarDestino(Transicion transicion, TransicionDestino transicionDestino) throws WorkFlowException
	Transicion quitarDestino(Transicion transicion, Actividad actividad) throws WorkFlowException
	Transicion actualizarDestinos(Transicion transicion, List<TransicionDestino> destinos) throws WorkFlowException
	List<TransicionDestino> destinos(Transicion transicion) throws WorkFlowException
	List<Actividad> actividadesRegistradas() throws WorkFlowException
}
