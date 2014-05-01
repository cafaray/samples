package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.GeneraIdentificador;

import java.util.Date;


/**
 * The persistent class for the kwfm76t database table.
 * 
 */
@Entity
@Table(name="kwfm76t")
@NamedQuery(name="TareaParametro.findAll", query="SELECT t FROM TareaParametro t")
public class TareaParametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String identificador;

	private String idsesion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	private String valparametro;

	//uni-directional many-to-one association to Parametro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idparametro")
	private Parametro Parametro;

	//uni-directional many-to-one association to Tarea
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idtarea")
	private Tarea TareaActividad;

	public TareaParametro() {
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

	public Date getTmstmp() {
		return this.tmstmp;
	}

	public void setTmstmp(Date tmstmp) {
		this.tmstmp = tmstmp;
	}

	public String getValparametro() {
		return this.valparametro;
	}

	public void setValparametro(String valparametro) {
		this.valparametro = valparametro;
	}

	public Parametro getParametro() {
		return this.Parametro;
	}

	public void setParametro(Parametro Parametro) {
		this.Parametro = Parametro;
	}

	public Tarea getTareaActividad() {
		return this.TareaActividad;
	}

	public void setTareaActividad(Tarea TareaActividad) {
		this.TareaActividad = TareaActividad;
	}

}