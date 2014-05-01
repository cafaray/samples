package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.GeneraIdentificador;

import java.util.Date;


/**
 * The persistent class for the kwfm10t database table.
 * 
 */
@Entity
@Table(name="kwfm10t")
@NamedQuery(name="Proceso.findAll", query="SELECT p FROM Proceso p")
public class Proceso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String identificador;

	private String descripcion;

	private String idsesion;

	private String nombre;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	public Proceso() {
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
	
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdsesion() {
		return this.idsesion;
	}

	public void setIdsesion(String idsesion) {
		this.idsesion = idsesion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getTmstmp() {
		return this.tmstmp;
	}

	public void setTmstmp(Date tmstmp) {
		this.tmstmp = tmstmp;
	}

}