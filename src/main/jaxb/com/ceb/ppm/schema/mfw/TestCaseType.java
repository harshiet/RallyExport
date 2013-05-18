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
 * <p>Java class for TestCaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TestCaseType">
 *   &lt;complexContent>
 *     &lt;extension base="{}ArtifactType">
 *       &lt;sequence>
 *         &lt;element name="Attachments" type="{}TestCaseAttachmentsType" minOccurs="0"/>
 *         &lt;element name="DefectStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastBuild" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastRun" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="LastVerdict" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Method" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Objective" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Package" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostConditions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PreConditions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Priority" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Recycled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="Results" type="{}TestCaseResultsType" minOccurs="0"/>
 *         &lt;element name="Risk" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Steps" type="{}TestCaseStepsType" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ValidationExpectedResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ValidationInput" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WorkProduct" type="{}ArtifactType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TestCaseType", propOrder = {
    "attachments",
    "defectStatus",
    "lastBuild",
    "lastRun",
    "lastVerdict",
    "method",
    "objective",
    "_package",
    "postConditions",
    "preConditions",
    "priority",
    "recycled",
    "results",
    "risk",
    "steps",
    "type",
    "validationExpectedResult",
    "validationInput",
    "workProduct"
})
public class TestCaseType
    extends ArtifactType
{

    @XmlElement(name = "Attachments")
    protected TestCaseAttachmentsType attachments;
    @XmlElement(name = "DefectStatus")
    protected String defectStatus;
    @XmlElement(name = "LastBuild")
    protected String lastBuild;
    @XmlElement(name = "LastRun")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastRun;
    @XmlElement(name = "LastVerdict")
    protected String lastVerdict;
    @XmlElement(name = "Method")
    protected String method;
    @XmlElement(name = "Objective")
    protected String objective;
    @XmlElement(name = "Package")
    protected String _package;
    @XmlElement(name = "PostConditions")
    protected String postConditions;
    @XmlElement(name = "PreConditions")
    protected String preConditions;
    @XmlElement(name = "Priority")
    protected String priority;
    @XmlElement(name = "Recycled")
    protected Boolean recycled;
    @XmlElement(name = "Results")
    protected TestCaseResultsType results;
    @XmlElement(name = "Risk")
    protected String risk;
    @XmlElement(name = "Steps")
    protected TestCaseStepsType steps;
    @XmlElement(name = "Type")
    protected String type;
    @XmlElement(name = "ValidationExpectedResult")
    protected String validationExpectedResult;
    @XmlElement(name = "ValidationInput")
    protected String validationInput;
    @XmlElement(name = "WorkProduct")
    protected ArtifactType workProduct;

    /**
     * Gets the value of the attachments property.
     * 
     * @return
     *     possible object is
     *     {@link TestCaseAttachmentsType }
     *     
     */
    public TestCaseAttachmentsType getAttachments() {
        return attachments;
    }

    /**
     * Sets the value of the attachments property.
     * 
     * @param value
     *     allowed object is
     *     {@link TestCaseAttachmentsType }
     *     
     */
    public void setAttachments(TestCaseAttachmentsType value) {
        this.attachments = value;
    }

    /**
     * Gets the value of the defectStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefectStatus() {
        return defectStatus;
    }

    /**
     * Sets the value of the defectStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefectStatus(String value) {
        this.defectStatus = value;
    }

    /**
     * Gets the value of the lastBuild property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastBuild() {
        return lastBuild;
    }

    /**
     * Sets the value of the lastBuild property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastBuild(String value) {
        this.lastBuild = value;
    }

    /**
     * Gets the value of the lastRun property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastRun() {
        return lastRun;
    }

    /**
     * Sets the value of the lastRun property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastRun(XMLGregorianCalendar value) {
        this.lastRun = value;
    }

    /**
     * Gets the value of the lastVerdict property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastVerdict() {
        return lastVerdict;
    }

    /**
     * Sets the value of the lastVerdict property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastVerdict(String value) {
        this.lastVerdict = value;
    }

    /**
     * Gets the value of the method property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets the value of the method property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMethod(String value) {
        this.method = value;
    }

    /**
     * Gets the value of the objective property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjective() {
        return objective;
    }

    /**
     * Sets the value of the objective property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjective(String value) {
        this.objective = value;
    }

    /**
     * Gets the value of the package property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPackage() {
        return _package;
    }

    /**
     * Sets the value of the package property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPackage(String value) {
        this._package = value;
    }

    /**
     * Gets the value of the postConditions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostConditions() {
        return postConditions;
    }

    /**
     * Sets the value of the postConditions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostConditions(String value) {
        this.postConditions = value;
    }

    /**
     * Gets the value of the preConditions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreConditions() {
        return preConditions;
    }

    /**
     * Sets the value of the preConditions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreConditions(String value) {
        this.preConditions = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriority(String value) {
        this.priority = value;
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
     * Gets the value of the results property.
     * 
     * @return
     *     possible object is
     *     {@link TestCaseResultsType }
     *     
     */
    public TestCaseResultsType getResults() {
        return results;
    }

    /**
     * Sets the value of the results property.
     * 
     * @param value
     *     allowed object is
     *     {@link TestCaseResultsType }
     *     
     */
    public void setResults(TestCaseResultsType value) {
        this.results = value;
    }

    /**
     * Gets the value of the risk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRisk() {
        return risk;
    }

    /**
     * Sets the value of the risk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRisk(String value) {
        this.risk = value;
    }

    /**
     * Gets the value of the steps property.
     * 
     * @return
     *     possible object is
     *     {@link TestCaseStepsType }
     *     
     */
    public TestCaseStepsType getSteps() {
        return steps;
    }

    /**
     * Sets the value of the steps property.
     * 
     * @param value
     *     allowed object is
     *     {@link TestCaseStepsType }
     *     
     */
    public void setSteps(TestCaseStepsType value) {
        this.steps = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the validationExpectedResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidationExpectedResult() {
        return validationExpectedResult;
    }

    /**
     * Sets the value of the validationExpectedResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidationExpectedResult(String value) {
        this.validationExpectedResult = value;
    }

    /**
     * Gets the value of the validationInput property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidationInput() {
        return validationInput;
    }

    /**
     * Sets the value of the validationInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidationInput(String value) {
        this.validationInput = value;
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

}
