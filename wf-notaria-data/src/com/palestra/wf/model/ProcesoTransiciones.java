package com.palestra.wf.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the kwfm12t database table.
 * 
 */
@Entity
@Table(name="kwfm12t")
@NamedQuery(name="ProcesoTransiciones.findAll", query="SELECT p FROM ProcesoTransiciones p")
public class ProcesoTransiciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProcesoTransicionesPK id;

	private String idsesion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	//uni-directional many-to-one association to Proceso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idproceso")
	private Proceso Proceso;

	//uni-directional many-to-one association to Transicion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idtransicion")
	private Transicion Transicion;

	public ProcesoTransiciones() {
	}

	public ProcesoTransicionesPK getId() {
		return this.id;
	}

	public void setId(ProcesoTransicionesPK id) {
		this.id = id;
	}

	public String getIdsesion() {
		return this.idsesion;
	}

	public void setIdsesion(String idsesion) {
		this.idsesion = idsesion;
	}

	public Date getTmstmp() {
		return this.tmstmp;
	}

	public void setTmstmp(Date tmstmp) {
		this.tmstmp = tmstmp;
	}

	public Proceso getProceso() {
		return this.Proceso;
	}

	public void setProceso(Proceso Proceso) {
		this.Proceso = Proceso;
	}

	public Transicion getTransicion() {
		return this.Transicion;
	}

	public void setTransicion(Transicion Transicion) {
		this.Transicion = Transicion;
	}

}