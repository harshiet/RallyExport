//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.18 at 01:12:07 PM EDT 
//


package com.ceb.ppm.schema.mfw;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReleaseCumulativeFlowDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReleaseCumulativeFlowDataType">
 *   &lt;complexContent>
 *     &lt;extension base="{}CumulativeFlowDataType">
 *       &lt;sequence>
 *         &lt;element name="ReleaseObjectID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReleaseCumulativeFlowDataType", propOrder = {
    "releaseObjectID"
})
public class ReleaseCumulativeFlowDataType
    extends CumulativeFlowDataType
{

    @XmlElement(name = "ReleaseObjectID")
    protected Long releaseObjectID;

    /**
     * Gets the value of the releaseObjectID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getReleaseObjectID() {
        return releaseObjectID;
    }

    /**
     * Sets the value of the releaseObjectID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setReleaseObjectID(Long value) {
        this.releaseObjectID = value;
    }

}
