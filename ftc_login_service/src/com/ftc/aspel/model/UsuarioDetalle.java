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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author omash
 */
@Entity
@Table(name = "kusm01t")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioDetalle.findAll", query = "SELECT u FROM UsuarioDetalle u"),
    @NamedQuery(name = "UsuarioDetalle.findByIdusudet", query = "SELECT u FROM UsuarioDetalle u WHERE u.idusudet = :idusudet"),
    @NamedQuery(name = "UsuarioDetalle.findByDsusunom", query = "SELECT u FROM UsuarioDetalle u WHERE u.dsusunom = :dsusunom"),
    @NamedQuery(name = "UsuarioDetalle.findByDsusuape", query = "SELECT u FROM UsuarioDetalle u WHERE u.dsusuape = :dsusuape"),
    @NamedQuery(name = "UsuarioDetalle.findByDsusuasp", query = "SELECT u FROM UsuarioDetalle u WHERE u.dsusuasp = :dsusuasp"),
    @NamedQuery(name = "UsuarioDetalle.findByTmstmp", query = "SELECT u FROM UsuarioDetalle u WHERE u.tmstmp = :tmstmp")})
public class UsuarioDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusudet")
    private Integer idusudet;
    @Basic(optional = false)
    @Column(name = "dsusunom")
    private String dsusunom;
    @Basic(optional = false)
    @Column(name = "dsusuape")
    private String dsusuape;
    @Basic(optional = false)
    @Column(name = "dsusuasp")
    private String dsusuasp;
    @Basic(optional = false)
    @Column(name = "tmstmp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmstmp;
    @JoinColumn(name = "idusuari", referencedColumnName = "idusucon")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idusuari;

    public UsuarioDetalle() {
    }

    public UsuarioDetalle(Integer idusudet) {
        this.idusudet = idusudet;
    }

    public UsuarioDetalle(Integer idusudet, String dsusunom, String dsusuape, String dsusuasp, Date tmstmp) {
        this.idusudet = idusudet;
        this.dsusunom = dsusunom;
        this.dsusuape = dsusuape;
        this.dsusuasp = dsusuasp;
        this.tmstmp = tmstmp;
    }

    public Integer getIdusudet() {
        return idusudet;
    }

    public void setIdusudet(Integer idusudet) {
        this.idusudet = idusudet;
    }

    public String getDsusunom() {
        return dsusunom;
    }

    public void setDsusunom(String dsusunom) {
        this.dsusunom = dsusunom;
    }

    public String getDsusuape() {
        return dsusuape;
    }

    public void setDsusuape(String dsusuape) {
        this.dsusuape = dsusuape;
    }

    public String getDsusuasp() {
        return dsusuasp;
    }

    public void setDsusuasp(String dsusuasp) {
        this.dsusuasp = dsusuasp;
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
        hash += (idusudet != null ? idusudet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioDetalle)) {
            return false;
        }
        UsuarioDetalle other = (UsuarioDetalle) object;
        if ((this.idusudet == null && other.idusudet != null) || (this.idusudet != null && !this.idusudet.equals(other.idusudet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ftc.aspel.model.UsuarioDetalle[ idusudet=" + idusudet + " ]";
    }
    
}
