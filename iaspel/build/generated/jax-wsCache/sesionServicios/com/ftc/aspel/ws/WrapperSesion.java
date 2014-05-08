
package com.ftc.aspel.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para wrapperSesion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="wrapperSesion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dstoken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtfecfin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtfecini" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idnumses" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="instatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wrapperSesion", propOrder = {
    "dstoken",
    "dtfecfin",
    "dtfecini",
    "idnumses",
    "instatus"
})
public class WrapperSesion {

    protected String dstoken;
    protected String dtfecfin;
    protected String dtfecini;
    protected int idnumses;
    protected String instatus;

    /**
     * Obtiene el valor de la propiedad dstoken.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDstoken() {
        return dstoken;
    }

    /**
     * Define el valor de la propiedad dstoken.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDstoken(String value) {
        this.dstoken = value;
    }

    /**
     * Obtiene el valor de la propiedad dtfecfin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtfecfin() {
        return dtfecfin;
    }

    /**
     * Define el valor de la propiedad dtfecfin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtfecfin(String value) {
        this.dtfecfin = value;
    }

    /**
     * Obtiene el valor de la propiedad dtfecini.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDtfecini() {
        return dtfecini;
    }

    /**
     * Define el valor de la propiedad dtfecini.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDtfecini(String value) {
        this.dtfecini = value;
    }

    /**
     * Obtiene el valor de la propiedad idnumses.
     * 
     */
    public int getIdnumses() {
        return idnumses;
    }

    /**
     * Define el valor de la propiedad idnumses.
     * 
     */
    public void setIdnumses(int value) {
        this.idnumses = value;
    }

    /**
     * Obtiene el valor de la propiedad instatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstatus() {
        return instatus;
    }

    /**
     * Define el valor de la propiedad instatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstatus(String value) {
        this.instatus = value;
    }

}
