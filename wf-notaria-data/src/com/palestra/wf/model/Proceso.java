package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.GeneratedValues;
import com.palestra.wf.model.util.ICommonFields;

import java.util.Date;

/**
 * The persistent class for the kwfm10t database table.
 * 
 */
@Entity
@Table(name = "kwfm10t")
@NamedQuery(name = "Proceso.findAll", query = "SELECT p FROM Proceso p")
public class Proceso implements Serializable, ICommonFields {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String identificador;

	private String archivo;

	private String descripcion;

	private String idsesion;

	private String nombre;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	public Proceso() {
		tmstmp = new Date();
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getArchivo() {
		return this.archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
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

	// public void setIdsesion(String idsesion) {
	// this.idsesion = idsesion;
	// }

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getTmstmp() {
		return this.tmstmp;
	}

	// public void setTmstmp(Date tmstmp) {
	// this.tmstmp = tmstmp;
	// }

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