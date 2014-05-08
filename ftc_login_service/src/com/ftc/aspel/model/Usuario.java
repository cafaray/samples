package com.ftc.aspel.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "kusm00t")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdusucon", query = "SELECT u FROM Usuario u WHERE u.idusucon = :idusucon"),
    @NamedQuery(name = "Usuario.findByCuenta", query = "SELECT u FROM Usuario u WHERE u.dsusucon = :cuenta"),
    @NamedQuery(name = "Usuario.findByCuentaPasswd", query = "SELECT u FROM Usuario u WHERE u.dsusucon = :cuenta AND u.dsvalcon = :contrasenia"),
    @NamedQuery(name = "Usuario.findByDsvalcon", query = "SELECT u FROM Usuario u WHERE u.dsvalcon = :dsvalcon"),
    @NamedQuery(name = "Usuario.activeUsers", query = "SELECT u FROM Usuario u WHERE u.instatus = 'A'"),
    @NamedQuery(name = "Usuario.suspendUsers", query = "SELECT u FROM Usuario u WHERE u.instatus = 'S'"),})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusucon")
    private Integer idusucon;
    @Basic(optional = false)
    @Column(name = "dsusucon")
    private String dsusucon;
    @Basic(optional = false)
    @Column(name = "dsvalcon")
    private String dsvalcon;
    @Basic(optional = false)
    @Column(name = "instatus")
    private String instatus;
    @Basic(optional = false)
    @Column(name = "tmstmp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tmstmp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuari", fetch = FetchType.LAZY)
    private List<Sesion> sesionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuari", fetch = FetchType.LAZY)
    private List<Movimiento> movimientoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idusuari", fetch = FetchType.LAZY)
    private UsuarioDetalle usuarioDetalle;

    public Usuario() {
    }

    public Usuario(Integer idusucon) {
        this.idusucon = idusucon;
    }

    public Usuario(Integer idusucon, String dsusucon, String dsvalcon, String instatus, Date tmstmp) {
        this.idusucon = idusucon;
        this.dsusucon = dsusucon;
        this.dsvalcon = dsvalcon;
        this.instatus = instatus;
        this.tmstmp = tmstmp;
    }

    public Integer getIdusucon() {
        return idusucon;
    }

    public void setIdusucon(Integer idusucon) {
        this.idusucon = idusucon;
    }

    public String getDsusucon() {
        return dsusucon;
    }

    public void setDsusucon(String dsusucon) {
        this.dsusucon = dsusucon;
    }

    public String getDsvalcon() {
        return dsvalcon;
    }

    public void setDsvalcon(String dsvalcon) {
        this.dsvalcon = dsvalcon;
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

    @XmlTransient
    public List<Sesion> getSesionList() {
        return sesionList;
    }

    public void setSesionList(List<Sesion> sesionList) {
        this.sesionList = sesionList;
    }

    @XmlTransient
    public List<Movimiento> getMovimientoList() {
        return movimientoList;
    }

    public void setMovimientoList(List<Movimiento> movimientoList) {
        this.movimientoList = movimientoList;
    }

    public UsuarioDetalle getUsuarioDetalle() {
        return usuarioDetalle;
    }

    public void setUsuarioDetalle(UsuarioDetalle usuarioDetalle) {
        this.usuarioDetalle = usuarioDetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusucon != null ? idusucon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusucon == null && other.idusucon != null) || (this.idusucon != null && !this.idusucon.equals(other.idusucon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ftc.aspel.model.Usuario[ idusucon=" + idusucon + " ]";
    }

}
