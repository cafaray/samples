package com.palestra.wf.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the kwfm76t database table.
 * 
 */
@Embeddable
public class TareaParametroPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private String idtarea;

	@Column(insertable=false, updatable=false)
	private String idparametro;

	public TareaParametroPK() {
	}
	public String getIdtarea() {
		return this.idtarea;
	}
	public void setIdtarea(String idtarea) {
		this.idtarea = idtarea;
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
		if (!(other instanceof TareaParametroPK)) {
			return false;
		}
		TareaParametroPK castOther = (TareaParametroPK)other;
		return 
			this.idtarea.equals(castOther.idtarea)
			&& this.idparametro.equals(castOther.idparametro);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idtarea.hashCode();
		hash = hash * prime + this.idparametro.hashCode();
		
		return hash;
	}
}