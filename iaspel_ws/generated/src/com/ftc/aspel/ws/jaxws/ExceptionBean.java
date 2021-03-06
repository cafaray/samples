
package com.ftc.aspel.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-hudson-740-
 * Generated source version: 2.2
 * 
 */
@XmlRootElement(name = "Exception", namespace = "http://ws.aspel.ftc.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Exception", namespace = "http://ws.aspel.ftc.com/", propOrder = {
    "message",
    "suppressed"
})
public class ExceptionBean {

    private String message;
    private Throwable[] suppressed;

    /**
     * 
     * @return
     *     returns String
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * 
     * @param message
     *     the value for the message property
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 
     * @return
     *     returns Throwable[]
     */
    public Throwable[] getSuppressed() {
        return this.suppressed;
    }

    /**
     * 
     * @param suppressed
     *     the value for the suppressed property
     */
    public void setSuppressed(Throwable[] suppressed) {
        this.suppressed = suppressed;
    }

}
