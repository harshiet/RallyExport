//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.17 at 11:55:40 PM EDT 
//


package com.ceb.ppm.schema.mfw;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HierarchicalRequirementPredecessorsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HierarchicalRequirementPredecessorsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HierarchicalRequirement" type="{}HierarchicalRequirementType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HierarchicalRequirementPredecessorsType", propOrder = {
    "hierarchicalRequirement"
})
public class HierarchicalRequirementPredecessorsType {

    @XmlElement(name = "HierarchicalRequirement")
    protected List<HierarchicalRequirementType> hierarchicalRequirement;

    /**
     * Gets the value of the hierarchicalRequirement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hierarchicalRequirement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHierarchicalRequirement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HierarchicalRequirementType }
     * 
     * 
     */
    public List<HierarchicalRequirementType> getHierarchicalRequirement() {
        if (hierarchicalRequirement == null) {
            hierarchicalRequirement = new ArrayList<HierarchicalRequirementType>();
        }
        return this.hierarchicalRequirement;
    }

}
