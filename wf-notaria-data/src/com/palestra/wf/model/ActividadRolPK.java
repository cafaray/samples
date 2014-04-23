package com.palestra.wf.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the kwfm93t database table.
 * 
 */
@Embeddable
public class ActividadRolPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String idactividad;

	@Column(insertable=false, updatable=false)
	private String idrol;

	public ActividadRolPK() {
	}
	public String getIdactividad() {
		return this.idactividad;
	}
	public void setIdactividad(String idactividad) {
		this.idactividad = idactividad;
	}
	public String getIdrol() {
		return this.idrol;
	}
	public void setIdrol(String idrol) {
		this.idrol = idrol;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ActividadRolPK)) {
			return false;
		}
		ActividadRolPK castOther = (ActividadRolPK)other;
		return 
			this.idactividad.equals(castOther.idactividad)
			&& this.idrol.equals(castOther.idrol);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idactividad.hashCode();
		hash = hash * prime + this.idrol.hashCode();
		
		return hash;
	}
}