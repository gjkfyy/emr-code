
package com.founder.xmlconvert;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for convert complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="convert">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xmlContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceJson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xmlTemplate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="student" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "convert", propOrder = {
    "xmlContent",
    "sourceJson",
    "xmlTemplate",
    "student"
})
public class Convert {

    protected String xmlContent;
    protected String sourceJson;
    protected String xmlTemplate;
    protected Boolean student;

    /**
     * Gets the value of the xmlContent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlContent() {
        return xmlContent;
    }

    /**
     * Sets the value of the xmlContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlContent(String value) {
        this.xmlContent = value;
    }

    /**
     * Gets the value of the sourceJson property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceJson() {
        return sourceJson;
    }

    /**
     * Sets the value of the sourceJson property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceJson(String value) {
        this.sourceJson = value;
    }

    /**
     * Gets the value of the xmlTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlTemplate() {
        return xmlTemplate;
    }

    /**
     * Sets the value of the xmlTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlTemplate(String value) {
        this.xmlTemplate = value;
    }

    /**
     * Gets the value of the student property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStudent() {
        return student;
    }

    /**
     * Sets the value of the student property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStudent(Boolean value) {
        this.student = value;
    }

}
