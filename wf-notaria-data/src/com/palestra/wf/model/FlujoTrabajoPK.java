package com.palestra.wf.model;

import java.io.Serializable;

import javax.persistence.*;

import com.palestra.wf.model.util.GeneratedValues;

/**
 * The primary key class for the kwfm00t database table.
 * 
 */
@Embeddable
public class FlujoTrabajoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String identificador;

	private int version;

	public FlujoTrabajoPK() {
		this.identificador = GeneratedValues.toMD5();
		this.version = 0;
	}
	
	public FlujoTrabajoPK(String identificador, int version){
		this.identificador = identificador;
		this.version = version;
	}
	
	public String getIdentificador() {
		return this.identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public int getVersion() {
		return this.version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FlujoTrabajoPK)) {
			return false;
		}
		FlujoTrabajoPK castOther = (FlujoTrabajoPK)other;
		return 
			this.identificador.equals(castOther.identificador)
			&& (this.version == castOther.version);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.identificador.hashCode();
		hash = hash * prime + this.version;
		
		return hash;
	}
}