
package com.greencom.empower.importer.model.customeragreement;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;


/**
 * <p>Java class for CustomerAgreements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerAgreements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomerAgreement" type="{http://iec.ch/TC57/2009/CustomerAgreement#}CustomerAgreement" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "CustomerAgreements")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerAgreements", propOrder = {
    "customerAgreement"
})
public class CustomerAgreements {

    @XmlElement(name = "CustomerAgreement")
    protected List<CustomerAgreement> customerAgreement;

    /**
     * Gets the value of the customerAgreement property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customerAgreement property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomerAgreement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerAgreement }
     * 
     * 
     */
    public List<CustomerAgreement> getCustomerAgreement() {
        if (customerAgreement == null) {
            customerAgreement = new ArrayList<CustomerAgreement>();
        }
        return this.customerAgreement;
    }

    @Override
    public String toString() {
        return "{"
                + "\"customerAgreement\": " + customerAgreement
                + "}";
    }
}
