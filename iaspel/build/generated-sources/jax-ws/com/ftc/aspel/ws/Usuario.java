
package com.ftc.aspel.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para usuario complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="usuario">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dsusucon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dsvalcon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idusucon" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="instatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tmstmp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element ref="{http://ws.aspel.ftc.com/}usuarioDetalle" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usuario", propOrder = {
    "dsusucon",
    "dsvalcon",
    "idusucon",
    "instatus",
    "tmstmp",
    "usuarioDetalle"
})
public class Usuario {

    protected String dsusucon;
    protected String dsvalcon;
    protected Integer idusucon;
    protected String instatus;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tmstmp;
    @XmlElement(namespace = "http://ws.aspel.ftc.com/")
    protected UsuarioDetalle usuarioDetalle;

    /**
     * Obtiene el valor de la propiedad dsusucon.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsusucon() {
        return dsusucon;
    }

    /**
     * Define el valor de la propiedad dsusucon.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsusucon(String value) {
        this.dsusucon = value;
    }

    /**
     * Obtiene el valor de la propiedad dsvalcon.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsvalcon() {
        return dsvalcon;
    }

    /**
     * Define el valor de la propiedad dsvalcon.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsvalcon(String value) {
        this.dsvalcon = value;
    }

    /**
     * Obtiene el valor de la propiedad idusucon.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdusucon() {
        return idusucon;
    }

    /**
     * Define el valor de la propiedad idusucon.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdusucon(Integer value) {
        this.idusucon = value;
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

    /**
     * Obtiene el valor de la propiedad tmstmp.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTmstmp() {
        return tmstmp;
    }

    /**
     * Define el valor de la propiedad tmstmp.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTmstmp(XMLGregorianCalendar value) {
        this.tmstmp = value;
    }

    /**
     * Obtiene el valor de la propiedad usuarioDetalle.
     * 
     * @return
     *     possible object is
     *     {@link UsuarioDetalle }
     *     
     */
    public UsuarioDetalle getUsuarioDetalle() {
        return usuarioDetalle;
    }

    /**
     * Define el valor de la propiedad usuarioDetalle.
     * 
     * @param value
     *     allowed object is
     *     {@link UsuarioDetalle }
     *     
     */
    public void setUsuarioDetalle(UsuarioDetalle value) {
        this.usuarioDetalle = value;
    }

}
