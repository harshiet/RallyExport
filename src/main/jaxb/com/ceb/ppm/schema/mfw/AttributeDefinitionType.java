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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AttributeDefinitionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AttributeDefinitionType">
 *   &lt;complexContent>
 *     &lt;extension base="{}WorkspaceDomainObjectType">
 *       &lt;sequence>
 *         &lt;element name="AllowedQueryOperators" type="{}AttributeDefinitionAllowedQueryOperatorsType" minOccurs="0"/>
 *         &lt;element name="AllowedValueType" type="{}TypeDefinitionType" minOccurs="0"/>
 *         &lt;element name="AllowedValues" type="{}AttributeDefinitionAllowedValuesType" minOccurs="0"/>
 *         &lt;element name="AttributeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Constrained" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Custom" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ElementName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Filterable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Hidden" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="MaxFractionalDigits" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="MaxLength" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Owned" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ReadOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Required" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="SchemaType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SystemRequired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
@XmlType(name = "AttributeDefinitionType", propOrder = {
    "allowedQueryOperators",
    "allowedValueType",
    "allowedValues",
    "attributeType",
    "constrained",
    "custom",
    "elementName",
    "filterable",
    "hidden",
    "maxFractionalDigits",
    "maxLength",
    "name",
    "note",
    "owned",
    "readOnly",
    "required",
    "schemaType",
    "systemRequired",
    "visibleOnlyToAdmins"
})
@XmlSeeAlso({
    WebLinkDefinitionType.class
})
public class AttributeDefinitionType
    extends WorkspaceDomainObjectType
{

    @XmlElement(name = "AllowedQueryOperators")
    protected AttributeDefinitionAllowedQueryOperatorsType allowedQueryOperators;
    @XmlElement(name = "AllowedValueType")
    protected TypeDefinitionType allowedValueType;
    @XmlElement(name = "AllowedValues")
    protected AttributeDefinitionAllowedValuesType allowedValues;
    @XmlElement(name = "AttributeType")
    protected String attributeType;
    @XmlElement(name = "Constrained")
    protected Boolean constrained;
    @XmlElement(name = "Custom")
    protected Boolean custom;
    @XmlElement(name = "ElementName")
    protected String elementName;
    @XmlElement(name = "Filterable")
    protected Boolean filterable;
    @XmlElement(name = "Hidden")
    protected Boolean hidden;
    @XmlElement(name = "MaxFractionalDigits")
    protected Long maxFractionalDigits;
    @XmlElement(name = "MaxLength")
    protected Long maxLength;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Note")
    protected String note;
    @XmlElement(name = "Owned")
    protected Boolean owned;
    @XmlElement(name = "ReadOnly")
    protected Boolean readOnly;
    @XmlElement(name = "Required")
    protected Boolean required;
    @XmlElement(name = "SchemaType")
    protected String schemaType;
    @XmlElement(name = "SystemRequired")
    protected Boolean systemRequired;
    @XmlElement(name = "VisibleOnlyToAdmins")
    protected Boolean visibleOnlyToAdmins;

    /**
     * Gets the value of the allowedQueryOperators property.
     * 
     * @return
     *     possible object is
     *     {@link AttributeDefinitionAllowedQueryOperatorsType }
     *     
     */
    public AttributeDefinitionAllowedQueryOperatorsType getAllowedQueryOperators() {
        return allowedQueryOperators;
    }

    /**
     * Sets the value of the allowedQueryOperators property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeDefinitionAllowedQueryOperatorsType }
     *     
     */
    public void setAllowedQueryOperators(AttributeDefinitionAllowedQueryOperatorsType value) {
        this.allowedQueryOperators = value;
    }

    /**
     * Gets the value of the allowedValueType property.
     * 
     * @return
     *     possible object is
     *     {@link TypeDefinitionType }
     *     
     */
    public TypeDefinitionType getAllowedValueType() {
        return allowedValueType;
    }

    /**
     * Sets the value of the allowedValueType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeDefinitionType }
     *     
     */
    public void setAllowedValueType(TypeDefinitionType value) {
        this.allowedValueType = value;
    }

    /**
     * Gets the value of the allowedValues property.
     * 
     * @return
     *     possible object is
     *     {@link AttributeDefinitionAllowedValuesType }
     *     
     */
    public AttributeDefinitionAllowedValuesType getAllowedValues() {
        return allowedValues;
    }

    /**
     * Sets the value of the allowedValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttributeDefinitionAllowedValuesType }
     *     
     */
    public void setAllowedValues(AttributeDefinitionAllowedValuesType value) {
        this.allowedValues = value;
    }

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
     * Gets the value of the elementName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getElementName() {
        return elementName;
    }

    /**
     * Sets the value of the elementName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setElementName(String value) {
        this.elementName = value;
    }

    /**
     * Gets the value of the filterable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFilterable() {
        return filterable;
    }

    /**
     * Sets the value of the filterable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFilterable(Boolean value) {
        this.filterable = value;
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
     * Gets the value of the maxFractionalDigits property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxFractionalDigits() {
        return maxFractionalDigits;
    }

    /**
     * Sets the value of the maxFractionalDigits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxFractionalDigits(Long value) {
        this.maxFractionalDigits = value;
    }

    /**
     * Gets the value of the maxLength property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the value of the maxLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxLength(Long value) {
        this.maxLength = value;
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
     * Gets the value of the note property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNote() {
        return note;
    }

    /**
     * Sets the value of the note property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNote(String value) {
        this.note = value;
    }

    /**
     * Gets the value of the owned property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOwned() {
        return owned;
    }

    /**
     * Sets the value of the owned property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOwned(Boolean value) {
        this.owned = value;
    }

    /**
     * Gets the value of the readOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReadOnly() {
        return readOnly;
    }

    /**
     * Sets the value of the readOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReadOnly(Boolean value) {
        this.readOnly = value;
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
     * Gets the value of the schemaType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemaType() {
        return schemaType;
    }

    /**
     * Sets the value of the schemaType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemaType(String value) {
        this.schemaType = value;
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
