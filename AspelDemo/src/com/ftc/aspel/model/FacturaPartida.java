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
@Table(name = "PAR_FACTF01", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaPartida.findAll", query = "SELECT f FROM FacturaPartida f"),
    @NamedQuery(name = "FacturaPartida.findByCveDoc", query = "SELECT f FROM FacturaPartida f WHERE f.facturaPartidaPK.cveDoc = :cveDoc"),
    @NamedQuery(name = "FacturaPartida.findByNumPar", query = "SELECT f FROM FacturaPartida f WHERE f.facturaPartidaPK.numPar = :numPar"),
    @NamedQuery(name = "FacturaPartida.findByCveArt", query = "SELECT f FROM FacturaPartida f WHERE f.cveArt = :cveArt"),
    @NamedQuery(name = "FacturaPartida.findByCant", query = "SELECT f FROM FacturaPartida f WHERE f.cant = :cant"),
    @NamedQuery(name = "FacturaPartida.findByPxs", query = "SELECT f FROM FacturaPartida f WHERE f.pxs = :pxs"),
    @NamedQuery(name = "FacturaPartida.findByPrec", query = "SELECT f FROM FacturaPartida f WHERE f.prec = :prec"),
    @NamedQuery(name = "FacturaPartida.findByCost", query = "SELECT f FROM FacturaPartida f WHERE f.cost = :cost"),
    @NamedQuery(name = "FacturaPartida.findByImpu1", query = "SELECT f FROM FacturaPartida f WHERE f.impu1 = :impu1"),
    @NamedQuery(name = "FacturaPartida.findByImpu2", query = "SELECT f FROM FacturaPartida f WHERE f.impu2 = :impu2"),
    @NamedQuery(name = "FacturaPartida.findByImpu3", query = "SELECT f FROM FacturaPartida f WHERE f.impu3 = :impu3"),
    @NamedQuery(name = "FacturaPartida.findByImpu4", query = "SELECT f FROM FacturaPartida f WHERE f.impu4 = :impu4"),
    @NamedQuery(name = "FacturaPartida.findByImp1apla", query = "SELECT f FROM FacturaPartida f WHERE f.imp1apla = :imp1apla"),
    @NamedQuery(name = "FacturaPartida.findByImp2apla", query = "SELECT f FROM FacturaPartida f WHERE f.imp2apla = :imp2apla"),
    @NamedQuery(name = "FacturaPartida.findByImp3apla", query = "SELECT f FROM FacturaPartida f WHERE f.imp3apla = :imp3apla"),
    @NamedQuery(name = "FacturaPartida.findByImp4apla", query = "SELECT f FROM FacturaPartida f WHERE f.imp4apla = :imp4apla"),
    @NamedQuery(name = "FacturaPartida.findByTotimp1", query = "SELECT f FROM FacturaPartida f WHERE f.totimp1 = :totimp1"),
    @NamedQuery(name = "FacturaPartida.findByTotimp2", query = "SELECT f FROM FacturaPartida f WHERE f.totimp2 = :totimp2"),
    @NamedQuery(name = "FacturaPartida.findByTotimp3", query = "SELECT f FROM FacturaPartida f WHERE f.totimp3 = :totimp3"),
    @NamedQuery(name = "FacturaPartida.findByTotimp4", query = "SELECT f FROM FacturaPartida f WHERE f.totimp4 = :totimp4"),
    @NamedQuery(name = "FacturaPartida.findByDesc1", query = "SELECT f FROM FacturaPartida f WHERE f.desc1 = :desc1"),
    @NamedQuery(name = "FacturaPartida.findByDesc2", query = "SELECT f FROM FacturaPartida f WHERE f.desc2 = :desc2"),
    @NamedQuery(name = "FacturaPartida.findByDesc3", query = "SELECT f FROM FacturaPartida f WHERE f.desc3 = :desc3"),
    @NamedQuery(name = "FacturaPartida.findByComi", query = "SELECT f FROM FacturaPartida f WHERE f.comi = :comi"),
    @NamedQuery(name = "FacturaPartida.findByApar", query = "SELECT f FROM FacturaPartida f WHERE f.apar = :apar"),
    @NamedQuery(name = "FacturaPartida.findByActInv", query = "SELECT f FROM FacturaPartida f WHERE f.actInv = :actInv"),
    @NamedQuery(name = "FacturaPartida.findByNumAlm", query = "SELECT f FROM FacturaPartida f WHERE f.numAlm = :numAlm"),
    @NamedQuery(name = "FacturaPartida.findByPolitApli", query = "SELECT f FROM FacturaPartida f WHERE f.politApli = :politApli"),
    @NamedQuery(name = "FacturaPartida.findByTipCam", query = "SELECT f FROM FacturaPartida f WHERE f.tipCam = :tipCam"),
    @NamedQuery(name = "FacturaPartida.findByUniVenta", query = "SELECT f FROM FacturaPartida f WHERE f.uniVenta = :uniVenta"),
    @NamedQuery(name = "FacturaPartida.findByTipoProd", query = "SELECT f FROM FacturaPartida f WHERE f.tipoProd = :tipoProd"),
    @NamedQuery(name = "FacturaPartida.findByCveObs", query = "SELECT f FROM FacturaPartida f WHERE f.cveObs = :cveObs"),
    @NamedQuery(name = "FacturaPartida.findByRegSerie", query = "SELECT f FROM FacturaPartida f WHERE f.regSerie = :regSerie"),
    @NamedQuery(name = "FacturaPartida.findByELtpd", query = "SELECT f FROM FacturaPartida f WHERE f.eLtpd = :eLtpd"),
    @NamedQuery(name = "FacturaPartida.findByTipoElem", query = "SELECT f FROM FacturaPartida f WHERE f.tipoElem = :tipoElem"),
    @NamedQuery(name = "FacturaPartida.findByNumMov", query = "SELECT f FROM FacturaPartida f WHERE f.numMov = :numMov"),
    @NamedQuery(name = "FacturaPartida.findByTotPartida", query = "SELECT f FROM FacturaPartida f WHERE f.totPartida = :totPartida"),
    @NamedQuery(name = "FacturaPartida.findByImprimir", query = "SELECT f FROM FacturaPartida f WHERE f.imprimir = :imprimir")})
