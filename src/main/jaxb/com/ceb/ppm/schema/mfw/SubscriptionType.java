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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for SubscriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubscriptionType">
 *   &lt;complexContent>
 *     &lt;extension base="{}PersistableObjectType">
 *       &lt;sequence>
 *         &lt;element name="ExpirationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="MaximumCustomUserFields" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="MaximumProjects" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Modules" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PasswordExpirationDays" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="PreviousPasswordCount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ProjectHierarchyEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="RevisionHistory" type="{}RevisionHistoryType" minOccurs="0"/>
 *         &lt;element name="SessionTimeoutSeconds" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="StoryHierarchyEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="StoryHierarchyType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubscriptionID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="SubscriptionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Workspaces" type="{}SubscriptionWorkspacesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubscriptionType", propOrder = {
    "expirationDate",
    "maximumCustomUserFields",
    "maximumProjects",
    "modules",
    "name",
    "passwordExpirationDays",
    "previousPasswordCount",
    "projectHierarchyEnabled",
    "revisionHistory",
    "sessionTimeoutSeconds",
    "storyHierarchyEnabled",
    "storyHierarchyType",
    "subscriptionID",
    "subscriptionType",
    "workspaces"
})
public class SubscriptionType
    extends PersistableObjectType
{

    @XmlElement(name = "ExpirationDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expirationDate;
    @XmlElement(name = "MaximumCustomUserFields")
    protected Long maximumCustomUserFields;
    @XmlElement(name = "MaximumProjects")
    protected Long maximumProjects;
    @XmlElement(name = "Modules")
    protected String modules;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "PasswordExpirationDays")
    protected Long passwordExpirationDays;
    @XmlElement(name = "PreviousPasswordCount")
    protected Long previousPasswordCount;
    @XmlElement(name = "ProjectHierarchyEnabled")
    protected Boolean projectHierarchyEnabled;
    @XmlElement(name = "RevisionHistory")
    protected RevisionHistoryType revisionHistory;
    @XmlElement(name = "SessionTimeoutSeconds")
    protected Long sessionTimeoutSeconds;
    @XmlElement(name = "StoryHierarchyEnabled")
    protected Boolean storyHierarchyEnabled;
    @XmlElement(name = "StoryHierarchyType")
    protected String storyHierarchyType;
    @XmlElement(name = "SubscriptionID")
    protected Long subscriptionID;
    @XmlElement(name = "SubscriptionType")
    protected String subscriptionType;
    @XmlElement(name = "Workspaces")
    protected SubscriptionWorkspacesType workspaces;

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationDate(XMLGregorianCalendar value) {
        this.expirationDate = value;
    }

    /**
     * Gets the value of the maximumCustomUserFields property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaximumCustomUserFields() {
        return maximumCustomUserFields;
    }

    /**
     * Sets the value of the maximumCustomUserFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaximumCustomUserFields(Long value) {
        this.maximumCustomUserFields = value;
    }

    /**
     * Gets the value of the maximumProjects property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaximumProjects() {
        return maximumProjects;
    }

    /**
     * Sets the value of the maximumProjects property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaximumProjects(Long value) {
        this.maximumProjects = value;
    }

    /**
     * Gets the value of the modules property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModules() {
        return modules;
    }

    /**
     * Sets the value of the modules property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModules(String value) {
        this.modules = value;
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
     * Gets the value of the passwordExpirationDays property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPasswordExpirationDays() {
        return passwordExpirationDays;
    }

    /**
     * Sets the value of the passwordExpirationDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPasswordExpirationDays(Long value) {
        this.passwordExpirationDays = value;
    }

    /**
     * Gets the value of the previousPasswordCount property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPreviousPasswordCount() {
        return previousPasswordCount;
    }

    /**
     * Sets the value of the previousPasswordCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPreviousPasswordCount(Long value) {
        this.previousPasswordCount = value;
    }

    /**
     * Gets the value of the projectHierarchyEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isProjectHierarchyEnabled() {
        return projectHierarchyEnabled;
    }

    /**
     * Sets the value of the projectHierarchyEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setProjectHierarchyEnabled(Boolean value) {
        this.projectHierarchyEnabled = value;
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
     * Gets the value of the sessionTimeoutSeconds property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSessionTimeoutSeconds() {
        return sessionTimeoutSeconds;
    }

    /**
     * Sets the value of the sessionTimeoutSeconds property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSessionTimeoutSeconds(Long value) {
        this.sessionTimeoutSeconds = value;
    }

    /**
     * Gets the value of the storyHierarchyEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStoryHierarchyEnabled() {
        return storyHierarchyEnabled;
    }

    /**
     * Sets the value of the storyHierarchyEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStoryHierarchyEnabled(Boolean value) {
        this.storyHierarchyEnabled = value;
    }

    /**
     * Gets the value of the storyHierarchyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStoryHierarchyType() {
        return storyHierarchyType;
    }

    /**
     * Sets the value of the storyHierarchyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStoryHierarchyType(String value) {
        this.storyHierarchyType = value;
    }

    /**
     * Gets the value of the subscriptionID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSubscriptionID() {
        return subscriptionID;
    }

    /**
     * Sets the value of the subscriptionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSubscriptionID(Long value) {
        this.subscriptionID = value;
    }

    /**
     * Gets the value of the subscriptionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscriptionType() {
        return subscriptionType;
    }

    /**
     * Sets the value of the subscriptionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscriptionType(String value) {
        this.subscriptionType = value;
    }

    /**
     * Gets the value of the workspaces property.
     * 
     * @return
     *     possible object is
     *     {@link SubscriptionWorkspacesType }
     *     
     */
    public SubscriptionWorkspacesType getWorkspaces() {
        return workspaces;
    }

    /**
     * Sets the value of the workspaces property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubscriptionWorkspacesType }
     *     
     */
    public void setWorkspaces(SubscriptionWorkspacesType value) {
        this.workspaces = value;
    }

}
