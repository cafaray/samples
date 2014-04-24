package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.ICommonFields;

import java.util.Date;

/**
 * The persistent class for the kwfm93t database table.
 * 
 */
@Entity
@Table(name = "kwfm93t")
@NamedQuery(name = "ActividadRol.findAll", query = "SELECT a FROM ActividadRol a")
public class ActividadRol implements Serializable, ICommonFields {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ActividadRolPK id;

	private String idsesion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	// uni-directional many-to-one association to Rol
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idrol")
	private Rol Rol;

	// uni-directional many-to-one association to Actividad
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idactividad")
	private Actividad Actividad;

	public ActividadRol() {
		tmstmp = new Date();
	}

	public ActividadRolPK getId() {
		return this.id;
	}

	public void setId(ActividadRolPK id) {
		this.id = id;
	}

	public String getIdsesion() {
		return this.idsesion;
	}

	// public void setIdsesion(String idsesion) {
	// this.idsesion = idsesion;
	// }

	public Date getTmstmp() {
		return this.tmstmp;
	}

	// public void setTmstmp(Date tmstmp) {
	// this.tmstmp = tmstmp;
	// }

	public Rol getRol() {
		return this.Rol;
	}

	public void setRol(Rol Rol) {
		this.Rol = Rol;
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