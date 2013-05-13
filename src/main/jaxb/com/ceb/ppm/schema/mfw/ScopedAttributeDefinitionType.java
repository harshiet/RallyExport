//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.12 at 09:47:28 PM EDT 
//


package com.ceb.ppm.schema.mfw;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ScopedAttributeDefinitionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ScopedAttributeDefinitionType">
 *   &lt;complexContent>
 *     &lt;extension base="{}WorkspaceDomainObjectType">
 *       &lt;sequence>
 *         &lt;element name="AttributeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChildProjectHiddenCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ChildProjectVisibleCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Constrained" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Custom" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Hidden" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Required" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SharedAcrossWorkItems" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SystemRequired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="VisibilityOnChildProjects" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VisibleOnlyToAdmins" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScopedAttributeDefinitionType", propOrder = {
    "attributeType",
    "childProjectHiddenCount",
    "childProjectVisibleCount",
    "constrained",
    "custom",
    "hidden",
    "name",
    "required",
    "sharedAcrossWorkItems",
    "systemRequired",
    "visibilityOnChildProjects",
    "visibleOnlyToAdmins"
})
public class ScopedAttributeDefinitionType
    extends WorkspaceDomainObjectType
{

    @XmlElement(name = "AttributeType")
    protected String attributeType;
    @XmlElement(name = "ChildProjectHiddenCount")
    protected Long childProjectHiddenCount;
    @XmlElement(name = "ChildProjectVisibleCount")
    protected Long childProjectVisibleCount;
    @XmlElement(name = "Constrained")
    protected Boolean constrained;
    @XmlElement(name = "Custom")
    protected Boolean custom;
    @XmlElement(name = "Hidden")
    protected Boolean hidden;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Required")
    protected Boolean required;
    @XmlElement(name = "SharedAcrossWorkItems")
    protected Boolean sharedAcrossWorkItems;
    @XmlElement(name = "SystemRequired")
    protected Boolean systemRequired;
    @XmlElement(name = "VisibilityOnChildProjects")
    protected String visibilityOnChildProjects;
    @XmlElement(name = "VisibleOnlyToAdmins")
    protected Boolean visibleOnlyToAdmins;

    /**
     * Gets the value of the attributeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeType() {
        return attributeType;
    }

    /**
     * Sets the value of the attributeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeType(String value) {
        this.attributeType = value;
    }

    /**
     * Gets the value of the childProjectHiddenCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getChildProjectHiddenCount() {
        return childProjectHiddenCount;
    }

    /**
     * Sets the value of the childProjectHiddenCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setChildProjectHiddenCount(Long value) {
        this.childProjectHiddenCount = value;
    }

    /**
     * Gets the value of the childProjectVisibleCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getChildProjectVisibleCount() {
        return childProjectVisibleCount;
    }

    /**
     * Sets the value of the childProjectVisibleCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setChildProjectVisibleCount(Long value) {
        this.childProjectVisibleCount = value;
    }

    /**
     * Gets the value of the constrained property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isConstrained() {
        return constrained;
    }

    /**
     * Sets the value of the constrained property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConstrained(Boolean value) {
        this.constrained = value;
    }

    /**
     * Gets the value of the custom property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCustom() {
        return custom;
    }

    /**
     * Sets the value of the custom property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCustom(Boolean value) {
        this.custom = value;
    }

    /**
     * Gets the value of the hidden property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHidden() {
        return hidden;
    }

    /**
     * Sets the value of the hidden property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHidden(Boolean value) {
        this.hidden = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the required property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRequired() {
        return required;
    }

    /**
     * Sets the value of the required property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRequired(Boolean value) {
        this.required = value;
    }

    /**
     * Gets the value of the sharedAcrossWorkItems property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSharedAcrossWorkItems() {
        return sharedAcrossWorkItems;
    }

    /**
     * Sets the value of the sharedAcrossWorkItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSharedAcrossWorkItems(Boolean value) {
        this.sharedAcrossWorkItems = value;
    }

    /**
     * Gets the value of the systemRequired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSystemRequired() {
        return systemRequired;
    }

    /**
     * Sets the value of the systemRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSystemRequired(Boolean value) {
        this.systemRequired = value;
    }

    /**
     * Gets the value of the visibilityOnChildProjects property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVisibilityOnChildProjects() {
        return visibilityOnChildProjects;
    }

    /**
     * Sets the value of the visibilityOnChildProjects property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVisibilityOnChildProjects(String value) {
        this.visibilityOnChildProjects = value;
    }

    /**
     * Gets the value of the visibleOnlyToAdmins property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVisibleOnlyToAdmins() {
        return visibleOnlyToAdmins;
    }

    /**
     * Sets the value of the visibleOnlyToAdmins property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVisibleOnlyToAdmins(Boolean value) {
        this.visibleOnlyToAdmins = value;
    }

}
