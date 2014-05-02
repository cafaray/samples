package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.GeneraIdentificador;

import java.util.Date;


@Entity
@Table(name="kwfm12t")
@NamedQueries({
	@NamedQuery(name="ProcesoTransiciones.findAll", query="SELECT p FROM ProcesoTransiciones p"),
	@NamedQuery(name="ProcesoTransiciones.findByProceso", query="SELECT p FROM ProcesoTransiciones p WHERE p.Proceso.identificador = :idproceso"),
	@NamedQuery(name="ProcesoTransiciones.findByActividad", 
	query="SELECT ta FROM TransicionActividad ta WHERE ta.actividad = :actividad AND ta.transicion IN (SELECT pt.Transicion FROM ProcesoTransiciones pt WHERE pt.Proceso = :proceso)")
})

public class ProcesoTransiciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String identificador;

	private String idsesion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	//uni-directional many-to-one association to Proceso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idproceso")
	private Proceso Proceso;

	//uni-directional many-to-one association to Transicion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idtransicion")
	private Transicion Transicion;

	public ProcesoTransiciones() {
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

	public Proceso getProceso() {
		return this.Proceso;
	}

	public void setProceso(Proceso Proceso) {
		this.Proceso = Proceso;
	}

	public Transicion getTransicion() {
		return this.Transicion;
	}

	public void setTransicion(Transicion Transicion) {
		this.Transicion = Transicion;
	}

}