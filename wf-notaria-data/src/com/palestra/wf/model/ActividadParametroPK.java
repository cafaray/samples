package com.palestra.wf.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the kwfm63t database table.
 * 
 */
@Embeddable
public class ActividadParametroPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String idactividad;

	@Column(insertable=false, updatable=false)
	private String idparametro;

	public ActividadParametroPK() {
	}
	public String getIdactividad() {
		return this.idactividad;
	}
	public void setIdactividad(String idactividad) {
		this.idactividad = idactividad;
	}
	public String getIdparametro() {
		return this.idparametro;
	}
	public void setIdparametro(String idparametro) {
		this.idparametro = idparametro;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ActividadParametroPK)) {
			return false;
		}
		ActividadParametroPK castOther = (ActividadParametroPK)other;
		return 
			this.idactividad.equals(castOther.idactividad)
			&& this.idparametro.equals(castOther.idparametro);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idactividad.hashCode();
		hash = hash * prime + this.idparametro.hashCode();
		
		return hash;
	}
}