package com.palestra.wf.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.palestra.wf.model.util.GeneraIdentificador;


/**
 * The persistent class for the kwfm70t database table.
 * 
 */
@Entity
@Table(name="kwfm70t")
@NamedQuery(name="Tramite.findAll", query="SELECT t FROM Tramite t")
public class Tramite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String identificador;

	private String estatus;

	private String idbotramite;

	private String idsesion;

	private String idusuario;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	private int version;

	//uni-directional many-to-one association to FlujoTrabajo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="idflujo", referencedColumnName="identificador"),
		@JoinColumn(name="idflujo", referencedColumnName="version")
	})
	private FlujoTrabajo FlujoTrabajo;

	public Tramite() {
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
	
	public String getEstatus() {
		return this.estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getIdbotramite() {
		return this.idbotramite;
	}

	public void setIdbotramite(String idbotramite) {
		this.idbotramite = idbotramite;
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

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public FlujoTrabajo getFlujoTrabajo() {
		return this.FlujoTrabajo;
	}

	public void setFlujoTrabajo(FlujoTrabajo FlujoTrabajo) {
		this.FlujoTrabajo = FlujoTrabajo;
	}

}