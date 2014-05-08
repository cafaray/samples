
package com.ftc.aspel.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "registraUsuarioResponse", namespace = "http://ws.aspel.ftc.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registraUsuarioResponse", namespace = "http://ws.aspel.ftc.com/")
public class RegistraUsuarioResponse {

    @XmlElement(name = "return", namespace = "")
    private com.ftc.aspel.model.Usuario _return;

    /**
     * 
     * @return
     *     returns Usuario
     */
    public com.ftc.aspel.model.Usuario getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(com.ftc.aspel.model.Usuario _return) {
        this._return = _return;
    }

}
