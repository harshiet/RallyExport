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
 * <p>Java class for ConversationPostType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConversationPostType">
 *   &lt;complexContent>
 *     &lt;extension base="{}WorkspaceDomainObjectType">
 *       &lt;sequence>
 *         &lt;element name="Artifact" type="{}ArtifactType" minOccurs="0"/>
 *         &lt;element name="PostNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="User" type="{}UserType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConversationPostType", propOrder = {
    "artifact",
    "postNumber",
    "text",
    "user"
})
public class ConversationPostType
    extends WorkspaceDomainObjectType
{

    @XmlElement(name = "Artifact")
    protected ArtifactType artifact;
    @XmlElement(name = "PostNumber")
    protected Long postNumber;
    @XmlElement(name = "Text")
    protected String text;
    @XmlElement(name = "User")
    protected UserType user;

    /**
     * Gets the value of the artifact property.
     * 
     * @return
     *     possible object is
     *     {@link ArtifactType }
     *     
     */
    public ArtifactType getArtifact() {
        return artifact;
    }

    /**
     * Sets the value of the artifact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArtifactType }
     *     
     */
    public void setArtifact(ArtifactType value) {
        this.artifact = value;
    }

    /**
     * Gets the value of the postNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPostNumber() {
        return postNumber;
    }

    /**
     * Sets the value of the postNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPostNumber(Long value) {
        this.postNumber = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link UserType }
     *     
     */
    public UserType getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserType }
     *     
     */
    public void setUser(UserType value) {
        this.user = value;
    }

}
