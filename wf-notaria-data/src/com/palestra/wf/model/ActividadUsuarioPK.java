package com.palestra.wf.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the kwfm83t database table.
 * 
 */
@Embeddable
public class ActividadUsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String idactividad;

	@Column(insertable=false, updatable=false)
	private String idusuario;

	public ActividadUsuarioPK() {
	}
	
	public ActividadUsuarioPK(String idActividad, String idUsuario) {
		this.idactividad = idActividad;
		this.idusuario = idUsuario;
	}
	
	public String getIdactividad() {
		return this.idactividad;
	}
	public void setIdactividad(String idactividad) {
		this.idactividad = idactividad;
	}
	public String getIdusuario() {
		return this.idusuario;
	}
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ActividadUsuarioPK)) {
			return false;
		}
		ActividadUsuarioPK castOther = (ActividadUsuarioPK)other;
		return 
			this.idactividad.equals(castOther.idactividad)
			&& this.idusuario.equals(castOther.idusuario);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idactividad.hashCode();
		hash = hash * prime + this.idusuario.hashCode();
		
		return hash;
	}
}