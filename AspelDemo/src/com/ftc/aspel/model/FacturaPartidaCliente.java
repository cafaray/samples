/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ftc.aspel.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author omash
 */
@Entity
@Table(name = "PAR_FACTF_CLIB01", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaPartidaCliente.findAll", query = "SELECT f FROM FacturaPartidaCliente f"),
    @NamedQuery(name = "FacturaPartidaCliente.findByClaveDoc", query = "SELECT f FROM FacturaPartidaCliente f WHERE f.facturaPartidaClientePK.claveDoc = :claveDoc"),
    @NamedQuery(name = "FacturaPartidaCliente.findByNumPart", query = "SELECT f FROM FacturaPartidaCliente f WHERE f.facturaPartidaClientePK.numPart = :numPart"),
    @NamedQuery(name = "FacturaPartidaCliente.findByCamplib1", query = "SELECT f FROM FacturaPartidaCliente f WHERE f.camplib1 = :camplib1"),
    @NamedQuery(name = "FacturaPartidaCliente.findByCamplib2", query = "SELECT f FROM FacturaPartidaCliente f WHERE f.camplib2 = :camplib2"),
    @NamedQuery(name = "FacturaPartidaCliente.findByCamplib3", query = "SELECT f FROM FacturaPartidaCliente f WHERE f.camplib3 = :camplib3"),
    @NamedQuery(name = "FacturaPartidaCliente.findByCamplib4", query = "SELECT f FROM FacturaPartidaCliente f WHERE f.camplib4 = :camplib4"),
    @NamedQuery(name = "FacturaPartidaCliente.findByCamplib5", query = "SELECT f FROM FacturaPartidaCliente f WHERE f.camplib5 = :camplib5"),
    @NamedQuery(name = "FacturaPartidaCliente.findByCamplib6", query = "SELECT f FROM FacturaPartidaCliente f WHERE f.camplib6 = :camplib6"),
    @NamedQuery(name = "FacturaPartidaCliente.findByCamplib7", query = "SELECT f FROM FacturaPartidaCliente f WHERE f.camplib7 = :camplib7"),
    @NamedQuery(name = "FacturaPartidaCliente.findByCamplib8", query = "SELECT f FROM FacturaPartidaCliente f WHERE f.camplib8 = :camplib8"),
    @NamedQuery(name = "FacturaPartidaCliente.findByCamplib9", query = "SELECT f FROM FacturaPartidaCliente f WHERE f.camplib9 = :camplib9"),
    @NamedQuery(name = "FacturaPartidaCliente.findByCamplib10", query = "SELECT f FROM FacturaPartidaCliente f WHERE f.camplib10 = :camplib10"),
    @NamedQuery(name = "FacturaPartidaCliente.findByCamplib11", query = "SELECT f FROM FacturaPartidaCliente f WHERE f.camplib11 = :camplib11"),
    @NamedQuery(name = "FacturaPartidaCliente.findByCamplib12", query = "SELECT f FROM FacturaPartidaCliente f WHERE f.camplib12 = :camplib12"),
    @NamedQuery(name = "FacturaPartidaCliente.findByCamplib13", query = "SELECT f FROM FacturaPartidaCliente f WHERE f.camplib13 = :camplib13"),
    @NamedQuery(name = "FacturaPartidaCliente.findByCamplib14", query = "SELECT f FROM FacturaPartidaCliente f WHERE f.camplib14 = :camplib14")})
