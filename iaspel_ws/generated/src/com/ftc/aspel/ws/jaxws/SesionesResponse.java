
package com.ftc.aspel.ws.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "sesionesResponse", namespace = "http://ws.aspel.ftc.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sesionesResponse", namespace = "http://ws.aspel.ftc.com/")
public class SesionesResponse {

    @XmlElement(name = "return", namespace = "")
    private List<com.ftc.aspel.ws.util.WrapperSesion> _return;

    /**
     * 
     * @return
     *     returns List<WrapperSesion>
     */
    public List<com.ftc.aspel.ws.util.WrapperSesion> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<com.ftc.aspel.ws.util.WrapperSesion> _return) {
        this._return = _return;
    }

}
