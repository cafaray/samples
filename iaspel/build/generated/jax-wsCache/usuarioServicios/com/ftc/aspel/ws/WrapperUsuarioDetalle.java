
package com.ftc.aspel.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para wrapperUsuarioDetalle complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="wrapperUsuarioDetalle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dsusuape" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dsusuasp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dsusunom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idusudet" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wrapperUsuarioDetalle", propOrder = {
    "dsusuape",
    "dsusuasp",
    "dsusunom",
    "idusudet"
})
public class WrapperUsuarioDetalle {

    protected String dsusuape;
    protected String dsusuasp;
    protected String dsusunom;
    protected int idusudet;

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
     * Obtiene el valor de la propiedad idusudet.
     * 
     */
    public int getIdusudet() {
        return idusudet;
    }

    /**
     * Define el valor de la propiedad idusudet.
     * 
     */
    public void setIdusudet(int value) {
        this.idusudet = value;
    }

}
