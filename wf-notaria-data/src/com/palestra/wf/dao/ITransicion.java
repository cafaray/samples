package com.palestra.wf.dao;

import java.util.List;

import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Actividad;
import com.palestra.wf.model.Transicion;
import com.palestra.wf.model.TransicionDestino;

public interface ITransicion {
	Transicion registraTransicion(Transicion transicion) throws WorkFlowException;
	Transicion actualizaTransicion(Transicion transicion) throws WorkFlowException;
	boolean eliminaTransicion(Transicion transicion) throws WorkFlowException;
	List<Transicion> lista() throws WorkFlowException;
	Transicion asignarDestino(Transicion transicion, TransicionDestino transicionDestino) throws WorkFlowException;
	Transicion quitarDestino(Transicion transicion, Actividad actividad) throws WorkFlowException;
	Transicion actualizarDestinos(Transicion transicion, List<TransicionDestino> destinos) throws WorkFlowException;
	List<TransicionDestino> destinos(Transicion transicion) throws WorkFlowException;
	List<Actividad> actividadesRegistradas() throws WorkFlowException;
}
