package com.palestra.wf.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the kwfm73t database table.
 * 
 */
@Entity
@Table(name="kwfm73t")
@NamedQuery(name="Tarea.findAll", query="SELECT t FROM Tarea t")
public class Tarea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String identificador;

	private String estatus;

	private String idsesion;

	private String idusuario;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	//uni-directional many-to-one association to Actividad
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idactividad")
	private Actividad Actividad;

	//uni-directional many-to-one association to Tramite
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idtramite")
	private Tramite Tramite;

	public Tarea() {
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

	public String getIdsesion() {
		return this.idsesion;
	}

	public void setIdsesion(String idsesion) {
		this.idsesion = idsesion;
	}

	public String getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public Date getTmstmp() {
		return this.tmstmp;
	}

	public void setTmstmp(Date tmstmp) {
		this.tmstmp = tmstmp;
	}

	public Actividad getActividad() {
		return this.Actividad;
	}

	public void setActividad(Actividad Actividad) {
		this.Actividad = Actividad;
	}

	public Tramite getTramite() {
		return this.Tramite;
	}

	public void setTramite(Tramite Tramite) {
		this.Tramite = Tramite;
	}

}