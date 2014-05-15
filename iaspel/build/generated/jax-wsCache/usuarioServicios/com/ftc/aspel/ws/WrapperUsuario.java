
package com.ftc.aspel.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para wrapperUsuario complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="wrapperUsuario">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dsusucon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dsvalcon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idusucon" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="instatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usuarioDetalle" type="{http://ws.aspel.ftc.com/}wrapperUsuarioDetalle" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wrapperUsuario", propOrder = {
    "dsusucon",
    "dsvalcon",
    "idusucon",
    "instatus",
    "usuarioDetalle"
})
public class WrapperUsuario {

    protected String dsusucon;
    protected String dsvalcon;
    protected int idusucon;
    protected String instatus;
    protected WrapperUsuarioDetalle usuarioDetalle;

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
     */
    public int getIdusucon() {
        return idusucon;
    }

    /**
     * Define el valor de la propiedad idusucon.
     * 
     */
    public void setIdusucon(int value) {
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
     * Obtiene el valor de la propiedad usuarioDetalle.
     * 
     * @return
     *     possible object is
     *     {@link WrapperUsuarioDetalle }
     *     
     */
    public WrapperUsuarioDetalle getUsuarioDetalle() {
        return usuarioDetalle;
    }

    /**
     * Define el valor de la propiedad usuarioDetalle.
     * 
     * @param value
     *     allowed object is
     *     {@link WrapperUsuarioDetalle }
     *     
     */
    public void setUsuarioDetalle(WrapperUsuarioDetalle value) {
        this.usuarioDetalle = value;
    }

}
