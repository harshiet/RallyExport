//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.17 at 11:55:40 PM EDT 
//


package com.ceb.ppm.schema.mfw;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypeDefinitionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypeDefinitionType">
 *   &lt;complexContent>
 *     &lt;extension base="{}WorkspaceDomainObjectType">
 *       &lt;sequence>
 *         &lt;element name="Abstract" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Attributes" type="{}TypeDefinitionAttributesType" minOccurs="0"/>
 *         &lt;element name="Creatable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Deletable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DisplayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ElementName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IDPrefix" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Ordinal" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Parent" type="{}TypeDefinitionType" minOccurs="0"/>
 *         &lt;element name="Queryable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ReadOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Restorable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="RevisionHistory" type="{}RevisionHistoryType" minOccurs="0"/>
 *         &lt;element name="TypePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypeDefinitionType", propOrder = {
    "_abstract",
    "attributes",
    "creatable",
    "deletable",
    "displayName",
    "elementName",
    "idPrefix",
    "name",
    "note",
    "ordinal",
    "parent",
    "queryable",
    "readOnly",
    "restorable",
    "revisionHistory",
    "typePath"
})
public class TypeDefinitionType
    extends WorkspaceDomainObjectType
{

    @XmlElement(name = "Abstract")
    protected Boolean _abstract;
    @XmlElement(name = "Attributes")
    protected TypeDefinitionAttributesType attributes;
    @XmlElement(name = "Creatable")
    protected Boolean creatable;
    @XmlElement(name = "Deletable")
    protected Boolean deletable;
    @XmlElement(name = "DisplayName")
    protected String displayName;
    @XmlElement(name = "ElementName")
    protected String elementName;
    @XmlElement(name = "IDPrefix")
    protected String idPrefix;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Note")
    protected String note;
    @XmlElement(name = "Ordinal")
    protected Long ordinal;
    @XmlElement(name = "Parent")
    protected TypeDefinitionType parent;
    @XmlElement(name = "Queryable")
    protected Boolean queryable;
    @XmlElement(name = "ReadOnly")
    protected Boolean readOnly;
    @XmlElement(name = "Restorable")
    protected Boolean restorable;
    @XmlElement(name = "RevisionHistory")
    protected RevisionHistoryType revisionHistory;
    @XmlElement(name = "TypePath")
    protected String typePath;

    /**
     * Gets the value of the abstract property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAbstract() {
        return _abstract;
    }

    /**
     * Sets the value of the abstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAbstract(Boolean value) {
        this._abstract = value;
    }

    /**
     * Gets the value of the attributes property.
     * 
     * @return
     *     possible object is
     *     {@link TypeDefinitionAttributesType }
     *     
     */
    public TypeDefinitionAttributesType getAttributes() {
        return attributes;
    }

    /**
     * Sets the value of the attributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeDefinitionAttributesType }
     *     
     */
    public void setAttributes(TypeDefinitionAttributesType value) {
        this.attributes = value;
    }

    /**
     * Gets the value of the creatable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCreatable() {
        return creatable;
    }

    /**
     * Sets the value of the creatable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCreatable(Boolean value) {
        this.creatable = value;
    }

    /**
     * Gets the value of the deletable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDeletable() {
        return deletable;
    }

    /**
     * Sets the value of the deletable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeletable(Boolean value) {
        this.deletable = value;
    }

    /**
     * Gets the value of the displayName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets the value of the displayName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayName(String value) {
        this.displayName = value;
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
     * Gets the value of the idPrefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDPrefix() {
        return idPrefix;
    }

    /**
     * Sets the value of the idPrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDPrefix(String value) {
        this.idPrefix = value;
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
     * Gets the value of the ordinal property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOrdinal() {
        return ordinal;
    }

    /**
     * Sets the value of the ordinal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOrdinal(Long value) {
        this.ordinal = value;
    }

    /**
     * Gets the value of the parent property.
     * 
     * @return
     *     possible object is
     *     {@link TypeDefinitionType }
     *     
     */
    public TypeDefinitionType getParent() {
        return parent;
    }

    /**
     * Sets the value of the parent property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeDefinitionType }
     *     
     */
    public void setParent(TypeDefinitionType value) {
        this.parent = value;
    }

    /**
     * Gets the value of the queryable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isQueryable() {
        return queryable;
    }

    /**
     * Sets the value of the queryable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setQueryable(Boolean value) {
        this.queryable = value;
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
     * Gets the value of the restorable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRestorable() {
        return restorable;
    }

    /**
     * Sets the value of the restorable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRestorable(Boolean value) {
        this.restorable = value;
    }

    /**
     * Gets the value of the revisionHistory property.
     * 
     * @return
     *     possible object is
     *     {@link RevisionHistoryType }
     *     
     */
    public RevisionHistoryType getRevisionHistory() {
        return revisionHistory;
    }

    /**
     * Sets the value of the revisionHistory property.
     * 
     * @param value
     *     allowed object is
     *     {@link RevisionHistoryType }
     *     
     */
    public void setRevisionHistory(RevisionHistoryType value) {
        this.revisionHistory = value;
    }

    /**
     * Gets the value of the typePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypePath() {
        return typePath;
    }

    /**
     * Sets the value of the typePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypePath(String value) {
        this.typePath = value;
    }

}
