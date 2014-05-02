package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.GeneraIdentificador;

import java.util.Date;


/**
 * The persistent class for the kwfm24t database table.
 * 
 */
@Entity
@Table(name="kwfm24t")
@NamedQueries({
@NamedQuery(name="TransicionDestino.findAll", query="SELECT t FROM TransicionDestino t"),
@NamedQuery(name="TransicionDestino.findByTransicion", query="SELECT t FROM TransicionDestino t WHERE t.Transicion = :transicion"),
})
public class TransicionDestino implements Serializable {
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
	private Transicion Transicion;

	//uni-directional many-to-one association to Actividad
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idactividad")
	private Actividad Actividad;

	public TransicionDestino() {
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
		return this.Transicion;
	}

	public void setTransicion(Transicion Transicion) {
		this.Transicion = Transicion;
	}

	public Actividad getActividad() {
		return this.Actividad;
	}

	public void setActividad(Actividad Actividad) {
		this.Actividad = Actividad;
	}

}