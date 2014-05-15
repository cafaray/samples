
package com.ftc.aspel.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "datosUsuarioResponse", namespace = "http://ws.aspel.ftc.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosUsuarioResponse", namespace = "http://ws.aspel.ftc.com/")
public class DatosUsuarioResponse {

    @XmlElement(name = "return", namespace = "")
    private com.ftc.aspel.model.UsuarioDetalle _return;

    /**
     * 
     * @return
     *     returns UsuarioDetalle
     */
    public com.ftc.aspel.model.UsuarioDetalle getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.ftc.aspel.model.UsuarioDetalle _return) {
        this._return = _return;
    }

}
