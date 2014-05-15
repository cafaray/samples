
package com.ftc.aspel.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ftc.aspel.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Sesiones_QNAME = new QName("http://ws.aspel.ftc.com/", "sesiones");
    private final static QName _IniciarSesionResponse_QNAME = new QName("http://ws.aspel.ftc.com/", "iniciarSesionResponse");
    private final static QName _UsuarioDetalle_QNAME = new QName("http://ws.aspel.ftc.com/", "usuarioDetalle");
    private final static QName _DatosUsuarioResponse_QNAME = new QName("http://ws.aspel.ftc.com/", "datosUsuarioResponse");
    private final static QName _SesionesResponse_QNAME = new QName("http://ws.aspel.ftc.com/", "sesionesResponse");
    private final static QName _CierraSesionResponse_QNAME = new QName("http://ws.aspel.ftc.com/", "cierraSesionResponse");
    private final static QName _CierraSesion_QNAME = new QName("http://ws.aspel.ftc.com/", "cierraSesion");
    private final static QName _Usuario_QNAME = new QName("http://ws.aspel.ftc.com/", "usuario");
    private final static QName _DatosUsuario_QNAME = new QName("http://ws.aspel.ftc.com/", "datosUsuario");
    private final static QName _IniciarSesion_QNAME = new QName("http://ws.aspel.ftc.com/", "iniciarSesion");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ftc.aspel.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IniciarSesion }
     * 
     */
    public IniciarSesion createIniciarSesion() {
        return new IniciarSesion();
    }

    /**
     * Create an instance of {@link DatosUsuario }
     * 
     */
    public DatosUsuario createDatosUsuario() {
        return new DatosUsuario();
    }

    /**
     * Create an instance of {@link CierraSesion }
     * 
     */
    public CierraSesion createCierraSesion() {
        return new CierraSesion();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link SesionesResponse }
     * 
     */
    public SesionesResponse createSesionesResponse() {
        return new SesionesResponse();
    }

    /**
     * Create an instance of {@link CierraSesionResponse }
     * 
     */
    public CierraSesionResponse createCierraSesionResponse() {
        return new CierraSesionResponse();
    }

    /**
     * Create an instance of {@link DatosUsuarioResponse }
     * 
     */
    public DatosUsuarioResponse createDatosUsuarioResponse() {
        return new DatosUsuarioResponse();
    }

    /**
     * Create an instance of {@link UsuarioDetalle }
     * 
     */
    public UsuarioDetalle createUsuarioDetalle() {
        return new UsuarioDetalle();
    }

    /**
     * Create an instance of {@link IniciarSesionResponse }
     * 
     */
    public IniciarSesionResponse createIniciarSesionResponse() {
        return new IniciarSesionResponse();
    }

    /**
     * Create an instance of {@link Sesiones }
     * 
     */
    public Sesiones createSesiones() {
        return new Sesiones();
    }

    /**
     * Create an instance of {@link WrapperSesion }
     * 
     */
    public WrapperSesion createWrapperSesion() {
        return new WrapperSesion();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Sesiones }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.aspel.ftc.com/", name = "sesiones")
    public JAXBElement<Sesiones> createSesiones(Sesiones value) {
        return new JAXBElement<Sesiones>(_Sesiones_QNAME, Sesiones.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IniciarSesionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.aspel.ftc.com/", name = "iniciarSesionResponse")
    public JAXBElement<IniciarSesionResponse> createIniciarSesionResponse(IniciarSesionResponse value) {
        return new JAXBElement<IniciarSesionResponse>(_IniciarSesionResponse_QNAME, IniciarSesionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioDetalle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.aspel.ftc.com/", name = "usuarioDetalle")
    public JAXBElement<UsuarioDetalle> createUsuarioDetalle(UsuarioDetalle value) {
        return new JAXBElement<UsuarioDetalle>(_UsuarioDetalle_QNAME, UsuarioDetalle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatosUsuarioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.aspel.ftc.com/", name = "datosUsuarioResponse")
    public JAXBElement<DatosUsuarioResponse> createDatosUsuarioResponse(DatosUsuarioResponse value) {
        return new JAXBElement<DatosUsuarioResponse>(_DatosUsuarioResponse_QNAME, DatosUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SesionesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.aspel.ftc.com/", name = "sesionesResponse")
    public JAXBElement<SesionesResponse> createSesionesResponse(SesionesResponse value) {
        return new JAXBElement<SesionesResponse>(_SesionesResponse_QNAME, SesionesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CierraSesionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.aspel.ftc.com/", name = "cierraSesionResponse")
    public JAXBElement<CierraSesionResponse> createCierraSesionResponse(CierraSesionResponse value) {
        return new JAXBElement<CierraSesionResponse>(_CierraSesionResponse_QNAME, CierraSesionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CierraSesion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.aspel.ftc.com/", name = "cierraSesion")
    public JAXBElement<CierraSesion> createCierraSesion(CierraSesion value) {
        return new JAXBElement<CierraSesion>(_CierraSesion_QNAME, CierraSesion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Usuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.aspel.ftc.com/", name = "usuario")
    public JAXBElement<Usuario> createUsuario(Usuario value) {
        return new JAXBElement<Usuario>(_Usuario_QNAME, Usuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatosUsuario }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.aspel.ftc.com/", name = "datosUsuario")
    public JAXBElement<DatosUsuario> createDatosUsuario(DatosUsuario value) {
        return new JAXBElement<DatosUsuario>(_DatosUsuario_QNAME, DatosUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IniciarSesion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.aspel.ftc.com/", name = "iniciarSesion")
    public JAXBElement<IniciarSesion> createIniciarSesion(IniciarSesion value) {
        return new JAXBElement<IniciarSesion>(_IniciarSesion_QNAME, IniciarSesion.class, null, value);
    }

}
