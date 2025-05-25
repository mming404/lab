
package soa.lab1.part1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the src.main.java.soa.lab1 package. 
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

    private final static QName _JWSHelloZhangS_QNAME = new QName("http://lab1.soa/", "JWSHelloZhangS");
    private final static QName _JWSHelloZhangSResponse_QNAME = new QName("http://lab1.soa/", "JWSHelloZhangSResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: src.main.java.soa.lab1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JWSHelloYangsm }
     * 
     */
    public JWSHelloYangsm createJWSHelloZhangS() {
        return new JWSHelloYangsm();
    }

    /**
     * Create an instance of {@link JWSHelloYangsmResponse }
     * 
     */
    public JWSHelloYangsmResponse createJWSHelloZhangSResponse() {
        return new JWSHelloYangsmResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSHelloYangsm }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.soa/", name = "JWSHelloZhangS")
    public JAXBElement<JWSHelloYangsm> createJWSHelloZhangS(JWSHelloYangsm value) {
        return new JAXBElement<JWSHelloYangsm>(_JWSHelloZhangS_QNAME, JWSHelloYangsm.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSHelloYangsmResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://lab1.soa/", name = "JWSHelloZhangSResponse")
    public JAXBElement<JWSHelloYangsmResponse> createJWSHelloZhangSResponse(JWSHelloYangsmResponse value) {
        return new JAXBElement<JWSHelloYangsmResponse>(_JWSHelloZhangSResponse_QNAME, JWSHelloYangsmResponse.class, null, value);
    }

}
