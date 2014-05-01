package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.GeneraIdentificador;

import java.util.Date;


/**
 * The persistent class for the kwfm30t database table.
 * 
 */
@Entity
@Table(name="kwfm30t")
@NamedQuery(name="Actividad.findAll", query="SELECT a FROM Actividad a")
public class Actividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String identificador;

	private String descripcion;

	private String idsesion;

	private String nombre;

	private int tiempolmt;

	private int tiempostd;

	private String tipoAccion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	public Actividad() {
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

	public int getTiempolmt() {
		return this.tiempolmt;
	}

	public void setTiempolmt(int tiempolmt) {
		this.tiempolmt = tiempolmt;
	}

	public int getTiempostd() {
		return this.tiempostd;
	}

	public void setTiempostd(int tiempostd) {
		this.tiempostd = tiempostd;
	}

	public String getTipoAccion() {
		return this.tipoAccion;
	}

	public void setTipoAccion(String tipoAccion) {
		this.tipoAccion = tipoAccion;
	}

	public Date getTmstmp() {
		return this.tmstmp;
	}

	public void setTmstmp(Date tmstmp) {
		this.tmstmp = tmstmp;
	}

}