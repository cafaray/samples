package com.palestra.wf.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the kwfm00t database table.
 * 
 */
@Entity
@Table(name="kwfm00t")
@NamedQuery(name="FlujoTrabajo.findAll", query="SELECT f FROM FlujoTrabajo f")
public class FlujoTrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String identificador;

	private String estatus;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaTermino;

	private String idsesion;

	private String nombre;

	private String publicado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	private int version;

	public FlujoTrabajo() {
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getEstatus() {
		return this.estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaTermino() {
		return this.fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
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

	public String getPublicado() {
		return this.publicado;
	}

	public void setPublicado(String publicado) {
		this.publicado = publicado;
	}

	public Date getTmstmp() {
		return this.tmstmp;
	}

	public void setTmstmp(Date tmstmp) {
		this.tmstmp = tmstmp;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}