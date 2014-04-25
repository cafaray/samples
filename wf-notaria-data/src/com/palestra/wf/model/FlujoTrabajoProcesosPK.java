package com.palestra.wf.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the kwfm01t database table.
 * 
 */
@Embeddable
public class FlujoTrabajoProcesosPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String idflujo;

	@Column(insertable=false, updatable=false)
	private String idproceso;

	public FlujoTrabajoProcesosPK() {
	}
	
	public FlujoTrabajoProcesosPK(String idFlujo, String idProceso) {
		this.idflujo = idFlujo;
		this.idproceso = idProceso;
	}
	
	public String getIdflujo() {
		return this.idflujo;
	}
	public void setIdflujo(String idflujo) {
		this.idflujo = idflujo;
	}
	public String getIdproceso() {
		return this.idproceso;
	}
	public void setIdproceso(String idproceso) {
		this.idproceso = idproceso;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FlujoTrabajoProcesosPK)) {
			return false;
		}
		FlujoTrabajoProcesosPK castOther = (FlujoTrabajoProcesosPK)other;
		return 
			this.idflujo.equals(castOther.idflujo)
			&& this.idproceso.equals(castOther.idproceso);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idflujo.hashCode();
		hash = hash * prime + this.idproceso.hashCode();
		
		return hash;
	}
}