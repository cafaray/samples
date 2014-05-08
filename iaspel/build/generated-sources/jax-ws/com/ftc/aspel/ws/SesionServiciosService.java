
package com.ftc.aspel.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SesionServiciosService", targetNamespace = "http://ws.aspel.ftc.com/", wsdlLocation = "http://localhost:7070/iaspel/sesionServicios?wsdl")
public class SesionServiciosService
    extends Service
{

    private final static URL SESIONSERVICIOSSERVICE_WSDL_LOCATION;
    private final static WebServiceException SESIONSERVICIOSSERVICE_EXCEPTION;
    private final static QName SESIONSERVICIOSSERVICE_QNAME = new QName("http://ws.aspel.ftc.com/", "SesionServiciosService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:7070/iaspel/sesionServicios?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SESIONSERVICIOSSERVICE_WSDL_LOCATION = url;
        SESIONSERVICIOSSERVICE_EXCEPTION = e;
    }

    public SesionServiciosService() {
        super(__getWsdlLocation(), SESIONSERVICIOSSERVICE_QNAME);
    }

    public SesionServiciosService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SESIONSERVICIOSSERVICE_QNAME, features);
    }

    public SesionServiciosService(URL wsdlLocation) {
        super(wsdlLocation, SESIONSERVICIOSSERVICE_QNAME);
    }

    public SesionServiciosService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SESIONSERVICIOSSERVICE_QNAME, features);
    }

    public SesionServiciosService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SesionServiciosService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SesionServicios
     */
    @WebEndpoint(name = "SesionServiciosPort")
    public SesionServicios getSesionServiciosPort() {
        return super.getPort(new QName("http://ws.aspel.ftc.com/", "SesionServiciosPort"), SesionServicios.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SesionServicios
     */
    @WebEndpoint(name = "SesionServiciosPort")
    public SesionServicios getSesionServiciosPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.aspel.ftc.com/", "SesionServiciosPort"), SesionServicios.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SESIONSERVICIOSSERVICE_EXCEPTION!= null) {
            throw SESIONSERVICIOSSERVICE_EXCEPTION;
        }
        return SESIONSERVICIOSSERVICE_WSDL_LOCATION;
    }

}