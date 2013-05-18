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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ChangesetType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChangesetType">
 *   &lt;complexContent>
 *     &lt;extension base="{}WorkspaceDomainObjectType">
 *       &lt;sequence>
 *         &lt;element name="Artifacts" type="{}ChangesetArtifactsType" minOccurs="0"/>
 *         &lt;element name="Author" type="{}UserType" minOccurs="0"/>
 *         &lt;element name="Builds" type="{}ChangesetBuildsType" minOccurs="0"/>
 *         &lt;element name="Changes" type="{}ChangesetChangesType" minOccurs="0"/>
 *         &lt;element name="CommitTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Revision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SCMRepository" type="{}SCMRepositoryType" minOccurs="0"/>
 *         &lt;element name="Uri" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangesetType", propOrder = {
    "artifacts",
    "author",
    "builds",
    "changes",
    "commitTimestamp",
    "message",
    "name",
    "revision",
    "scmRepository",
    "uri"
})
public class ChangesetType
    extends WorkspaceDomainObjectType
{

    @XmlElement(name = "Artifacts")
    protected ChangesetArtifactsType artifacts;
    @XmlElement(name = "Author")
    protected UserType author;
    @XmlElement(name = "Builds")
    protected ChangesetBuildsType builds;
    @XmlElement(name = "Changes")
    protected ChangesetChangesType changes;
    @XmlElement(name = "CommitTimestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar commitTimestamp;
    @XmlElement(name = "Message")
    protected String message;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Revision")
    protected String revision;
    @XmlElement(name = "SCMRepository")
    protected SCMRepositoryType scmRepository;
    @XmlElement(name = "Uri")
    protected String uri;

    /**
     * Gets the value of the artifacts property.
     * 
     * @return
     *     possible object is
     *     {@link ChangesetArtifactsType }
     *     
     */
    public ChangesetArtifactsType getArtifacts() {
        return artifacts;
    }

    /**
     * Sets the value of the artifacts property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangesetArtifactsType }
     *     
     */
    public void setArtifacts(ChangesetArtifactsType value) {
        this.artifacts = value;
    }

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link UserType }
     *     
     */
    public UserType getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserType }
     *     
     */
    public void setAuthor(UserType value) {
        this.author = value;
    }

    /**
     * Gets the value of the builds property.
     * 
     * @return
     *     possible object is
     *     {@link ChangesetBuildsType }
     *     
     */
    public ChangesetBuildsType getBuilds() {
        return builds;
    }

    /**
     * Sets the value of the builds property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangesetBuildsType }
     *     
     */
    public void setBuilds(ChangesetBuildsType value) {
        this.builds = value;
    }

    /**
     * Gets the value of the changes property.
     * 
     * @return
     *     possible object is
     *     {@link ChangesetChangesType }
     *     
     */
    public ChangesetChangesType getChanges() {
        return changes;
    }

    /**
     * Sets the value of the changes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangesetChangesType }
     *     
     */
    public void setChanges(ChangesetChangesType value) {
        this.changes = value;
    }

    /**
     * Gets the value of the commitTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCommitTimestamp() {
        return commitTimestamp;
    }

    /**
     * Sets the value of the commitTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCommitTimestamp(XMLGregorianCalendar value) {
        this.commitTimestamp = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
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
     * Gets the value of the revision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevision() {
        return revision;
    }

    /**
     * Sets the value of the revision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevision(String value) {
        this.revision = value;
    }

    /**
     * Gets the value of the scmRepository property.
     * 
     * @return
     *     possible object is
     *     {@link SCMRepositoryType }
     *     
     */
    public SCMRepositoryType getSCMRepository() {
        return scmRepository;
    }

    /**
     * Sets the value of the scmRepository property.
     * 
     * @param value
     *     allowed object is
     *     {@link SCMRepositoryType }
     *     
     */
    public void setSCMRepository(SCMRepositoryType value) {
        this.scmRepository = value;
    }

    /**
     * Gets the value of the uri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUri(String value) {
        this.uri = value;
    }

}
