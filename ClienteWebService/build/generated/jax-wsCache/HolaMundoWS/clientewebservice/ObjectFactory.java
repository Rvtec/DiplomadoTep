
package clientewebservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clientewebservice package. 
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

    private final static QName _GetFechaServidorResponse_QNAME = new QName("http://ws.holamundows.pucmm.edu/", "getFechaServidorResponse");
    private final static QName _Holamundo_QNAME = new QName("http://ws.holamundows.pucmm.edu/", "holamundo");
    private final static QName _HolamundoResponse_QNAME = new QName("http://ws.holamundows.pucmm.edu/", "holamundoResponse");
    private final static QName _Suma_QNAME = new QName("http://ws.holamundows.pucmm.edu/", "suma");
    private final static QName _SumaResponse_QNAME = new QName("http://ws.holamundows.pucmm.edu/", "sumaResponse");
    private final static QName _GetFechaServidor_QNAME = new QName("http://ws.holamundows.pucmm.edu/", "getFechaServidor");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clientewebservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Suma }
     * 
     */
    public Suma createSuma() {
        return new Suma();
    }

    /**
     * Create an instance of {@link SumaResponse }
     * 
     */
    public SumaResponse createSumaResponse() {
        return new SumaResponse();
    }

    /**
     * Create an instance of {@link GetFechaServidor }
     * 
     */
    public GetFechaServidor createGetFechaServidor() {
        return new GetFechaServidor();
    }

    /**
     * Create an instance of {@link Holamundo }
     * 
     */
    public Holamundo createHolamundo() {
        return new Holamundo();
    }

    /**
     * Create an instance of {@link GetFechaServidorResponse }
     * 
     */
    public GetFechaServidorResponse createGetFechaServidorResponse() {
        return new GetFechaServidorResponse();
    }

    /**
     * Create an instance of {@link HolamundoResponse }
     * 
     */
    public HolamundoResponse createHolamundoResponse() {
        return new HolamundoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFechaServidorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.holamundows.pucmm.edu/", name = "getFechaServidorResponse")
    public JAXBElement<GetFechaServidorResponse> createGetFechaServidorResponse(GetFechaServidorResponse value) {
        return new JAXBElement<GetFechaServidorResponse>(_GetFechaServidorResponse_QNAME, GetFechaServidorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Holamundo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.holamundows.pucmm.edu/", name = "holamundo")
    public JAXBElement<Holamundo> createHolamundo(Holamundo value) {
        return new JAXBElement<Holamundo>(_Holamundo_QNAME, Holamundo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HolamundoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.holamundows.pucmm.edu/", name = "holamundoResponse")
    public JAXBElement<HolamundoResponse> createHolamundoResponse(HolamundoResponse value) {
        return new JAXBElement<HolamundoResponse>(_HolamundoResponse_QNAME, HolamundoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Suma }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.holamundows.pucmm.edu/", name = "suma")
    public JAXBElement<Suma> createSuma(Suma value) {
        return new JAXBElement<Suma>(_Suma_QNAME, Suma.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SumaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.holamundows.pucmm.edu/", name = "sumaResponse")
    public JAXBElement<SumaResponse> createSumaResponse(SumaResponse value) {
        return new JAXBElement<SumaResponse>(_SumaResponse_QNAME, SumaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFechaServidor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.holamundows.pucmm.edu/", name = "getFechaServidor")
    public JAXBElement<GetFechaServidor> createGetFechaServidor(GetFechaServidor value) {
        return new JAXBElement<GetFechaServidor>(_GetFechaServidor_QNAME, GetFechaServidor.class, null, value);
    }

}
