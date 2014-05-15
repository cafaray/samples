package com.ftc.aspel.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FacturaPartidaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CVE_DOC", nullable = false, length = 20)
    private String cveDoc;
    @Basic(optional = false)
    @Column(name = "NUM_PAR", nullable = false)
    private int numPar;

    public FacturaPartidaPK() {
    }

    public FacturaPartidaPK(String cveDoc, int numPar) {
        this.cveDoc = cveDoc;
        this.numPar = numPar;
    }

    public String getCveDoc() {
        return cveDoc;
    }

    public void setCveDoc(String cveDoc) {
        this.cveDoc = cveDoc;
    }

    public int getNumPar() {
        return numPar;
    }

    public void setNumPar(int numPar) {
        this.numPar = numPar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cveDoc != null ? cveDoc.hashCode() : 0);
        hash += (int) numPar;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaPartidaPK)) {
            return false;
        }
        FacturaPartidaPK other = (FacturaPartidaPK) object;
        if ((this.cveDoc == null && other.cveDoc != null) || (this.cveDoc != null && !this.cveDoc.equals(other.cveDoc))) {
            return false;
        }
        if (this.numPar != other.numPar) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ftc.aspel.model.FacturaPartidaPK[ cveDoc=" + cveDoc + ", numPar=" + numPar + " ]";
    }
    
}
