package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.GeneratedValues;
import com.palestra.wf.model.util.ICommonFields;

import java.util.Date;


/**
 * The persistent class for the kwfm50t database table.
 * 
 */
@Entity
@Table(name="kwfm50t")
@NamedQuery(name="Comentario.findAll", query="SELECT c FROM Comentario c")
public class Comentario implements Serializable, ICommonFields {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String identificador;

	private String comentario;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private String idsesion;

	private String idusuario;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	//uni-directional many-to-one association to Tarea
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idtarea")
	private Tarea Tarea;

	public Comentario() {
		tmstmp = new Date();
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public Date getTmstmp() {
		return this.tmstmp;
	}

//	public void setTmstmp(Date tmstmp) {
//		this.tmstmp = tmstmp;
//	}

	public Tarea getTarea() {
		return this.Tarea;
	}

	public void setTarea(Tarea Tarea) {
		this.Tarea = Tarea;
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