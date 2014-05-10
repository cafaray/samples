package com.palestra.wf.services;

import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.POST;
//import javax.jws.WebService;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.palestra.wf.dao.impl.DAOProceso;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.Actividad;
import com.palestra.wf.model.Proceso;
import com.palestra.wf.model.ProcesoTransiciones;
import com.palestra.wf.model.Transicion;
import com.palestra.wf.model.TransicionDestino;



@Path("/wfe/proceso")
public class ManejaProceso {

	public ManejaProceso() {}
	
	
	@POST
	@Path("/registra")
	@Produces(MediaType.APPLICATION_JSON)
	public Proceso registraProceso(Proceso proceso) throws WorkFlowException{
		DAOProceso dao = new DAOProceso();
		return dao.registraProceso(proceso);
	}
	
	@POST
	@Path("/actualizar")
	@Produces(MediaType.APPLICATION_JSON)
	public Proceso actualizaProcesp(Proceso proceso)throws WorkFlowException{
		DAOProceso dao = new DAOProceso();
		return dao.actualizaProceso(proceso);
	}
	
	@POST
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean eliminaProceso(Proceso proceso)throws WorkFlowException{
		DAOProceso dao = new DAOProceso();
		return dao.eliminarProceso(proceso);
	}	
	
	@POST
	@Path("/agregatransicion")
	@Produces(MediaType.APPLICATION_JSON)
	public ProcesoTransiciones agregarTransicion(Proceso proceso, Transicion transicion) throws WorkFlowException{
		DAOProceso p = new DAOProceso();
		return p.agregarTransicion(proceso, transicion);				
	}
	
	@POST
	@Path("/agregatransiciones")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProcesoTransiciones> asignarTransiciones(Proceso proceso, List<Transicion> transiciones) throws WorkFlowException{
		DAOProceso p = new DAOProceso();
		return p.asignarTransiciones(proceso, transiciones);
	}
	@POST
	@Path("/limpiatransiciones")
	@Produces(MediaType.APPLICATION_JSON)
	public Proceso limpiarTransiciones(Proceso proceso)throws WorkFlowException{
		DAOProceso p = new DAOProceso();
		List<ProcesoTransiciones> transiciones = p.listarTransiciones(proceso);
		for(ProcesoTransiciones transicion: transiciones){
			p.quitarTransicion(proceso, transicion.getTransicion());
		}
		return proceso;
	}
	
	@POST
	@Path("/listatransiciones")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProcesoTransiciones> listarTransiciones(Proceso proceso)throws WorkFlowException{
		DAOProceso p = new DAOProceso();
		return p.listarTransiciones(proceso);
	}
	
	@POST
	@Path("/actividadessiguientes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Actividad> actividadesSiguientes(Proceso proceso, Actividad actividad) throws WorkFlowException{
		DAOProceso dao = new DAOProceso();
		List<TransicionDestino> destinos = dao.actividadesSiguiente(proceso, actividad);
		if(destinos!=null && destinos.size()>0){
			List<Actividad> vuelta = new ArrayList<Actividad>();
			for(TransicionDestino destino:destinos){
				vuelta.add(destino.getActividad());
			}
			return vuelta;
		}else{
			throw new WorkFlowException("There is not activities on this process and activitie ocurrence.");
		}
	}
}
