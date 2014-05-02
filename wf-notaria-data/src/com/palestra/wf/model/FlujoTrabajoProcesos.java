package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.GeneraIdentificador;

import java.util.Date;


/**
 * The persistent class for the kwfm01t database table.
 * 
 */
@Entity
@Table(name="kwfm01t")
@NamedQueries({
	@NamedQuery(name="FlujoTrabajoProcesos.findAll", query="SELECT f FROM FlujoTrabajoProcesos f"),
	@NamedQuery(name="FlujoTrabajoProcesos.findByProceso", query="SELECT f FROM FlujoTrabajoProcesos f "
			+ "WHERE f.flujoTrabajo.id.identificador = :idproceso AND f.flujoTrabajo.id.version = :version")	
})

public class FlujoTrabajoProcesos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String identificador;

	private String idsesion;

	private int posicion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	private int version;

	//uni-directional many-to-one association to FlujoTrabajo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="idflujo", referencedColumnName="identificador"),
		@JoinColumn(name="idflujo", referencedColumnName="version")
	})
	private FlujoTrabajo flujoTrabajo;

	//uni-directional many-to-one association to Proceso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idproceso")
	private Proceso Proceso;

	public FlujoTrabajoProcesos() {
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

	public int getPosicion() {
		return this.posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
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
		return this.flujoTrabajo;
	}

	public void setFlujoTrabajo(FlujoTrabajo FlujoTrabajo) {
		this.flujoTrabajo = FlujoTrabajo;
	}

	public Proceso getProceso() {
		return this.Proceso;
	}

	public void setProceso(Proceso Proceso) {
		this.Proceso = Proceso;
	}

}