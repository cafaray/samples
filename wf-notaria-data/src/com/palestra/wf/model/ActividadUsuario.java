package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.GeneraIdentificador;

import java.util.Date;

/**
 * The persistent class for the kwfm83t database table.
 * 
 */
@Entity
@Table(name = "kwfm83t")
@NamedQuery(name = "ActividadUsuario.findAll", query = "SELECT a FROM ActividadUsuario a")
public class ActividadUsuario implements Serializable {
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

	// uni-directional many-to-one association to Usuario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idusuario")
	private Usuario Usuario;

	public ActividadUsuario() {
		tmstmp = new Date();
		idsesion = "";
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String setIdentificador() {
		this.identificador = GeneraIdentificador.toMD5();
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

	public Actividad getActividad() {
		return this.Actividad;
	}

	public void setActividad(Actividad Actividad) {
		this.Actividad = Actividad;
	}

	public Usuario getUsuario() {
		return this.Usuario;
	}

	public void setUsuario(Usuario Usuario) {
		this.Usuario = Usuario;
	}

}