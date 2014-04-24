package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.GeneratedValues;
import com.palestra.wf.model.util.ICommonFields;

import java.util.Date;

/**
 * The persistent class for the kwfm23t database table.
 * 
 */
@Entity
@Table(name = "kwfm23t")
@NamedQuery(name = "TransicionActividad.findAll", query = "SELECT t FROM TransicionActividad t")
public class TransicionActividad implements Serializable, ICommonFields {
	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	private String identificador;

	private String idsesion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	// uni-directional many-to-one association to Actividad
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idactividad")
	private Actividad Actividad;

	// uni-directional many-to-one association to Transicion
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idtransicion")
	private Transicion Transicion;

	public TransicionActividad() {
		tmstmp = new Date();
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
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

	public Actividad getActividad() {
		return this.Actividad;
	}

	public void setActividad(Actividad Actividad) {
		this.Actividad = Actividad;
	}

	public Transicion getTransicion() {
		return this.Transicion;
	}

	public void setTransicion(Transicion Transicion) {
		this.Transicion = Transicion;
	}

	@Override
	public void setSesion(String sesion) {
		idsesion = sesion;
	}

	@Override
	public String setIdentificador() {
		if (identificador == null) {
			identificador = GeneratedValues.toMD5();
		} else {
			// nothing to do ...
		}
		return identificador;
	}

}