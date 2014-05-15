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

@Entity
@Table(name = "kusm09t")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sesion.findAll", query = "SELECT s FROM Sesion s"),
    @NamedQuery(name = "Sesion.findById", query = "SELECT s FROM Sesion s WHERE s.idnumses = :id"),
    @NamedQuery(name = "Sesion.findByToken", query = "SELECT s FROM Sesion s WHERE s.dstoken = :token"),
    @NamedQuery(name = "Sesion.activeSessions", query = "SELECT s FROM Sesion s WHERE s.instatus = 'A'"),
    @NamedQuery(name = "Sesion.activeSession", query = "SELECT s FROM Sesion s WHERE s.instatus = 'A' AND s.idusuari = :idusuario"),
})
public class Sesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnumses")
    private Integer idnumses;
    @Basic(optional = false)
    @Column(name = "dstoken")
    private String dstoken;
    @Basic(optional = false)
    @Column(name = "dtfecini")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtfecini;
    @Basic(optional = false)
    @Column(name = "dtfecfin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtfecfin;
    @Basic(optional = false)
    @Column(name = "instatus")
    private String instatus;
    @Basic(optional = false)
    @Column(name = "tmstmp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmstmp;
    @JoinColumn(name = "idusuari", referencedColumnName = "idusucon")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idusuari;

    public Sesion() {
    }

    public Sesion(Integer idnumses) {
        this.idnumses = idnumses;
    }

    public Sesion(Integer idnumses, String dstoken, Date dtfecini, Date dtfecfin, String instatus, Date tmstmp) {
        this.idnumses = idnumses;
        this.dstoken = dstoken;
        this.dtfecini = dtfecini;
        this.dtfecfin = dtfecfin;
        this.instatus = instatus;
        this.tmstmp = tmstmp;
    }

    public Integer getIdnumses() {
        return idnumses;
    }

    public void setIdnumses(Integer idnumses) {
        this.idnumses = idnumses;
    }

    public String getDstoken() {
        return dstoken;
    }

    public void setDstoken(String dstoken) {
        this.dstoken = dstoken;
    }

    public Date getDtfecini() {
        return dtfecini;
    }

    public void setDtfecini(Date dtfecini) {
        this.dtfecini = dtfecini;
    }

    public Date getDtfecfin() {
        return dtfecfin;
    }

    public void setDtfecfin(Date dtfecfin) {
        this.dtfecfin = dtfecfin;
    }

    public String getInstatus() {
        return instatus;
    }

    public void setInstatus(String instatus) {
        this.instatus = instatus;
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
        hash += (idnumses != null ? idnumses.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sesion)) {
            return false;
        }
        Sesion other = (Sesion) object;
        if ((this.idnumses == null && other.idnumses != null) || (this.idnumses != null && !this.idnumses.equals(other.idnumses))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ftc.aspel.model.Sesion[ idnumses=" + idnumses + " ]";
    }

}
