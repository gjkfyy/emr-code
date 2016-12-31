
package com.founder.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.founder.webservice package. 
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

    private final static QName _ArchiveYNArgs1_QNAME = new QName("http://webservice.founder.com", "args1");
    private final static QName _ArchiveYNArgs0_QNAME = new QName("http://webservice.founder.com", "args0");
    private final static QName _ArchiveYNResponseReturn_QNAME = new QName("http://webservice.founder.com", "return");
    private final static QName _ArcUPFileArgs6_QNAME = new QName("http://webservice.founder.com", "args6");
    private final static QName _ArcUPFileArgs5_QNAME = new QName("http://webservice.founder.com", "args5");
    private final static QName _ArcUPFileArgs2_QNAME = new QName("http://webservice.founder.com", "args2");
    private final static QName _ArcUPFileArgs4_QNAME = new QName("http://webservice.founder.com", "args4");
    private final static QName _ArcUPFileArgs3_QNAME = new QName("http://webservice.founder.com", "args3");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.founder.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ArchiveYN }
     * 
     */
    public ArchiveYN createArchiveYN() {
        return new ArchiveYN();
    }

    /**
     * Create an instance of {@link ArchiveYNResponse }
     * 
     */
    public ArchiveYNResponse createArchiveYNResponse() {
        return new ArchiveYNResponse();
    }

    /**
     * Create an instance of {@link ArcRelieveApplyResponse }
     * 
     */
    public ArcRelieveApplyResponse createArcRelieveApplyResponse() {
        return new ArcRelieveApplyResponse();
    }

    /**
     * Create an instance of {@link ArcChkUser }
     * 
     */
    public ArcChkUser createArcChkUser() {
        return new ArcChkUser();
    }

    /**
     * Create an instance of {@link ArcRelieveApply }
     * 
     */
    public ArcRelieveApply createArcRelieveApply() {
        return new ArcRelieveApply();
    }

    /**
     * Create an instance of {@link ArcChkUserResponse }
     * 
     */
    public ArcChkUserResponse createArcChkUserResponse() {
        return new ArcChkUserResponse();
    }

    /**
     * Create an instance of {@link ArcUPFileResponse }
     * 
     */
    public ArcUPFileResponse createArcUPFileResponse() {
        return new ArcUPFileResponse();
    }

    /**
     * Create an instance of {@link ArcUPFile }
     * 
     */
    public ArcUPFile createArcUPFile() {
        return new ArcUPFile();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.founder.com", name = "args1", scope = ArchiveYN.class)
    public JAXBElement<String> createArchiveYNArgs1(String value) {
        return new JAXBElement<String>(_ArchiveYNArgs1_QNAME, String.class, ArchiveYN.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.founder.com", name = "args0", scope = ArchiveYN.class)
    public JAXBElement<String> createArchiveYNArgs0(String value) {
        return new JAXBElement<String>(_ArchiveYNArgs0_QNAME, String.class, ArchiveYN.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.founder.com", name = "return", scope = ArchiveYNResponse.class)
    public JAXBElement<String> createArchiveYNResponseReturn(String value) {
        return new JAXBElement<String>(_ArchiveYNResponseReturn_QNAME, String.class, ArchiveYNResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.founder.com", name = "return", scope = ArcRelieveApplyResponse.class)
    public JAXBElement<String> createArcRelieveApplyResponseReturn(String value) {
        return new JAXBElement<String>(_ArchiveYNResponseReturn_QNAME, String.class, ArcRelieveApplyResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.founder.com", name = "args0", scope = ArcChkUser.class)
    public JAXBElement<String> createArcChkUserArgs0(String value) {
        return new JAXBElement<String>(_ArchiveYNArgs0_QNAME, String.class, ArcChkUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.founder.com", name = "args0", scope = ArcRelieveApply.class)
    public JAXBElement<String> createArcRelieveApplyArgs0(String value) {
        return new JAXBElement<String>(_ArchiveYNArgs0_QNAME, String.class, ArcRelieveApply.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.founder.com", name = "return", scope = ArcChkUserResponse.class)
    public JAXBElement<String> createArcChkUserResponseReturn(String value) {
        return new JAXBElement<String>(_ArchiveYNResponseReturn_QNAME, String.class, ArcChkUserResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.founder.com", name = "return", scope = ArcUPFileResponse.class)
    public JAXBElement<String> createArcUPFileResponseReturn(String value) {
        return new JAXBElement<String>(_ArchiveYNResponseReturn_QNAME, String.class, ArcUPFileResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.founder.com", name = "args6", scope = ArcUPFile.class)
    public JAXBElement<String> createArcUPFileArgs6(String value) {
        return new JAXBElement<String>(_ArcUPFileArgs6_QNAME, String.class, ArcUPFile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.founder.com", name = "args5", scope = ArcUPFile.class)
    public JAXBElement<String> createArcUPFileArgs5(String value) {
        return new JAXBElement<String>(_ArcUPFileArgs5_QNAME, String.class, ArcUPFile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.founder.com", name = "args2", scope = ArcUPFile.class)
    public JAXBElement<String> createArcUPFileArgs2(String value) {
        return new JAXBElement<String>(_ArcUPFileArgs2_QNAME, String.class, ArcUPFile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.founder.com", name = "args1", scope = ArcUPFile.class)
    public JAXBElement<String> createArcUPFileArgs1(String value) {
        return new JAXBElement<String>(_ArchiveYNArgs1_QNAME, String.class, ArcUPFile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.founder.com", name = "args4", scope = ArcUPFile.class)
    public JAXBElement<String> createArcUPFileArgs4(String value) {
        return new JAXBElement<String>(_ArcUPFileArgs4_QNAME, String.class, ArcUPFile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.founder.com", name = "args3", scope = ArcUPFile.class)
    public JAXBElement<String> createArcUPFileArgs3(String value) {
        return new JAXBElement<String>(_ArcUPFileArgs3_QNAME, String.class, ArcUPFile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.founder.com", name = "args0", scope = ArcUPFile.class)
    public JAXBElement<byte[]> createArcUPFileArgs0(byte[] value) {
        return new JAXBElement<byte[]>(_ArchiveYNArgs0_QNAME, byte[].class, ArcUPFile.class, ((byte[]) value));
    }

}
