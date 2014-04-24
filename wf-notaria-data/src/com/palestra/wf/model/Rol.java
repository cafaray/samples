package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.GeneratedValues;
import com.palestra.wf.model.util.ICommonFields;

import java.util.Date;


/**
 * The persistent class for the kwfm90t database table.
 * 
 */
@Entity
@Table(name="kwfm90t")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable, ICommonFields {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String identificador;

	private String descripcion;

	private String idrol;

	private String idsesion;

	private String prefijo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	public Rol() {
		tmstmp = new Date();
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	//public void setIdsesion(String idsesion) {
	//	this.idsesion = idsesion;
	//}

	public String getPrefijo() {
		return this.prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	public Date getTmstmp() {
		return this.tmstmp;
	}

	//public void setTmstmp(Date tmstmp) {
	//	this.tmstmp = tmstmp;
	//}

	@Override
	public void setSesion(String sesion) {
		this.idsesion = sesion;
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