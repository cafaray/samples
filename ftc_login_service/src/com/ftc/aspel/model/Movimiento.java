/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ftc.aspel.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author omash
 */
@Entity
@Table(name = "ksae10t")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m"),
    @NamedQuery(name = "Movimiento.findByIdnummov", query = "SELECT m FROM Movimiento m WHERE m.idnummov = :idnummov"),
    @NamedQuery(name = "Movimiento.findByCddocume", query = "SELECT m FROM Movimiento m WHERE m.cddocume = :cddocume"),
    @NamedQuery(name = "Movimiento.findByCddocpar", query = "SELECT m FROM Movimiento m WHERE m.cddocpar = :cddocpar"),
    @NamedQuery(name = "Movimiento.findByDbimport", query = "SELECT m FROM Movimiento m WHERE m.dbimport = :dbimport"),
    @NamedQuery(name = "Movimiento.findByInstatus", query = "SELECT m FROM Movimiento m WHERE m.instatus = :instatus"),
    @NamedQuery(name = "Movimiento.findByIdnumcoi", query = "SELECT m FROM Movimiento m WHERE m.idnumcoi = :idnumcoi"),
    @NamedQuery(name = "Movimiento.findByTmstmp", query = "SELECT m FROM Movimiento m WHERE m.tmstmp = :tmstmp")})
public class Movimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnummov")
    private Integer idnummov;
    @Basic(optional = false)
    @Column(name = "cddocume")
    private String cddocume;
    @Basic(optional = false)
    @Column(name = "cddocpar")
    private int cddocpar;
    @Basic(optional = false)
    @Column(name = "dbimport")
    private double dbimport;
    @Basic(optional = false)
    @Column(name = "instatus")
    private String instatus;
    @Column(name = "idnumcoi")
    private String idnumcoi;
    @Basic(optional = false)
    @Column(name = "tmstmp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmstmp;
    @JoinColumn(name = "idusuari", referencedColumnName = "idusucon")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idusuari;

    public Movimiento() {
    }

    public Movimiento(Integer idnummov) {
        this.idnummov = idnummov;
    }

    public Movimiento(Integer idnummov, String cddocume, int cddocpar, double dbimport, String instatus, Date tmstmp) {
        this.idnummov = idnummov;
        this.cddocume = cddocume;
        this.cddocpar = cddocpar;
        this.dbimport = dbimport;
        this.instatus = instatus;
        this.tmstmp = tmstmp;
    }

    public Integer getIdnummov() {
        return idnummov;
    }

    public void setIdnummov(Integer idnummov) {
        this.idnummov = idnummov;
    }

    public String getCddocume() {
        return cddocume;
    }

    public void setCddocume(String cddocume) {
        this.cddocume = cddocume;
    }

    public int getCddocpar() {
        return cddocpar;
    }

    public void setCddocpar(int cddocpar) {
        this.cddocpar = cddocpar;
    }

    public double getDbimport() {
        return dbimport;
    }

    public void setDbimport(double dbimport) {
        this.dbimport = dbimport;
    }

    public String getInstatus() {
        return instatus;
    }

    public void setInstatus(String instatus) {
        this.instatus = instatus;
    }

    public String getIdnumcoi() {
        return idnumcoi;
    }

    public void setIdnumcoi(String idnumcoi) {
        this.idnumcoi = idnumcoi;
    }

    public Date getTmstmp() {
        return tmstmp;
    }

    public void setTmstmp(Date tmstmp) {
        this.tmstmp = tmstmp;
    }

    public Usuario getIdusuari() {
        return idusuari;
    }

    public void setIdusuari(Usuario idusuari) {
        this.idusuari = idusuari;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnummov != null ? idnummov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.idnummov == null && other.idnummov != null) || (this.idnummov != null && !this.idnummov.equals(other.idnummov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ftc.aspel.model.Movimiento[ idnummov=" + idnummov + " ]";
    }
    
}
