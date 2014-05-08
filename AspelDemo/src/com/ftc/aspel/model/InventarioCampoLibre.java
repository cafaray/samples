package com.ftc.aspel.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "INVE_CLIB01", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioCampoLibre.findAll", query = "SELECT i FROM InventarioCampoLibre i"),
    @NamedQuery(name = "InventarioCampoLibre.findByCveProd", query = "SELECT i FROM InventarioCampoLibre i WHERE i.cveProd = :cveProd"),
    @NamedQuery(name = "InventarioCampoLibre.findByCamplib1", query = "SELECT i FROM InventarioCampoLibre i WHERE i.camplib1 = :camplib1"),
    @NamedQuery(name = "InventarioCampoLibre.findByCamplib2", query = "SELECT i FROM InventarioCampoLibre i WHERE i.camplib2 = :camplib2"),
    @NamedQuery(name = "InventarioCampoLibre.findByCamplib3", query = "SELECT i FROM InventarioCampoLibre i WHERE i.camplib3 = :camplib3"),
    @NamedQuery(name = "InventarioCampoLibre.findByCamplib4", query = "SELECT i FROM InventarioCampoLibre i WHERE i.camplib4 = :camplib4"),
    @NamedQuery(name = "InventarioCampoLibre.findByCamplib5", query = "SELECT i FROM InventarioCampoLibre i WHERE i.camplib5 = :camplib5"),
    @NamedQuery(name = "InventarioCampoLibre.findByCamplib6", query = "SELECT i FROM InventarioCampoLibre i WHERE i.camplib6 = :camplib6"),
    @NamedQuery(name = "InventarioCampoLibre.findByCamplib7", query = "SELECT i FROM InventarioCampoLibre i WHERE i.camplib7 = :camplib7")})
public class InventarioCampoLibre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CVE_PROD", nullable = false, length = 16)
    private String cveProd;
    @Column(name = "CAMPLIB1", length = 15)
    private String camplib1;
    @Column(name = "CAMPLIB2", length = 20)
    private String camplib2;
    @Column(name = "CAMPLIB3", length = 25)
    private String camplib3;
    @Column(name = "CAMPLIB4")
    private Integer camplib4;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CAMPLIB5", precision = 15)
    private Double camplib5;
    @Column(name = "CAMPLIB6", precision = 15)
    private Double camplib6;
    @Column(name = "CAMPLIB7")
    private Integer camplib7;

    public InventarioCampoLibre() {
    }

    public InventarioCampoLibre(String cveProd) {
        this.cveProd = cveProd;
    }

    public String getCveProd() {
        return cveProd;
    }

    public void setCveProd(String cveProd) {
        this.cveProd = cveProd;
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

    public Integer getCamplib4() {
        return camplib4;
    }

    public void setCamplib4(Integer camplib4) {
        this.camplib4 = camplib4;
    }

    public Double getCamplib5() {
        return camplib5;
    }

    public void setCamplib5(Double camplib5) {
        this.camplib5 = camplib5;
    }

    public Double getCamplib6() {
        return camplib6;
    }

    public void setCamplib6(Double camplib6) {
        this.camplib6 = camplib6;
    }

    public Integer getCamplib7() {
        return camplib7;
    }

    public void setCamplib7(Integer camplib7) {
        this.camplib7 = camplib7;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cveProd != null ? cveProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioCampoLibre)) {
            return false;
        }
        InventarioCampoLibre other = (InventarioCampoLibre) object;
        if ((this.cveProd == null && other.cveProd != null) || (this.cveProd != null && !this.cveProd.equals(other.cveProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ftc.aspel.model.Inventario[ cveProd=" + cveProd + " ]";
    }
    
}
