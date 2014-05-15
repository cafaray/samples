
package com.ftc.aspel.ws.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "usuariosSuspendidosResponse", namespace = "http://ws.aspel.ftc.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usuariosSuspendidosResponse", namespace = "http://ws.aspel.ftc.com/")
public class UsuariosSuspendidosResponse {

    @XmlElement(name = "return", namespace = "")
    private List<com.ftc.aspel.ws.util.WrapperUsuario> _return;

    /**
     * 
     * @return
     *     returns List<WrapperUsuario>
     */
    public List<com.ftc.aspel.ws.util.WrapperUsuario> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<com.ftc.aspel.ws.util.WrapperUsuario> _return) {
        this._return = _return;
    }

}
