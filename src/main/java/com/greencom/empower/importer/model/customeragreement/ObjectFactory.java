
package com.greencom.empower.importer.model.customeragreement;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the customeragreement package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CustomerAgreements_QNAME = new QName("http://iec.ch/TC57/2009/CustomerAgreement#", "CustomerAgreements");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: customeragreement
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CustomerAgreements }
     * 
     */
    public CustomerAgreements createCustomerAgreements() {
        return new CustomerAgreements();
    }

    /**
     * Create an instance of {@link CustomerAgreement }
     * 
     */
    public CustomerAgreement createCustomerAgreement() {
        return new CustomerAgreement();
    }

    /**
     * Create an instance of {@link ServiceCategory }
     * 
     */
    public ServiceCategory createServiceCategory() {
        return new ServiceCategory();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link UsagePoint }
     * 
     */
    public UsagePoint createUsagePoint() {
        return new UsagePoint();
    }

    /**
     * Create an instance of {@link ServiceSupplier }
     * 
     */
    public ServiceSupplier createServiceSupplier() {
        return new ServiceSupplier();
    }

    /**
     * Create an instance of {@link CustomerAccount }
     * 
     */
    public CustomerAccount createCustomerAccount() {
        return new CustomerAccount();
    }

    /**
     * Create an instance of {@link ValidityInterval }
     * 
     */
    public ValidityInterval createValidityInterval() {
        return new ValidityInterval();
    }

    /**
     * Create an instance of {@link UsagePoints }
     * 
     */
    public UsagePoints createUsagePoints() {
        return new UsagePoints();
    }

    /**
     * Create an instance of {@link Status }
     * 
     */
    public Status createStatus() {
        return new Status();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerAgreements }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2009/CustomerAgreement#", name = "CustomerAgreements")
    public JAXBElement<CustomerAgreements> createCustomerAgreements(CustomerAgreements value) {
        return new JAXBElement<CustomerAgreements>(_CustomerAgreements_QNAME, CustomerAgreements.class, null, value);
    }

}
