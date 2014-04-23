package com.palestra.wf.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the kwfm12t database table.
 * 
 */
@Embeddable
public class ProcesoTransicionesPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String idproceso;

	@Column(insertable=false, updatable=false)
	private String idtransicion;

	public ProcesoTransicionesPK() {
	}
	public String getIdproceso() {
		return this.idproceso;
	}
	public void setIdproceso(String idproceso) {
		this.idproceso = idproceso;
	}
	public String getIdtransicion() {
		return this.idtransicion;
	}
	public void setIdtransicion(String idtransicion) {
		this.idtransicion = idtransicion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProcesoTransicionesPK)) {
			return false;
		}
		ProcesoTransicionesPK castOther = (ProcesoTransicionesPK)other;
		return 
			this.idproceso.equals(castOther.idproceso)
			&& this.idtransicion.equals(castOther.idtransicion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idproceso.hashCode();
		hash = hash * prime + this.idtransicion.hashCode();
		
		return hash;
	}
}