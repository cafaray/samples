/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ftc.aspel.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author omash
 */
@Embeddable
public class FacturaPartidaClientePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CLAVE_DOC", nullable = false, length = 20)
    private String claveDoc;
    @Basic(optional = false)
    @Column(name = "NUM_PART", nullable = false)
    private int numPart;

    public FacturaPartidaClientePK() {
    }

    public FacturaPartidaClientePK(String claveDoc, int numPart) {
        this.claveDoc = claveDoc;
        this.numPart = numPart;
    }

    public String getClaveDoc() {
        return claveDoc;
    }

    public void setClaveDoc(String claveDoc) {
        this.claveDoc = claveDoc;
    }

    public int getNumPart() {
        return numPart;
    }

    public void setNumPart(int numPart) {
        this.numPart = numPart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (claveDoc != null ? claveDoc.hashCode() : 0);
        hash += (int) numPart;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaPartidaClientePK)) {
            return false;
        }
        FacturaPartidaClientePK other = (FacturaPartidaClientePK) object;
        if ((this.claveDoc == null && other.claveDoc != null) || (this.claveDoc != null && !this.claveDoc.equals(other.claveDoc))) {
            return false;
        }
        if (this.numPart != other.numPart) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ftc.aspel.model.FacturaPartidaClientePK[ claveDoc=" + claveDoc + ", numPart=" + numPart + " ]";
    }
    
}
