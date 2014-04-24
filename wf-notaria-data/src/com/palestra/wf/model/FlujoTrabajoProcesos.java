package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.ICommonFields;

import java.util.Date;


/**
 * The persistent class for the kwfm01t database table.
 * 
 */
@Entity
@Table(name="kwfm01t")
@NamedQuery(name="FlujoTrabajoProcesos.findAll", query="SELECT f FROM FlujoTrabajoProcesos f")
public class FlujoTrabajoProcesos implements Serializable, ICommonFields {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FlujoTrabajoProcesosPK id;

	private String idsesion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	//uni-directional many-to-one association to FlujoTrabajo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idflujo")
	private FlujoTrabajo FlujoTrabajo;

	//uni-directional many-to-one association to Proceso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idproceso")
	private Proceso Proceso;

	public FlujoTrabajoProcesos() {
		tmstmp = new Date();
	}

	public FlujoTrabajoProcesosPK getId() {
		return this.id;
	}

	public void setId(FlujoTrabajoProcesosPK id) {
		this.id = id;
	}

	public String getIdsesion() {
		return this.idsesion;
	}

//	public void setIdsesion(String idsesion) {
//		this.idsesion = idsesion;
//	}

	public Date getTmstmp() {
		return this.tmstmp;
	}

//	public void setTmstmp(Date tmstmp) {
//		this.tmstmp = tmstmp;
//	}

	public FlujoTrabajo getFlujoTrabajo() {
		return this.FlujoTrabajo;
	}

	public void setFlujoTrabajo(FlujoTrabajo FlujoTrabajo) {
		this.FlujoTrabajo = FlujoTrabajo;
	}

	public Proceso getProceso() {
		return this.Proceso;
	}

	public void setProceso(Proceso Proceso) {
		this.Proceso = Proceso;
	}

	@Override
	public void setSesion(String sesion) {
		idsesion = sesion;
	}

	@Override
	public String setIdentificador() {
		// nothing todo
		return "";
	}

}