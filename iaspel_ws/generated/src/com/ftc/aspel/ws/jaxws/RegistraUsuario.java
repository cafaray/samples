
package com.ftc.aspel.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "registraUsuario", namespace = "http://ws.aspel.ftc.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "registraUsuario", namespace = "http://ws.aspel.ftc.com/")
public class RegistraUsuario {

    @XmlElement(name = "arg0", namespace = "")
    private com.ftc.aspel.model.Usuario arg0;

    /**
     * 
     * @return
     *     returns Usuario
     */
    public com.ftc.aspel.model.Usuario getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(com.ftc.aspel.model.Usuario arg0) {
        this.arg0 = arg0;
    }

}
