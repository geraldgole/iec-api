
package com.greencom.empower.importer.model.customeragreement;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UsagePoints complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UsagePoints">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UsagePoint" type="{http://iec.ch/TC57/2009/CustomerAgreement#}UsagePoint" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UsagePoints", propOrder = {
    "usagePoint"
})
public class UsagePoints {

    @XmlElement(name = "UsagePoint")
    protected List<UsagePoint> usagePoint;

    /**
     * Gets the value of the usagePoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usagePoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsagePoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UsagePoint }
     * 
     * 
     */
    public List<UsagePoint> getUsagePoint() {
        if (usagePoint == null) {
            usagePoint = new ArrayList<UsagePoint>();
        }
        return this.usagePoint;
    }

    @Override
    public String toString() {
        return "{"
                + "\"usagePoint\": " + usagePoint
                + "}";
    }
}
