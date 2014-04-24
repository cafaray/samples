package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.ICommonFields;

import java.util.Date;


/**
 * The persistent class for the kwfm63t database table.
 * 
 */
@Entity
@Table(name="kwfm63t")
@NamedQuery(name="ActividadParametro.findAll", query="SELECT a FROM ActividadParametro a")
public class ActividadParametro implements Serializable, ICommonFields {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ActividadParametroPK id;

	private String idsesion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	//uni-directional many-to-one association to Parametro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idparametro")
	private Parametro Parametro;

	//uni-directional many-to-one association to Actividad
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idactividad")
	private Actividad Actividad;

	public ActividadParametro() {
		tmstmp = new Date();
	}

	public ActividadParametroPK getId() {
		return this.id;
	}

	public void setId(ActividadParametroPK id) {
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

	public Parametro getParametro() {
		return this.Parametro;
	}

	public void setParametro(Parametro Parametro) {
		this.Parametro = Parametro;
	}

	public Actividad getActividad() {
		return this.Actividad;
	}

	public void setActividad(Actividad Actividad) {
		this.Actividad = Actividad;
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