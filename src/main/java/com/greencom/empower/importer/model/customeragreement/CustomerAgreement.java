
package com.greencom.empower.importer.model.customeragreement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CustomerAgreement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomerAgreement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mRID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="aliasName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastModifiedDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="createdDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signDate" type="{http://iec.ch/TC57/2009/CustomerAgreement#}AbsoluteDate" minOccurs="0"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="revisionNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Customer" type="{http://iec.ch/TC57/2009/CustomerAgreement#}Customer"/>
 *         &lt;element name="CustomerAccount" type="{http://iec.ch/TC57/2009/CustomerAgreement#}CustomerAccount"/>
 *         &lt;element name="docStatus" type="{http://iec.ch/TC57/2009/CustomerAgreement#}status"/>
 *         &lt;element name="ServiceSupplier" type="{http://iec.ch/TC57/2009/CustomerAgreement#}ServiceSupplier"/>
 *         &lt;element name="status" type="{http://iec.ch/TC57/2009/CustomerAgreement#}status"/>
 *         &lt;element name="validityInterval" type="{http://iec.ch/TC57/2009/CustomerAgreement#}validityInterval"/>
 *         &lt;element name="ServiceCategory" type="{http://iec.ch/TC57/2009/CustomerAgreement#}ServiceCategory" minOccurs="0"/>
 *         &lt;element name="UsagePoints" type="{http://iec.ch/TC57/2009/CustomerAgreement#}UsagePoints" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomerAgreement", propOrder = {
    "mrid",
    "aliasName",
    "category",
    "description",
    "lastModifiedDateTime",
    "createdDateTime",
    "name",
    "signDate",
    "title",
    "revisionNumber",
    "subject",
    "type",
    "customer",
    "customerAccount",
    "docStatus",
    "serviceSupplier",
    "status",
    "validityInterval",
    "serviceCategory",
    "usagePoints"
})
public class CustomerAgreement {

    @XmlElement(name = "mRID", required = true)
    protected String mrid;
    protected String aliasName;
    @XmlElement(required = true)
    protected String category;
    protected String description;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastModifiedDateTime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDateTime;
    protected String name;
    protected String signDate;
    protected String title;
    protected String revisionNumber;
    protected String subject;
    protected String type;
    @XmlElement(name = "Customer", required = true)
    protected Customer customer;
    @XmlElement(name = "CustomerAccount", required = true)
    protected CustomerAccount customerAccount;
    @XmlElement(required = true)
    protected Status docStatus;
    @XmlElement(name = "ServiceSupplier", required = true)
    protected ServiceSupplier serviceSupplier;
    @XmlElement(required = true)
    protected Status status;
    @XmlElement(required = true)
    protected ValidityInterval validityInterval;
    @XmlElement(name = "ServiceCategory")
    protected ServiceCategory serviceCategory;
    @XmlElement(name = "UsagePoints")
    protected UsagePoints usagePoints;

    /**
     * Gets the value of the mrid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMRID() {
        return mrid;
    }

    /**
     * Sets the value of the mrid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMRID(String value) {
        this.mrid = value;
    }

    /**
     * Gets the value of the aliasName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasName() {
        return aliasName;
    }

    /**
     * Sets the value of the aliasName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasName(String value) {
        this.aliasName = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the lastModifiedDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    /**
     * Sets the value of the lastModifiedDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastModifiedDateTime(XMLGregorianCalendar value) {
        this.lastModifiedDateTime = value;
    }

    /**
     * Gets the value of the createdDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedDateTime() {
        return createdDateTime;
    }

    /**
     * Sets the value of the createdDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedDateTime(XMLGregorianCalendar value) {
        this.createdDateTime = value;
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
     * Gets the value of the signDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignDate() {
        return signDate;
    }

    /**
     * Sets the value of the signDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignDate(String value) {
        this.signDate = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the revisionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevisionNumber() {
        return revisionNumber;
    }

    /**
     * Sets the value of the revisionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevisionNumber(String value) {
        this.revisionNumber = value;
    }

    /**
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubject(String value) {
        this.subject = value;
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
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setCustomer(Customer value) {
        this.customer = value;
    }

    /**
     * Gets the value of the customerAccount property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerAccount }
     *     
     */
    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    /**
     * Sets the value of the customerAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerAccount }
     *     
     */
    public void setCustomerAccount(CustomerAccount value) {
        this.customerAccount = value;
    }

    /**
     * Gets the value of the docStatus property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getDocStatus() {
        return docStatus;
    }

    /**
     * Sets the value of the docStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setDocStatus(Status value) {
        this.docStatus = value;
    }

    /**
     * Gets the value of the serviceSupplier property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceSupplier }
     *     
     */
    public ServiceSupplier getServiceSupplier() {
        return serviceSupplier;
    }

    /**
     * Sets the value of the serviceSupplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceSupplier }
     *     
     */
    public void setServiceSupplier(ServiceSupplier value) {
        this.serviceSupplier = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the validityInterval property.
     * 
     * @return
     *     possible object is
     *     {@link ValidityInterval }
     *     
     */
    public ValidityInterval getValidityInterval() {
        return validityInterval;
    }

    /**
     * Sets the value of the validityInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidityInterval }
     *     
     */
    public void setValidityInterval(ValidityInterval value) {
        this.validityInterval = value;
    }

    /**
     * Gets the value of the serviceCategory property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceCategory }
     *     
     */
    public ServiceCategory getServiceCategory() {
        return serviceCategory;
    }

    /**
     * Sets the value of the serviceCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceCategory }
     *     
     */
    public void setServiceCategory(ServiceCategory value) {
        this.serviceCategory = value;
    }

    /**
     * Gets the value of the usagePoints property.
     * 
     * @return
     *     possible object is
     *     {@link UsagePoints }
     *     
     */
    public UsagePoints getUsagePoints() {
        return usagePoints;
    }

    /**
     * Sets the value of the usagePoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link UsagePoints }
     *     
     */
    public void setUsagePoints(UsagePoints value) {
        this.usagePoints = value;
    }

    @Override
    public String toString() {
        return "{"
                + "\"mrid\": \"" + mrid + "\""
                + ", \"aliasName\": \"" + aliasName + "\""
                + ", \"category\": \"" + category + "\""
                + ", \"description\": \"" + description + "\""
                + ", \"lastModifiedDateTime\": \"" + lastModifiedDateTime + "\""
                + ", \"createdDateTime\": \"" + createdDateTime + "\""
                + ", \"name\": \"" + name + "\""
                + ", \"signDate\": \"" + signDate + "\""
                + ", \"title\": \"" + title + "\""
                + ", \"revisionNumber\": \"" + revisionNumber + "\""
                + ", \"subject\": \"" + subject + "\""
                + ", \"type\": \"" + type + "\""
                + ", \"customer\": " + customer
                + ", \"customerAccount\": " + customerAccount
                + ", \"docStatus\": " + docStatus
                + ", \"serviceSupplier\": " + serviceSupplier
                + ", \"status\": " + status
                + ", \"validityInterval\": " + validityInterval
                + ", \"serviceCategory\": " + serviceCategory
                + ", \"usagePoints\": " + usagePoints
                + "}";
    }

}
