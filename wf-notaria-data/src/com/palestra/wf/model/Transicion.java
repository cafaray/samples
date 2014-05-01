package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.GeneraIdentificador;

import java.util.Date;


/**
 * The persistent class for the kwfm20t database table.
 * 
 */
@Entity
@Table(name="kwfm20t")
@NamedQuery(name="Transicion.findAll", query="SELECT t FROM Transicion t")
public class Transicion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String identificador;

	private String idsesion;

	private String nombre;

	private String tipodestino;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	public Transicion() {
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipodestino() {
		return this.tipodestino;
	}

	public void setTipodestino(String tipodestino) {
		this.tipodestino = tipodestino;
	}

	public Date getTmstmp() {
		return this.tmstmp;
	}

	public void setTmstmp(Date tmstmp) {
		this.tmstmp = tmstmp;
	}

}