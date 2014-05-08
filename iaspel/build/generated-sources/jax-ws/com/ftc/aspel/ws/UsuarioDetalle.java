
package com.ftc.aspel.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para usuarioDetalle complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="usuarioDetalle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dsusuape" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dsusuasp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dsusunom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idusuari" type="{http://ws.aspel.ftc.com/}usuario" minOccurs="0"/>
 *         &lt;element name="idusudet" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="tmstmp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usuarioDetalle", propOrder = {
    "dsusuape",
    "dsusuasp",
    "dsusunom",
    "idusuari",
    "idusudet",
    "tmstmp"
})
public class UsuarioDetalle {

    protected String dsusuape;
    protected String dsusuasp;
    protected String dsusunom;
    protected Usuario idusuari;
    protected Integer idusudet;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tmstmp;

    /**
     * Obtiene el valor de la propiedad dsusuape.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsusuape() {
        return dsusuape;
    }

    /**
     * Define el valor de la propiedad dsusuape.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsusuape(String value) {
        this.dsusuape = value;
    }

    /**
     * Obtiene el valor de la propiedad dsusuasp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsusuasp() {
        return dsusuasp;
    }

    /**
     * Define el valor de la propiedad dsusuasp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsusuasp(String value) {
        this.dsusuasp = value;
    }

    /**
     * Obtiene el valor de la propiedad dsusunom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDsusunom() {
        return dsusunom;
    }

    /**
     * Define el valor de la propiedad dsusunom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDsusunom(String value) {
        this.dsusunom = value;
    }

    /**
     * Obtiene el valor de la propiedad idusuari.
     * 
     * @return
     *     possible object is
     *     {@link Usuario }
     *     
     */
    public Usuario getIdusuari() {
        return idusuari;
    }

    /**
     * Define el valor de la propiedad idusuari.
     * 
     * @param value
     *     allowed object is
     *     {@link Usuario }
     *     
     */
    public void setIdusuari(Usuario value) {
        this.idusuari = value;
    }

    /**
     * Obtiene el valor de la propiedad idusudet.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdusudet() {
        return idusudet;
    }

    /**
     * Define el valor de la propiedad idusudet.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdusudet(Integer value) {
        this.idusudet = value;
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

}
