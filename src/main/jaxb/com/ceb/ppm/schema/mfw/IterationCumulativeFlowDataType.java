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
 * <p>Java class for IterationCumulativeFlowDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IterationCumulativeFlowDataType">
 *   &lt;complexContent>
 *     &lt;extension base="{}CumulativeFlowDataType">
 *       &lt;sequence>
 *         &lt;element name="IterationObjectID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IterationCumulativeFlowDataType", propOrder = {
    "iterationObjectID"
})
public class IterationCumulativeFlowDataType
    extends CumulativeFlowDataType
{

    @XmlElement(name = "IterationObjectID")
    protected Long iterationObjectID;

    /**
     * Gets the value of the iterationObjectID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIterationObjectID() {
        return iterationObjectID;
    }

    /**
     * Sets the value of the iterationObjectID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIterationObjectID(Long value) {
        this.iterationObjectID = value;
    }

}
