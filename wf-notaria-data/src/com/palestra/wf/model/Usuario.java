package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.GeneraIdentificador;

import java.util.Date;


/**
 * The persistent class for the kwfm80t database table.
 * 
 */
@Entity
@Table(name="kwfm80t")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String identificador;

	private String bocuenta;

	private String boiniciales;

	private String bonombre;

	private String esActivo;

	private String idbousuario;

	private String idsesion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaActualizacion;

	//bi-directional many-to-one association to Rol
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idrol")
	private Rol Rol;

	public Usuario() {
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
	
	public String getBocuenta() {
		return this.bocuenta;
	}

	public void setBocuenta(String bocuenta) {
		this.bocuenta = bocuenta;
	}

	public String getBoiniciales() {
		return this.boiniciales;
	}

	public void setBoiniciales(String boiniciales) {
		this.boiniciales = boiniciales;
	}

	public String getBonombre() {
		return this.bonombre;
	}

	public void setBonombre(String bonombre) {
		this.bonombre = bonombre;
	}

	public String getEsActivo() {
		return this.esActivo;
	}

	public void setEsActivo(String esActivo) {
		this.esActivo = esActivo;
	}

	public String getIdbousuario() {
		return this.idbousuario;
	}

	public void setIdbousuario(String idbousuario) {
		this.idbousuario = idbousuario;
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

	public Date getUltimaActualizacion() {
		return this.ultimaActualizacion;
	}

	public void setUltimaActualizacion(Date ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}

	public Rol getRol() {
		return this.Rol;
	}

	public void setRol(Rol Rol) {
		this.Rol = Rol;
	}

}