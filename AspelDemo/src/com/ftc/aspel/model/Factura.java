package com.ftc.aspel.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "FACTF01", catalog = "", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CVE_CLPV", "CVE_DOC"}),
    @UniqueConstraint(columnNames = {"FECHA_DOC", "CVE_DOC"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByTipDoc", query = "SELECT f FROM Factura f WHERE f.tipDoc = :tipDoc"),
    @NamedQuery(name = "Factura.findByCveDoc", query = "SELECT f FROM Factura f WHERE f.cveDoc = :cveDoc"),
    @NamedQuery(name = "Factura.findByStatus", query = "SELECT f FROM Factura f WHERE f.status = :status"),
    @NamedQuery(name = "Factura.findByFechaDoc", query = "SELECT f FROM Factura f WHERE f.fechaDoc = :fechaDoc"),
    @NamedQuery(name = "Factura.findByFechaVen", query = "SELECT f FROM Factura f WHERE f.fechaVen = :fechaVen"),
    @NamedQuery(name = "Factura.findByFechaCancela", query = "SELECT f FROM Factura f WHERE f.fechaCancela = :fechaCancela"),
    @NamedQuery(name = "Factura.findByCanTot", query = "SELECT f FROM Factura f WHERE f.canTot = :canTot"),
    @NamedQuery(name = "Factura.findByImpTot4", query = "SELECT f FROM Factura f WHERE f.impTot4 = :impTot4"),
    @NamedQuery(name = "Factura.findByDesTot", query = "SELECT f FROM Factura f WHERE f.desTot = :desTot"),
    @NamedQuery(name = "Factura.findByDesFin", query = "SELECT f FROM Factura f WHERE f.desFin = :desFin"),
    @NamedQuery(name = "Factura.findByComTot", query = "SELECT f FROM Factura f WHERE f.comTot = :comTot"),
    @NamedQuery(name = "Factura.findByActCoi", query = "SELECT f FROM Factura f WHERE f.actCoi = :actCoi"),
    @NamedQuery(name = "Factura.findByNumMoned", query = "SELECT f FROM Factura f WHERE f.numMoned = :numMoned"),
    @NamedQuery(name = "Factura.findByTipcamb", query = "SELECT f FROM Factura f WHERE f.tipcamb = :tipcamb"),
    @NamedQuery(name = "Factura.findByRfc", query = "SELECT f FROM Factura f WHERE f.rfc = :rfc"),
    @NamedQuery(name = "Factura.findByCtlpol", query = "SELECT f FROM Factura f WHERE f.ctlpol = :ctlpol"),
    @NamedQuery(name = "Factura.findByEscfd", query = "SELECT f FROM Factura f WHERE f.escfd = :escfd"),
    @NamedQuery(name = "Factura.findBySerie", query = "SELECT f FROM Factura f WHERE f.serie = :serie"),
    @NamedQuery(name = "Factura.findByFolio", query = "SELECT f FROM Factura f WHERE f.folio = :folio"),
    @NamedQuery(name = "Factura.findByImporte", query = "SELECT f FROM Factura f WHERE f.importe = :importe")
})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "TIP_DOC", length = 1)
    private String tipDoc;
    @Id
    @Basic(optional = false)
    @Column(name = "CVE_DOC", nullable = false, length = 20)
    private String cveDoc;
    @Basic(optional = false)
    @Column(name = "CVE_CLPV", nullable = false, length = 10)
    private String cveClpv;
    @Column(name = "STATUS", length = 1)
    private String status;
    @Column(name = "DAT_MOSTR")
    private Integer datMostr;
    @Column(name = "CVE_VEND", length = 5)
    private String cveVend;
    @Column(name = "CVE_PEDI", length = 20)
    private String cvePedi;
    @Basic(optional = false)
    @Column(name = "FECHA_DOC", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDoc;
    @Column(name = "FECHA_ENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEnt;
    @Column(name = "FECHA_VEN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVen;
    @Column(name = "FECHA_CANCELA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCancela;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CAN_TOT", precision = 15)
    private Double canTot;
    @Column(name = "IMP_TOT1", precision = 15)
    private Double impTot1;
    @Column(name = "IMP_TOT2", precision = 15)
    private Double impTot2;
    @Column(name = "IMP_TOT3", precision = 15)
    private Double impTot3;
    @Column(name = "IMP_TOT4", precision = 15)
    private Double impTot4;
    @Column(name = "DES_TOT", precision = 15)
    private Double desTot;
    @Column(name = "DES_FIN", precision = 15)
    private Double desFin;
    @Column(name = "COM_TOT", precision = 15)
    private Double comTot;
    @Column(name = "CONDICION", length = 25)
    private String condicion;
    @Column(name = "CVE_OBS")
    private Integer cveObs;
    @Column(name = "NUM_ALMA")
    private Integer numAlma;
    @Column(name = "ACT_CXC", length = 1)
    private String actCxc;
    @Column(name = "ACT_COI", length = 1)
    private String actCoi;
    @Column(name = "ENLAZADO", length = 1)
    private String enlazado;
    @Column(name = "TIP_DOC_E", length = 1)
    private String tipDocE;
    @Column(name = "NUM_MONED")
    private Integer numMoned;
    @Column(name = "TIPCAMB", precision = 15)
    private Double tipcamb;
    @Column(name = "NUM_PAGOS")
    private Integer numPagos;
    @Column(name = "FECHAELAB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaelab;
    @Column(name = "PRIMERPAGO", precision = 15)
    private Double primerpago;
    @Column(name = "RFC", length = 15)
    private String rfc;
    @Column(name = "CTLPOL")
    private Integer ctlpol;
    @Column(name = "ESCFD", length = 1)
    private String escfd;
    @Column(name = "AUTORIZA")
    private Integer autoriza;
    @Column(name = "SERIE", length = 10)
    private String serie;
    @Column(name = "FOLIO")
    private Integer folio;
    @Column(name = "AUTOANIO", length = 4)
    private String autoanio;
    @Column(name = "DAT_ENVIO")
    private Integer datEnvio;
    @Column(name = "CONTADO", length = 1)
    private String contado;
    @Column(name = "CVE_BITA")
    private Integer cveBita;
    @Column(name = "BLOQ", length = 1)
    private String bloq;
    @Column(name = "FORMAENVIO", length = 1)
    private String formaenvio;
    @Column(name = "DES_FIN_PORC", precision = 15)
    private Double desFinPorc;
    @Column(name = "DES_TOT_PORC", precision = 15)
    private Double desTotPorc;
    @Column(name = "IMPORTE", precision = 15)
    private Double importe;
    @Column(name = "COM_TOT_PORC", precision = 15)
    private Double comTotPorc;
    @Column(name = "METODODEPAGO", length = 255)
    private String metododepago;
    @Column(name = "NUMCTAPAGO", length = 255)
    private String numctapago;
    @Column(name = "TIP_DOC_ANT", length = 1)
    private String tipDocAnt;
    @Column(name = "DOC_ANT", length = 20)
    private String docAnt;
    @Column(name = "TIP_DOC_SIG", length = 1)
    private String tipDocSig;
    @Column(name = "DOC_SIG", length = 20)
    private String docSig;

    public Factura() {
    }

    public Factura(String cveDoc) {
        this.cveDoc = cveDoc;
    }

    public Factura(String cveDoc, String cveClpv, Date fechaDoc) {
        this.cveDoc = cveDoc;
        this.cveClpv = cveClpv;
        this.fechaDoc = fechaDoc;
    }

    public String getTipDoc() {
        return tipDoc;
    }

    public void setTipDoc(String tipDoc) {
        this.tipDoc = tipDoc;
    }

    public String getCveDoc() {
        return cveDoc;
    }

    public void setCveDoc(String cveDoc) {
        this.cveDoc = cveDoc;
    }

    public String getCveClpv() {
        return cveClpv;
    }

    public void setCveClpv(String cveClpv) {
        this.cveClpv = cveClpv;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDatMostr() {
        return datMostr;
    }

    public void setDatMostr(Integer datMostr) {
        this.datMostr = datMostr;
    }

    public String getCveVend() {
        return cveVend;
    }

    public void setCveVend(String cveVend) {
        this.cveVend = cveVend;
    }

    public String getCvePedi() {
        return cvePedi;
    }

    public void setCvePedi(String cvePedi) {
        this.cvePedi = cvePedi;
    }

    public Date getFechaDoc() {
        return fechaDoc;
    }

    public void setFechaDoc(Date fechaDoc) {
        this.fechaDoc = fechaDoc;
    }

    public Date getFechaEnt() {
        return fechaEnt;
    }

    public void setFechaEnt(Date fechaEnt) {
        this.fechaEnt = fechaEnt;
    }

    public Date getFechaVen() {
        return fechaVen;
    }

    public void setFechaVen(Date fechaVen) {
        this.fechaVen = fechaVen;
    }

    public Date getFechaCancela() {
        return fechaCancela;
    }

    public void setFechaCancela(Date fechaCancela) {
        this.fechaCancela = fechaCancela;
    }

    public Double getCanTot() {
        return canTot;
    }

    public void setCanTot(Double canTot) {
        this.canTot = canTot;
    }

    public Double getImpTot1() {
        return impTot1;
    }

    public void setImpTot1(Double impTot1) {
        this.impTot1 = impTot1;
    }

    public Double getImpTot2() {
        return impTot2;
    }

    public void setImpTot2(Double impTot2) {
        this.impTot2 = impTot2;
    }

    public Double getImpTot3() {
        return impTot3;
    }

    public void setImpTot3(Double impTot3) {
        this.impTot3 = impTot3;
    }

    public Double getImpTot4() {
        return impTot4;
    }

    public void setImpTot4(Double impTot4) {
        this.impTot4 = impTot4;
    }

    public Double getDesTot() {
        return desTot;
    }

    public void setDesTot(Double desTot) {
        this.desTot = desTot;
    }

    public Double getDesFin() {
        return desFin;
    }

    public void setDesFin(Double desFin) {
        this.desFin = desFin;
    }

    public Double getComTot() {
        return comTot;
    }

    public void setComTot(Double comTot) {
        this.comTot = comTot;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public Integer getCveObs() {
        return cveObs;
    }

    public void setCveObs(Integer cveObs) {
        this.cveObs = cveObs;
    }

    public Integer getNumAlma() {
        return numAlma;
    }

    public void setNumAlma(Integer numAlma) {
        this.numAlma = numAlma;
    }

    public String getActCxc() {
        return actCxc;
    }

    public void setActCxc(String actCxc) {
        this.actCxc = actCxc;
    }

    public String getActCoi() {
        return actCoi;
    }

    public void setActCoi(String actCoi) {
        this.actCoi = actCoi;
    }

    public String getEnlazado() {
        return enlazado;
    }

    public void setEnlazado(String enlazado) {
        this.enlazado = enlazado;
    }

    public String getTipDocE() {
        return tipDocE;
    }

    public void setTipDocE(String tipDocE) {
        this.tipDocE = tipDocE;
    }

    public Integer getNumMoned() {
        return numMoned;
    }

    public void setNumMoned(Integer numMoned) {
        this.numMoned = numMoned;
    }

    public Double getTipcamb() {
        return tipcamb;
    }

    public void setTipcamb(Double tipcamb) {
        this.tipcamb = tipcamb;
    }

    public Integer getNumPagos() {
        return numPagos;
    }

    public void setNumPagos(Integer numPagos) {
        this.numPagos = numPagos;
    }

    public Date getFechaelab() {
        return fechaelab;
    }

    public void setFechaelab(Date fechaelab) {
        this.fechaelab = fechaelab;
    }

    public Double getPrimerpago() {
        return primerpago;
    }

    public void setPrimerpago(Double primerpago) {
        this.primerpago = primerpago;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Integer getCtlpol() {
        return ctlpol;
    }

    public void setCtlpol(Integer ctlpol) {
        this.ctlpol = ctlpol;
    }

    public String getEscfd() {
        return escfd;
    }

    public void setEscfd(String escfd) {
        this.escfd = escfd;
    }

    public Integer getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(Integer autoriza) {
        this.autoriza = autoriza;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public String getAutoanio() {
        return autoanio;
    }

    public void setAutoanio(String autoanio) {
        this.autoanio = autoanio;
    }

    public Integer getDatEnvio() {
        return datEnvio;
    }

    public void setDatEnvio(Integer datEnvio) {
        this.datEnvio = datEnvio;
    }

    public String getContado() {
        return contado;
    }

    public void setContado(String contado) {
        this.contado = contado;
    }

    public Integer getCveBita() {
        return cveBita;
    }

    public void setCveBita(Integer cveBita) {
        this.cveBita = cveBita;
    }

    public String getBloq() {
        return bloq;
    }

    public void setBloq(String bloq) {
        this.bloq = bloq;
    }

    public String getFormaenvio() {
        return formaenvio;
    }

    public void setFormaenvio(String formaenvio) {
        this.formaenvio = formaenvio;
    }

    public Double getDesFinPorc() {
        return desFinPorc;
    }

    public void setDesFinPorc(Double desFinPorc) {
        this.desFinPorc = desFinPorc;
    }

    public Double getDesTotPorc() {
        return desTotPorc;
    }

    public void setDesTotPorc(Double desTotPorc) {
        this.desTotPorc = desTotPorc;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Double getComTotPorc() {
        return comTotPorc;
    }

    public void setComTotPorc(Double comTotPorc) {
        this.comTotPorc = comTotPorc;
    }

    public String getMetododepago() {
        return metododepago;
    }

    public void setMetododepago(String metododepago) {
        this.metododepago = metododepago;
    }

    public String getNumctapago() {
        return numctapago;
    }

    public void setNumctapago(String numctapago) {
        this.numctapago = numctapago;
    }

    public String getTipDocAnt() {
        return tipDocAnt;
    }

    public void setTipDocAnt(String tipDocAnt) {
        this.tipDocAnt = tipDocAnt;
    }

    public String getDocAnt() {
        return docAnt;
    }

    public void setDocAnt(String docAnt) {
        this.docAnt = docAnt;
    }

    public String getTipDocSig() {
        return tipDocSig;
    }

    public void setTipDocSig(String tipDocSig) {
        this.tipDocSig = tipDocSig;
    }

    public String getDocSig() {
        return docSig;
    }

    public void setDocSig(String docSig) {
        this.docSig = docSig;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cveDoc != null ? cveDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.cveDoc == null && other.cveDoc != null) || (this.cveDoc != null && !this.cveDoc.equals(other.cveDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ftc.aspel.model.Factura[ cveDoc=" + cveDoc + " ]";
    }
    
}
