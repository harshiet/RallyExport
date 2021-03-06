//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.18 at 01:12:07 PM EDT 
//


package com.ceb.ppm.schema.mfw;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaskType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaskType">
 *   &lt;complexContent>
 *     &lt;extension base="{}ArtifactType">
 *       &lt;sequence>
 *         &lt;element name="Actuals" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Attachments" type="{}TaskAttachmentsType" minOccurs="0"/>
 *         &lt;element name="Blocked" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="BlockedReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Estimate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Iteration" type="{}IterationType" minOccurs="0"/>
 *         &lt;element name="Rank" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="Recycled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Release" type="{}ReleaseType" minOccurs="0"/>
 *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaskIndex" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ToDo" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="WorkProduct" type="{}ArtifactType" minOccurs="0"/>
 *         &lt;element name="IsParent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaskType", propOrder = {
    "actuals",
    "attachments",
    "blocked",
    "blockedReason",
    "estimate",
    "iteration",
    "rank",
    "recycled",
    "release",
    "state",
    "taskIndex",
    "toDo",
    "workProduct",
    "isParent"
})
public class TaskType
    extends ArtifactType
{

    @XmlElement(name = "Actuals")
    protected Double actuals;
    @XmlElement(name = "Attachments")
    protected TaskAttachmentsType attachments;
    @XmlElement(name = "Blocked")
    protected Boolean blocked;
    @XmlElement(name = "BlockedReason")
    protected String blockedReason;
    @XmlElement(name = "Estimate")
    protected Double estimate;
    @XmlElement(name = "Iteration")
    protected IterationType iteration;
    @XmlElement(name = "Rank")
    protected BigDecimal rank;
    @XmlElement(name = "Recycled")
    protected Boolean recycled;
    @XmlElement(name = "Release")
    protected ReleaseType release;
    @XmlElement(name = "State")
    protected String state;
    @XmlElement(name = "TaskIndex")
    protected Long taskIndex;
    @XmlElement(name = "ToDo")
    protected Double toDo;
    @XmlElement(name = "WorkProduct")
    protected ArtifactType workProduct;
    @XmlElement(name = "IsParent")
    protected Boolean isParent;

    /**
     * Gets the value of the actuals property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getActuals() {
        return actuals;
    }

    /**
     * Sets the value of the actuals property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setActuals(Double value) {
        this.actuals = value;
    }

    /**
     * Gets the value of the attachments property.
     * 
     * @return
     *     possible object is
     *     {@link TaskAttachmentsType }
     *     
     */
    public TaskAttachmentsType getAttachments() {
        return attachments;
    }

    /**
     * Sets the value of the attachments property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskAttachmentsType }
     *     
     */
    public void setAttachments(TaskAttachmentsType value) {
        this.attachments = value;
    }

    /**
     * Gets the value of the blocked property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBlocked() {
        return blocked;
    }

    /**
     * Sets the value of the blocked property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBlocked(Boolean value) {
        this.blocked = value;
    }

    /**
     * Gets the value of the blockedReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlockedReason() {
        return blockedReason;
    }

    /**
     * Sets the value of the blockedReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlockedReason(String value) {
        this.blockedReason = value;
    }

    /**
     * Gets the value of the estimate property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getEstimate() {
        return estimate;
    }

    /**
     * Sets the value of the estimate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setEstimate(Double value) {
        this.estimate = value;
    }

    /**
     * Gets the value of the iteration property.
     * 
     * @return
     *     possible object is
     *     {@link IterationType }
     *     
     */
    public IterationType getIteration() {
        return iteration;
    }

    /**
     * Sets the value of the iteration property.
     * 
     * @param value
     *     allowed object is
     *     {@link IterationType }
     *     
     */
    public void setIteration(IterationType value) {
        this.iteration = value;
    }

    /**
     * Gets the value of the rank property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRank() {
        return rank;
    }

    /**
     * Sets the value of the rank property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRank(BigDecimal value) {
        this.rank = value;
    }

    /**
     * Gets the value of the recycled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRecycled() {
        return recycled;
    }

    /**
     * Sets the value of the recycled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRecycled(Boolean value) {
        this.recycled = value;
    }

    /**
     * Gets the value of the release property.
     * 
     * @return
     *     possible object is
     *     {@link ReleaseType }
     *     
     */
    public ReleaseType getRelease() {
        return release;
    }

    /**
     * Sets the value of the release property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReleaseType }
     *     
     */
    public void setRelease(ReleaseType value) {
        this.release = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the taskIndex property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTaskIndex() {
        return taskIndex;
    }

    /**
     * Sets the value of the taskIndex property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTaskIndex(Long value) {
        this.taskIndex = value;
    }

    /**
     * Gets the value of the toDo property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getToDo() {
        return toDo;
    }

    /**
     * Sets the value of the toDo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setToDo(Double value) {
        this.toDo = value;
    }

    /**
     * Gets the value of the workProduct property.
     * 
     * @return
     *     possible object is
     *     {@link ArtifactType }
     *     
     */
    public ArtifactType getWorkProduct() {
        return workProduct;
    }

    /**
     * Sets the value of the workProduct property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArtifactType }
     *     
     */
    public void setWorkProduct(ArtifactType value) {
        this.workProduct = value;
    }

    /**
     * Gets the value of the isParent property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsParent() {
        return isParent;
    }

    /**
     * Sets the value of the isParent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsParent(Boolean value) {
        this.isParent = value;
    }

}
