package com.palestra.wf.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

import com.palestra.wf.model.util.GeneratedValues;
import com.palestra.wf.model.util.ICommonFields;

/**
 * The persistent class for the kwfm70t database table.
 * 
 */
@Entity
@Table(name = "kwfm70t")
@NamedQuery(name = "Tramite.findAll", query = "SELECT t FROM Tramite t")
public class Tramite implements Serializable, ICommonFields {
	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	private String identificador;

	private String estatus;

	private String idsesion;

	private String idtramite;

	private String idusuario;

	private String tmstmp;

	// uni-directional many-to-one association to FlujoTrabajo
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idflujo")
	private FlujoTrabajo FlujoTrabajo;

	public Tramite() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"dd/MM/yyyy HH:mm:ss");
		tmstmp = dateFormat.format(new Date());
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getEstatus() {
		return this.estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public String getIdsesion() {
		return this.idsesion;
	}

	// public void setIdsesion(String idsesion) {
	// this.idsesion = idsesion;
	// }

	public String getIdtramite() {
		return this.idtramite;
	}

	public void setIdtramite(String idtramite) {
		this.idtramite = idtramite;
	}

	public String getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public String getTmstmp() {
		return this.tmstmp;
	}

	// public void setTmstmp(String tmstmp) {
	// this.tmstmp = tmstmp;
	// }

	public FlujoTrabajo getFlujoTrabajo() {
		return this.FlujoTrabajo;
	}

	public void setFlujoTrabajo(FlujoTrabajo FlujoTrabajo) {
		this.FlujoTrabajo = FlujoTrabajo;
	}

	@Override
	public void setSesion(String sesion) {
		idsesion = sesion;
	}

	@Override
	public String setIdentificador() {
		if (identificador == null) {
			identificador = GeneratedValues.toMD5();
		} else {
			// nothing to do ...
		}
		return identificador;
	}

}