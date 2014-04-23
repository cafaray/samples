package com.palestra.wf.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the kwfm62t database table.
 * 
 */
@Entity
@Table(name="kwfm62t")
@NamedQuery(name="TransicionDestinoParametro.findAll", query="SELECT t FROM TransicionDestinoParametro t")
public class TransicionDestinoParametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TransicionDestinoParametroPK id;

	private String idsesion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date tmstmp;

	//uni-directional many-to-one association to Parametro
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idparametro")
	private Parametro Parametro;

	//uni-directional many-to-one association to TransicionDestino
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idtransdest")
	private TransicionDestino TransicionDestino;

	public TransicionDestinoParametro() {
	}

	public TransicionDestinoParametroPK getId() {
		return this.id;
	}

	public void setId(TransicionDestinoParametroPK id) {
		this.id = id;
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

	public Parametro getParametro() {
		return this.Parametro;
	}

	public void setParametro(Parametro Parametro) {
		this.Parametro = Parametro;
	}

	public TransicionDestino getTransicionDestino() {
		return this.TransicionDestino;
	}

	public void setTransicionDestino(TransicionDestino TransicionDestino) {
		this.TransicionDestino = TransicionDestino;
	}

}