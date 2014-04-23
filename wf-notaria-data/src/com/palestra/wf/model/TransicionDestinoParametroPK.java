package com.palestra.wf.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the kwfm62t database table.
 * 
 */
@Embeddable
public class TransicionDestinoParametroPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String idtransdest;

	@Column(insertable=false, updatable=false)
	private String idparametro;

	public TransicionDestinoParametroPK() {
	}
	public String getIdtransdest() {
		return this.idtransdest;
	}
	public void setIdtransdest(String idtransdest) {
		this.idtransdest = idtransdest;
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
		if (!(other instanceof TransicionDestinoParametroPK)) {
			return false;
		}
		TransicionDestinoParametroPK castOther = (TransicionDestinoParametroPK)other;
		return 
			this.idtransdest.equals(castOther.idtransdest)
			&& this.idparametro.equals(castOther.idparametro);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idtransdest.hashCode();
		hash = hash * prime + this.idparametro.hashCode();
		
		return hash;
	}
}