public class FacturaPartidaCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FacturaPartidaClientePK facturaPartidaClientePK;
    @Column(name = "CAMPLIB1", length = 20)
    private String camplib1;
    @Column(name = "CAMPLIB2", length = 20)
    private String camplib2;
    @Column(name = "CAMPLIB3", length = 20)
    private String camplib3;
    @Column(name = "CAMPLIB4", length = 20)
    private String camplib4;
    @Column(name = "CAMPLIB5", length = 20)
    private String camplib5;
    @Column(name = "CAMPLIB6", length = 20)
    private String camplib6;
    @Column(name = "CAMPLIB7", length = 20)
    private String camplib7;
    @Column(name = "CAMPLIB8", length = 20)
    private String camplib8;
    @Column(name = "CAMPLIB9", length = 20)
    private String camplib9;
    @Column(name = "CAMPLIB10", length = 20)
    private String camplib10;
    @Column(name = "CAMPLIB11", length = 20)
    private String camplib11;
    @Column(name = "CAMPLIB12", length = 20)
    private String camplib12;
    @Column(name = "CAMPLIB13", length = 20)
    private String camplib13;
    @Column(name = "CAMPLIB14", length = 20)
    private String camplib14;

    public FacturaPartidaCliente() {
    }

    public FacturaPartidaCliente(FacturaPartidaClientePK facturaPartidaClientePK) {
        this.facturaPartidaClientePK = facturaPartidaClientePK;
    }

    public FacturaPartidaCliente(String claveDoc, int numPart) {
        this.facturaPartidaClientePK = new FacturaPartidaClientePK(claveDoc, numPart);
    }

    public FacturaPartidaClientePK getFacturaPartidaClientePK() {
        return facturaPartidaClientePK;
    }

    public void setFacturaPartidaClientePK(FacturaPartidaClientePK facturaPartidaClientePK) {
        this.facturaPartidaClientePK = facturaPartidaClientePK;
    }

    public String getCamplib1() {
        return camplib1;
    }

    public void setCamplib1(String camplib1) {
        this.camplib1 = camplib1;
    }

    public String getCamplib2() {
        return camplib2;
    }

    public void setCamplib2(String camplib2) {
        this.camplib2 = camplib2;
    }

    public String getCamplib3() {
        return camplib3;
    }

    public void setCamplib3(String camplib3) {
        this.camplib3 = camplib3;
    }

    public String getCamplib4() {
        return camplib4;
    }

    public void setCamplib4(String camplib4) {
        this.camplib4 = camplib4;
    }

    public String getCamplib5() {
        return camplib5;
    }

    public void setCamplib5(String camplib5) {
        this.camplib5 = camplib5;
    }

    public String getCamplib6() {
        return camplib6;
    }

    public void setCamplib6(String camplib6) {
        this.camplib6 = camplib6;
    }

    public String getCamplib7() {
        return camplib7;
    }

    public void setCamplib7(String camplib7) {
        this.camplib7 = camplib7;
    }

    public String getCamplib8() {
        return camplib8;
    }

    public void setCamplib8(String camplib8) {
        this.camplib8 = camplib8;
    }

    public String getCamplib9() {
        return camplib9;
    }

    public void setCamplib9(String camplib9) {
        this.camplib9 = camplib9;
    }

    public String getCamplib10() {
        return camplib10;
    }

    public void setCamplib10(String camplib10) {
        this.camplib10 = camplib10;
    }

    public String getCamplib11() {
        return camplib11;
    }

    public void setCamplib11(String camplib11) {
        this.camplib11 = camplib11;
    }

    public String getCamplib12() {
        return camplib12;
    }

    public void setCamplib12(String camplib12) {
        this.camplib12 = camplib12;
    }

    public String getCamplib13() {
        return camplib13;
    }

    public void setCamplib13(String camplib13) {
        this.camplib13 = camplib13;
    }

    public String getCamplib14() {
        return camplib14;
    }

    public void setCamplib14(String camplib14) {
        this.camplib14 = camplib14;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaPartidaClientePK != null ? facturaPartidaClientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaPartidaCliente)) {
            return false;
        }
        FacturaPartidaCliente other = (FacturaPartidaCliente) object;
        if ((this.facturaPartidaClientePK == null && other.facturaPartidaClientePK != null) || (this.facturaPartidaClientePK != null && !this.facturaPartidaClientePK.equals(other.facturaPartidaClientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ftc.aspel.model.FacturaPartidaCliente[ facturaPartidaClientePK=" + facturaPartidaClientePK + " ]";
    }
    
}
