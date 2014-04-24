package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.GeneratedValues;
import com.palestra.wf.model.util.ICommonFields;

import java.util.Date;


/**
 * The persistent class for the kwfm80t database table.
 * 
 */
@Entity
@Table(name="kwfm80t")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")


public class Usuario implements Serializable, ICommonFields {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String identificador;

	private String cuenta;

	private String esActivo;

	private String idrol;

	private String idsesion;

	private String idusuario;

	private String iniciales;

	private String nombre;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaActualizacion;

	public Usuario() {
		tmstmp = new Date();
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getEsActivo() {
		return this.esActivo;
	}

	public void setEsActivo(String esActivo) {
		this.esActivo = esActivo;
	}

	public String getIdrol() {
		return this.idrol;
	}

	public void setIdrol(String idrol) {
		this.idrol = idrol;
	}

	public String getIdsesion() {
		return this.idsesion;
	}

//	public void setIdsesion(String idsesion) {
//		this.idsesion = idsesion;
//	}

	public String getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getIniciales() {
		return this.iniciales;
	}

	public void setIniciales(String iniciales) {
		this.iniciales = iniciales;
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

//	public void setTmstmp(Date tmstmp) {
//		this.tmstmp = tmstmp;
//	}

	public Date getUltimaActualizacion() {
		return this.ultimaActualizacion;
	}

	public void setUltimaActualizacion(Date ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}

	@Override
	public void setSesion(String sesion) {
		idsesion = sesion;
	}

	@Override
	public String setIdentificador() {
		if(identificador==null){
			identificador = GeneratedValues.toMD5();
		}else{
			//nothing to do ...
		}
		return identificador;
	}

}