public class FacturaPartida implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FacturaPartidaPK facturaPartidaPK;
    @Column(name = "CVE_ART", length = 16)
    private String cveArt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CANT", precision = 15)
    private Double cant;
    @Column(name = "PXS", precision = 15)
    private Double pxs;
    @Column(name = "PREC", precision = 15)
    private Double prec;
    @Column(name = "COST", precision = 15)
    private Double cost;
    @Column(name = "IMPU1", precision = 15)
    private Double impu1;
    @Column(name = "IMPU2", precision = 15)
    private Double impu2;
    @Column(name = "IMPU3", precision = 15)
    private Double impu3;
    @Column(name = "IMPU4", precision = 15)
    private Double impu4;
    @Column(name = "IMP1APLA")
    private Short imp1apla;
    @Column(name = "IMP2APLA")
    private Short imp2apla;
    @Column(name = "IMP3APLA")
    private Short imp3apla;
    @Column(name = "IMP4APLA")
    private Short imp4apla;
    @Column(name = "TOTIMP1", precision = 15)
    private Double totimp1;
    @Column(name = "TOTIMP2", precision = 15)
    private Double totimp2;
    @Column(name = "TOTIMP3", precision = 15)
    private Double totimp3;
    @Column(name = "TOTIMP4", precision = 15)
    private Double totimp4;
    @Column(name = "DESC1", precision = 15)
    private Double desc1;
    @Column(name = "DESC2", precision = 15)
    private Double desc2;
    @Column(name = "DESC3", precision = 15)
    private Double desc3;
    @Column(name = "COMI", precision = 15)
    private Double comi;
    @Column(name = "APAR", precision = 15)
    private Double apar;
    @Column(name = "ACT_INV", length = 1)
    private String actInv;
    @Column(name = "NUM_ALM")
    private Integer numAlm;
    @Column(name = "POLIT_APLI", length = 1)
    private String politApli;
    @Column(name = "TIP_CAM", precision = 15)
    private Double tipCam;
    @Column(name = "UNI_VENTA", length = 10)
    private String uniVenta;
    @Column(name = "TIPO_PROD", length = 1)
    private String tipoProd;
    @Column(name = "CVE_OBS")
    private Integer cveObs;
    @Column(name = "REG_SERIE")
    private Integer regSerie;
    @Column(name = "E_LTPD")
    private Integer eLtpd;
    @Column(name = "TIPO_ELEM", length = 1)
    private String tipoElem;
    @Column(name = "NUM_MOV")
    private Integer numMov;
    @Column(name = "TOT_PARTIDA", precision = 15)
    private Double totPartida;
    @Column(name = "IMPRIMIR", length = 1)
    private String imprimir;

    public FacturaPartida() {
    }

    public FacturaPartida(FacturaPartidaPK facturaPartidaPK) {
        this.facturaPartidaPK = facturaPartidaPK;
    }

    public FacturaPartida(String cveDoc, int numPar) {
        this.facturaPartidaPK = new FacturaPartidaPK(cveDoc, numPar);
    }

    public FacturaPartidaPK getFacturaPartidaPK() {
        return facturaPartidaPK;
    }

    public void setFacturaPartidaPK(FacturaPartidaPK facturaPartidaPK) {
        this.facturaPartidaPK = facturaPartidaPK;
    }

    public String getCveArt() {
        return cveArt;
    }

    public void setCveArt(String cveArt) {
        this.cveArt = cveArt;
    }

    public Double getCant() {
        return cant;
    }

    public void setCant(Double cant) {
        this.cant = cant;
    }

    public Double getPxs() {
        return pxs;
    }

    public void setPxs(Double pxs) {
        this.pxs = pxs;
    }

    public Double getPrec() {
        return prec;
    }

    public void setPrec(Double prec) {
        this.prec = prec;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getImpu1() {
        return impu1;
    }

    public void setImpu1(Double impu1) {
        this.impu1 = impu1;
    }

    public Double getImpu2() {
        return impu2;
    }

    public void setImpu2(Double impu2) {
        this.impu2 = impu2;
    }

    public Double getImpu3() {
        return impu3;
    }

    public void setImpu3(Double impu3) {
        this.impu3 = impu3;
    }

    public Double getImpu4() {
        return impu4;
    }

    public void setImpu4(Double impu4) {
        this.impu4 = impu4;
    }

    public Short getImp1apla() {
        return imp1apla;
    }

    public void setImp1apla(Short imp1apla) {
        this.imp1apla = imp1apla;
    }

    public Short getImp2apla() {
        return imp2apla;
    }

    public void setImp2apla(Short imp2apla) {
        this.imp2apla = imp2apla;
    }

    public Short getImp3apla() {
        return imp3apla;
    }

    public void setImp3apla(Short imp3apla) {
        this.imp3apla = imp3apla;
    }

    public Short getImp4apla() {
        return imp4apla;
    }

    public void setImp4apla(Short imp4apla) {
        this.imp4apla = imp4apla;
    }

    public Double getTotimp1() {
        return totimp1;
    }

    public void setTotimp1(Double totimp1) {
        this.totimp1 = totimp1;
    }

    public Double getTotimp2() {
        return totimp2;
    }

    public void setTotimp2(Double totimp2) {
        this.totimp2 = totimp2;
    }

    public Double getTotimp3() {
        return totimp3;
    }

    public void setTotimp3(Double totimp3) {
        this.totimp3 = totimp3;
    }

    public Double getTotimp4() {
        return totimp4;
    }

    public void setTotimp4(Double totimp4) {
        this.totimp4 = totimp4;
    }

    public Double getDesc1() {
        return desc1;
    }

    public void setDesc1(Double desc1) {
        this.desc1 = desc1;
    }

    public Double getDesc2() {
        return desc2;
    }

    public void setDesc2(Double desc2) {
        this.desc2 = desc2;
    }

    public Double getDesc3() {
        return desc3;
    }

    public void setDesc3(Double desc3) {
        this.desc3 = desc3;
    }

    public Double getComi() {
        return comi;
    }

    public void setComi(Double comi) {
        this.comi = comi;
    }

    public Double getApar() {
        return apar;
    }

    public void setApar(Double apar) {
        this.apar = apar;
    }

    public String getActInv() {
        return actInv;
    }

    public void setActInv(String actInv) {
        this.actInv = actInv;
    }

    public Integer getNumAlm() {
        return numAlm;
    }

    public void setNumAlm(Integer numAlm) {
        this.numAlm = numAlm;
    }

    public String getPolitApli() {
        return politApli;
    }

    public void setPolitApli(String politApli) {
        this.politApli = politApli;
    }

    public Double getTipCam() {
        return tipCam;
    }

    public void setTipCam(Double tipCam) {
        this.tipCam = tipCam;
    }

    public String getUniVenta() {
        return uniVenta;
    }

    public void setUniVenta(String uniVenta) {
        this.uniVenta = uniVenta;
    }

    public String getTipoProd() {
        return tipoProd;
    }

    public void setTipoProd(String tipoProd) {
        this.tipoProd = tipoProd;
    }

    public Integer getCveObs() {
        return cveObs;
    }

    public void setCveObs(Integer cveObs) {
        this.cveObs = cveObs;
    }

    public Integer getRegSerie() {
        return regSerie;
    }

    public void setRegSerie(Integer regSerie) {
        this.regSerie = regSerie;
    }

    public Integer getELtpd() {
        return eLtpd;
    }

    public void setELtpd(Integer eLtpd) {
        this.eLtpd = eLtpd;
    }

    public String getTipoElem() {
        return tipoElem;
    }

    public void setTipoElem(String tipoElem) {
        this.tipoElem = tipoElem;
    }

    public Integer getNumMov() {
        return numMov;
    }

    public void setNumMov(Integer numMov) {
        this.numMov = numMov;
    }

    public Double getTotPartida() {
        return totPartida;
    }

    public void setTotPartida(Double totPartida) {
        this.totPartida = totPartida;
    }

    public String getImprimir() {
        return imprimir;
    }

    public void setImprimir(String imprimir) {
        this.imprimir = imprimir;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facturaPartidaPK != null ? facturaPartidaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaPartida)) {
            return false;
        }
        FacturaPartida other = (FacturaPartida) object;
        if ((this.facturaPartidaPK == null && other.facturaPartidaPK != null) || (this.facturaPartidaPK != null && !this.facturaPartidaPK.equals(other.facturaPartidaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ftc.aspel.model.FacturaPartida[ facturaPartidaPK=" + facturaPartidaPK + " ]";
    }
    
}
