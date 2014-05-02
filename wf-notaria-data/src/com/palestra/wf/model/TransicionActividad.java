package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.GeneraIdentificador;

import java.util.Date;


/**
 * The persistent class for the kwfm23t database table.
 * 
 */
@Entity
@Table(name="kwfm23t")
@NamedQueries({
	@NamedQuery(name="TransicionActividad.findAll", query="SELECT t FROM TransicionActividad t"),
	@NamedQuery(name="TransicionActividad.findByActividad", query="SELECT t FROM TransicionActividad t WHERE t.actividad = :actividad")
})

public class TransicionActividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String identificador;

	private String idsesion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	//uni-directional many-to-one association to Transicion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idtransicion")
	private Transicion transicion;

	//uni-directional many-to-one association to Actividad
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idactividad")
	private Actividad actividad;

	public TransicionActividad() {
		tmstmp = new Date();
		idsesion = "";
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String setIdentificador(){
		this.identificador =GeneraIdentificador.toMD5(); 
		return this.identificador;
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

	public Transicion getTransicion() {
		return this.transicion;
	}

	public void setTransicion(Transicion Transicion) {
		this.transicion = Transicion;
	}

	public Actividad getActividad() {
		return this.actividad;
	}

	public void setActividad(Actividad Actividad) {
		this.actividad = Actividad;
	}

}