package com.palestra.wf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.palestra.wf.dao.IFlujoTrabajo;
import com.palestra.wf.enums.EstatusPublicacion;
import com.palestra.wf.exception.WorkFlowException;
import com.palestra.wf.model.FlujoTrabajo;
import com.palestra.wf.model.FlujoTrabajoPK;
import com.palestra.wf.model.FlujoTrabajoProcesos;
import com.palestra.wf.model.Proceso;
import com.palestra.wf.model.util.DoSomething;

public class DAOFlujoTrabajo implements IFlujoTrabajo {

	DoSomething ds;
	
	public DAOFlujoTrabajo() {
		ds = new DoSomething();
	}

	@Override
	public FlujoTrabajo registraFlujoTrabajo(FlujoTrabajo flujoTrabajo)
			throws WorkFlowException {
		ds.insert(flujoTrabajo);
		return flujoTrabajo;
	}

	@Override
	public FlujoTrabajo publicaFlujoTrabajo(String identificador)
			throws WorkFlowException {
		FlujoTrabajo flujoTrabajo = obtenerUltimaVersion(identificador);
		flujoTrabajo = publicarVersion(new FlujoTrabajoPK(identificador, flujoTrabajo.getId().getVersion()));
		return flujoTrabajo;
	}

	@Override
	public FlujoTrabajo obtenerUltimaVersion(String identificador) throws WorkFlowException {
		String sql = "SELECT MAX(f.version) FROM FlujoTrabajo f WHERE f.identificador = :identificador";
		Query query = ds.getEntityManager().createQuery(sql);
		query.setParameter("identificador", identificador);
		Integer version = (Integer)query.getSingleResult();

		sql = "SELECT f FROM FlujoTrabajo f WHERE f.identificador = :identificador AND f.version = :version";
		query = ds.getEntityManager().createQuery(sql);
		query.setParameter("identificador", identificador);
		query.setParameter("version", version);
		FlujoTrabajo flujoTrabajo = (FlujoTrabajo)query.getSingleResult();
		if (flujoTrabajo!=null){			
			return flujoTrabajo;
		}else{
			return null;
		}
	}

	@Override
	public List<FlujoTrabajo> listarFlujosTrabajo() throws WorkFlowException {
		return ds.list("FlujoTrabajo.findAll", FlujoTrabajo.class);
	}

	@Override
	public FlujoTrabajo publicarVersion(FlujoTrabajoPK primaryKey) throws WorkFlowException {
		FlujoTrabajo flujoTrabajo = obtenerVersion(primaryKey);
		flujoTrabajo.setPublicado(EstatusPublicacion.PUBLICADO.getCodigo());
		flujoTrabajo = ds.update(flujoTrabajo);	
		if (flujoTrabajo!=null){
			FlujoTrabajo despublicar = obtenerVersionPublicada(primaryKey.getIdentificador());
			despublicar.setPublicado(EstatusPublicacion.DESPUBLICADA.getCodigo());
			ds.update(despublicar);
			return flujoTrabajo;
		}else{
			return null;
		}
	}

	@Override
	public FlujoTrabajo obtenerVersion(FlujoTrabajoPK primaryKey) throws WorkFlowException {
		String sql = "SELECT f FROM FlujoTrabajo f WHERE f.identificador = :identificador AND f.version = :version";
		Query query = ds.getEntityManager().createQuery(sql);
		query.setParameter("identificador", primaryKey.getIdentificador());
		query.setParameter("version", primaryKey.getVersion());
		FlujoTrabajo flujoTrabajo = (FlujoTrabajo)query.getSingleResult();
		return flujoTrabajo;
	}

	@Override
	public FlujoTrabajo obtenerVersionPublicada(String identificador) throws WorkFlowException{
		String sql = "SELECT f FROM FlujoTrabajo f WHERE f.identificador = :identificador AND f.publicado = :estatus";
		Query query = ds.getEntityManager().createQuery(sql);
		query.setParameter("identificador", identificador);
		query.setParameter("estatus", EstatusPublicacion.PUBLICADO.getCodigo());
		FlujoTrabajo flujoTrabajo = (FlujoTrabajo)query.getSingleResult();
		return flujoTrabajo;
	}
	
	@Override
	public FlujoTrabajoProcesos agregarProceso(FlujoTrabajo flujoTrabajo, Proceso proceso) throws WorkFlowException{
		FlujoTrabajoProcesos fp = new FlujoTrabajoProcesos();
		fp.setFlujoTrabajo(flujoTrabajo);
		fp.setProceso(proceso);
		ds.insert(fp);
		return fp;
	}

	@Override
	public List<Proceso> listarProcesos(FlujoTrabajo flujoTrabajo) throws WorkFlowException{
		TypedQuery<FlujoTrabajoProcesos> query = ds.getEntityManager().createNamedQuery("FlujoTrabajoProcesos.findByProceso", FlujoTrabajoProcesos.class);
		query.setParameter("idproceso", flujoTrabajo.getId().getIdentificador());
		query.setParameter("version", flujoTrabajo.getId().getVersion());
		List<FlujoTrabajoProcesos> ftps = query.getResultList();
		List<Proceso> procesos = new ArrayList<Proceso>();
		for(FlujoTrabajoProcesos ftp:ftps){
			procesos.add(ftp.getProceso());
		}
		return procesos;
	}
	
}
