
package clientewebservice;

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
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "HolaMundoWS", targetNamespace = "http://ws.holamundows.pucmm.edu/", wsdlLocation = "http://localhost:8080/HolaMundoWebservice/HolaMundoWS?WSDL")
public class HolaMundoWS_Service
    extends Service
{

    private final static URL HOLAMUNDOWS_WSDL_LOCATION;
    private final static WebServiceException HOLAMUNDOWS_EXCEPTION;
    private final static QName HOLAMUNDOWS_QNAME = new QName("http://ws.holamundows.pucmm.edu/", "HolaMundoWS");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/HolaMundoWebservice/HolaMundoWS?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        HOLAMUNDOWS_WSDL_LOCATION = url;
        HOLAMUNDOWS_EXCEPTION = e;
    }

    public HolaMundoWS_Service() {
        super(__getWsdlLocation(), HOLAMUNDOWS_QNAME);
    }

    public HolaMundoWS_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), HOLAMUNDOWS_QNAME, features);
    }

    public HolaMundoWS_Service(URL wsdlLocation) {
        super(wsdlLocation, HOLAMUNDOWS_QNAME);
    }

    public HolaMundoWS_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, HOLAMUNDOWS_QNAME, features);
    }

    public HolaMundoWS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HolaMundoWS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns HolaMundoWS
     */
    @WebEndpoint(name = "HolaMundoWSPort")
    public HolaMundoWS getHolaMundoWSPort() {
        return super.getPort(new QName("http://ws.holamundows.pucmm.edu/", "HolaMundoWSPort"), HolaMundoWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HolaMundoWS
     */
    @WebEndpoint(name = "HolaMundoWSPort")
    public HolaMundoWS getHolaMundoWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.holamundows.pucmm.edu/", "HolaMundoWSPort"), HolaMundoWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (HOLAMUNDOWS_EXCEPTION!= null) {
            throw HOLAMUNDOWS_EXCEPTION;
        }
        return HOLAMUNDOWS_WSDL_LOCATION;
    }

}
