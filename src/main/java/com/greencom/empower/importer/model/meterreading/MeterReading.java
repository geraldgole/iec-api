
package com.greencom.empower.importer.model.meterreading;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for MeterReading complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeterReading">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomerAgreement" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mRID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="EndDeviceEvents" type="{http://iec.ch/TC57/2009/MeterReadings#}EndDeviceEvent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="IntervalBlocks" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IntervalReadings" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="timeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                             &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *                             &lt;element name="ReadingQualities" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="quality" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="Pending" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="multiplyBeforeAdd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                             &lt;element name="offset" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                             &lt;element name="scalarDenominator" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                             &lt;element name="scalarFloat" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *                             &lt;element name="scalarNumerator" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *                             &lt;element name="ReadingType">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ReadingType">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="MeterAsset">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mRID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="status" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Readings" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="timeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *                   &lt;element name="ReadingQualities" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="quality" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="ReadingType">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ServiceDeliveryPoint" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mRID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterReading", namespace = "http://iec.ch/TC57/2009/MeterReadings#", propOrder = {
    "customerAgreement",
    "endDeviceEvents",
    "intervalBlocks",
    "meterAsset",
    "readings",
    "serviceDeliveryPoint"
})
public class MeterReading {

    @XmlElement(name = "CustomerAgreement", namespace = "http://iec.ch/TC57/2009/MeterReadings#")
    protected MeterReading.CustomerAgreement customerAgreement;
    @XmlElement(name = "EndDeviceEvents", namespace = "http://iec.ch/TC57/2009/MeterReadings#")
    protected List<EndDeviceEvent> endDeviceEvents;
    @XmlElement(name = "IntervalBlocks", namespace = "http://iec.ch/TC57/2009/MeterReadings#")
    protected List<MeterReading.IntervalBlocks> intervalBlocks;
    @XmlElement(name = "MeterAsset", namespace = "http://iec.ch/TC57/2009/MeterReadings#", required = true)
    protected MeterReading.MeterAsset meterAsset;
    @XmlElement(name = "Readings", namespace = "http://iec.ch/TC57/2009/MeterReadings#")
    protected List<MeterReading.Readings> readings;
    @XmlElement(name = "ServiceDeliveryPoint", namespace = "http://iec.ch/TC57/2009/MeterReadings#")
    protected MeterReading.ServiceDeliveryPoint serviceDeliveryPoint;

    /**
     * Gets the value of the customerAgreement property.
     * 
     * @return
     *     possible object is
     *     {@link MeterReading.CustomerAgreement }
     *     
     */
    public MeterReading.CustomerAgreement getCustomerAgreement() {
        return customerAgreement;
    }

    /**
     * Sets the value of the customerAgreement property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeterReading.CustomerAgreement }
     *     
     */
    public void setCustomerAgreement(MeterReading.CustomerAgreement value) {
        this.customerAgreement = value;
    }

    /**
     * Gets the value of the endDeviceEvents property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the endDeviceEvents property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEndDeviceEvents().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EndDeviceEvent }
     * 
     * 
     */
    public List<EndDeviceEvent> getEndDeviceEvents() {
        if (endDeviceEvents == null) {
            endDeviceEvents = new ArrayList<EndDeviceEvent>();
        }
        return this.endDeviceEvents;
    }

    /**
     * Gets the value of the intervalBlocks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the intervalBlocks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntervalBlocks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MeterReading.IntervalBlocks }
     * 
     * 
     */
    public List<MeterReading.IntervalBlocks> getIntervalBlocks() {
        if (intervalBlocks == null) {
            intervalBlocks = new ArrayList<MeterReading.IntervalBlocks>();
        }
        return this.intervalBlocks;
    }

    /**
     * Gets the value of the meterAsset property.
     * 
     * @return
     *     possible object is
     *     {@link MeterReading.MeterAsset }
     *     
     */
    public MeterReading.MeterAsset getMeterAsset() {
        return meterAsset;
    }

    /**
     * Sets the value of the meterAsset property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeterReading.MeterAsset }
     *     
     */
    public void setMeterAsset(MeterReading.MeterAsset value) {
        this.meterAsset = value;
    }

    /**
     * Gets the value of the readings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the readings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReadings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MeterReading.Readings }
     * 
     * 
     */
    public List<MeterReading.Readings> getReadings() {
        if (readings == null) {
            readings = new ArrayList<MeterReading.Readings>();
        }
        return this.readings;
    }

    /**
     * Gets the value of the serviceDeliveryPoint property.
     * 
     * @return
     *     possible object is
     *     {@link MeterReading.ServiceDeliveryPoint }
     *     
     */
    public MeterReading.ServiceDeliveryPoint getServiceDeliveryPoint() {
        return serviceDeliveryPoint;
    }

    /**
     * Sets the value of the serviceDeliveryPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeterReading.ServiceDeliveryPoint }
     *     
     */
    public void setServiceDeliveryPoint(MeterReading.ServiceDeliveryPoint value) {
        this.serviceDeliveryPoint = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="mRID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mrid"
    })
    public static class CustomerAgreement {

        @XmlElement(name = "mRID", namespace = "http://iec.ch/TC57/2009/MeterReadings#", required = true)
        protected String mrid;

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

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="IntervalReadings" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="timeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
     *                   &lt;element name="ReadingQualities" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="quality" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="Pending" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="multiplyBeforeAdd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                   &lt;element name="offset" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *                   &lt;element name="scalarDenominator" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *                   &lt;element name="scalarFloat" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
     *                   &lt;element name="scalarNumerator" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
     *                   &lt;element name="ReadingType">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ReadingType">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "intervalReadings",
        "pending",
        "readingType"
    })
    public static class IntervalBlocks {

        @XmlElement(name = "IntervalReadings", namespace = "http://iec.ch/TC57/2009/MeterReadings#")
        protected List<MeterReading.IntervalBlocks.IntervalReadings> intervalReadings;
        @XmlElement(name = "Pending", namespace = "http://iec.ch/TC57/2009/MeterReadings#")
        protected MeterReading.IntervalBlocks.Pending pending;
        @XmlElement(name = "ReadingType", namespace = "http://iec.ch/TC57/2009/MeterReadings#", required = true)
        protected MeterReading.IntervalBlocks.ReadingType readingType;

        /**
         * Gets the value of the intervalReadings property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the intervalReadings property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIntervalReadings().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MeterReading.IntervalBlocks.IntervalReadings }
         * 
         * 
         */
        public List<MeterReading.IntervalBlocks.IntervalReadings> getIntervalReadings() {
            if (intervalReadings == null) {
                intervalReadings = new ArrayList<MeterReading.IntervalBlocks.IntervalReadings>();
            }
            return this.intervalReadings;
        }

        /**
         * Gets the value of the pending property.
         * 
         * @return
         *     possible object is
         *     {@link MeterReading.IntervalBlocks.Pending }
         *     
         */
        public MeterReading.IntervalBlocks.Pending getPending() {
            return pending;
        }

        /**
         * Sets the value of the pending property.
         * 
         * @param value
         *     allowed object is
         *     {@link MeterReading.IntervalBlocks.Pending }
         *     
         */
        public void setPending(MeterReading.IntervalBlocks.Pending value) {
            this.pending = value;
        }

        /**
         * Gets the value of the readingType property.
         * 
         * @return
         *     possible object is
         *     {@link MeterReading.IntervalBlocks.ReadingType }
         *     
         */
        public MeterReading.IntervalBlocks.ReadingType getReadingType() {
            return readingType;
        }

        /**
         * Sets the value of the readingType property.
         * 
         * @param value
         *     allowed object is
         *     {@link MeterReading.IntervalBlocks.ReadingType }
         *     
         */
        public void setReadingType(MeterReading.IntervalBlocks.ReadingType value) {
            this.readingType = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="timeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
         *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
         *         &lt;element name="ReadingQualities" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="quality" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "timeStamp",
            "value",
            "readingQualities"
        })
        public static class IntervalReadings {

            @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#", required = true)
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar timeStamp;
            @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#")
            protected Float value;
            @XmlElement(name = "ReadingQualities", namespace = "http://iec.ch/TC57/2009/MeterReadings#")
            protected List<MeterReading.IntervalBlocks.IntervalReadings.ReadingQualities> readingQualities;

            /**
             * Gets the value of the timeStamp property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getTimeStamp() {
                return timeStamp;
            }

            /**
             * Sets the value of the timeStamp property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setTimeStamp(XMLGregorianCalendar value) {
                this.timeStamp = value;
            }

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link Float }
             *     
             */
            public Float getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link Float }
             *     
             */
            public void setValue(Float value) {
                this.value = value;
            }

            /**
             * Gets the value of the readingQualities property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the readingQualities property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getReadingQualities().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link MeterReading.IntervalBlocks.IntervalReadings.ReadingQualities }
             * 
             * 
             */
            public List<MeterReading.IntervalBlocks.IntervalReadings.ReadingQualities> getReadingQualities() {
                if (readingQualities == null) {
                    readingQualities = new ArrayList<MeterReading.IntervalBlocks.IntervalReadings.ReadingQualities>();
                }
                return this.readingQualities;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="quality" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "quality"
            })
            public static class ReadingQualities {

                @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#", required = true)
                protected String quality;

                /**
                 * Gets the value of the quality property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getQuality() {
                    return quality;
                }

                /**
                 * Sets the value of the quality property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setQuality(String value) {
                    this.quality = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="multiplyBeforeAdd" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
         *         &lt;element name="offset" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
         *         &lt;element name="scalarDenominator" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
         *         &lt;element name="scalarFloat" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
         *         &lt;element name="scalarNumerator" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
         *         &lt;element name="ReadingType">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "multiplyBeforeAdd",
            "offset",
            "scalarDenominator",
            "scalarFloat",
            "scalarNumerator",
            "readingType"
        })
        public static class Pending {

            @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#")
            protected Boolean multiplyBeforeAdd;
            @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#")
            protected BigInteger offset;
            @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#")
            protected BigInteger scalarDenominator;
            @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#")
            protected Float scalarFloat;
            @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#")
            protected BigInteger scalarNumerator;
            @XmlElement(name = "ReadingType", namespace = "http://iec.ch/TC57/2009/MeterReadings#", required = true)
            protected MeterReading.IntervalBlocks.Pending.ReadingType readingType;

            /**
             * Gets the value of the multiplyBeforeAdd property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isMultiplyBeforeAdd() {
                return multiplyBeforeAdd;
            }

            /**
             * Sets the value of the multiplyBeforeAdd property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setMultiplyBeforeAdd(Boolean value) {
                this.multiplyBeforeAdd = value;
            }

            /**
             * Gets the value of the offset property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getOffset() {
                return offset;
            }

            /**
             * Sets the value of the offset property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setOffset(BigInteger value) {
                this.offset = value;
            }

            /**
             * Gets the value of the scalarDenominator property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getScalarDenominator() {
                return scalarDenominator;
            }

            /**
             * Sets the value of the scalarDenominator property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setScalarDenominator(BigInteger value) {
                this.scalarDenominator = value;
            }

            /**
             * Gets the value of the scalarFloat property.
             * 
             * @return
             *     possible object is
             *     {@link Float }
             *     
             */
            public Float getScalarFloat() {
                return scalarFloat;
            }

            /**
             * Sets the value of the scalarFloat property.
             * 
             * @param value
             *     allowed object is
             *     {@link Float }
             *     
             */
            public void setScalarFloat(Float value) {
                this.scalarFloat = value;
            }

            /**
             * Gets the value of the scalarNumerator property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getScalarNumerator() {
                return scalarNumerator;
            }

            /**
             * Sets the value of the scalarNumerator property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setScalarNumerator(BigInteger value) {
                this.scalarNumerator = value;
            }

            /**
             * Gets the value of the readingType property.
             * 
             * @return
             *     possible object is
             *     {@link MeterReading.IntervalBlocks.Pending.ReadingType }
             *     
             */
            public MeterReading.IntervalBlocks.Pending.ReadingType getReadingType() {
                return readingType;
            }

            /**
             * Sets the value of the readingType property.
             * 
             * @param value
             *     allowed object is
             *     {@link MeterReading.IntervalBlocks.Pending.ReadingType }
             *     
             */
            public void setReadingType(MeterReading.IntervalBlocks.Pending.ReadingType value) {
                this.readingType = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class ReadingType {

                @XmlAttribute(name = "ref")
                protected String ref;

                /**
                 * Gets the value of the ref property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getRef() {
                    return ref;
                }

                /**
                 * Sets the value of the ref property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setRef(String value) {
                    this.ref = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ReadingType {

            @XmlAttribute(name = "ref")
            protected String ref;

            /**
             * Gets the value of the ref property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRef() {
                return ref;
            }

            /**
             * Sets the value of the ref property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRef(String value) {
                this.ref = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="mRID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="status" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mrid",
        "status"
    })
    public static class MeterAsset {

        @XmlElement(name = "mRID", namespace = "http://iec.ch/TC57/2009/MeterReadings#", required = true)
        protected String mrid;
        @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#")
        protected MeterReading.MeterAsset.Status status;

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
         * Gets the value of the status property.
         * 
         * @return
         *     possible object is
         *     {@link MeterReading.MeterAsset.Status }
         *     
         */
        public MeterReading.MeterAsset.Status getStatus() {
            return status;
        }

        /**
         * Sets the value of the status property.
         * 
         * @param value
         *     allowed object is
         *     {@link MeterReading.MeterAsset.Status }
         *     
         */
        public void setStatus(MeterReading.MeterAsset.Status value) {
            this.status = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class Status {

            @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#", required = true)
            protected String value;

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="timeStamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
     *         &lt;element name="ReadingQualities" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="quality" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="ReadingType">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "timeStamp",
        "value",
        "readingQualities",
        "readingType"
    })
    public static class Readings {

        @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#", required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar timeStamp;
        @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#")
        protected Float value;
        @XmlElement(name = "ReadingQualities", namespace = "http://iec.ch/TC57/2009/MeterReadings#")
        protected List<MeterReading.Readings.ReadingQualities> readingQualities;
        @XmlElement(name = "ReadingType", namespace = "http://iec.ch/TC57/2009/MeterReadings#", required = true)
        protected MeterReading.Readings.ReadingType readingType;

        /**
         * Gets the value of the timeStamp property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getTimeStamp() {
            return timeStamp;
        }

        /**
         * Sets the value of the timeStamp property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setTimeStamp(XMLGregorianCalendar value) {
            this.timeStamp = value;
        }

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link Float }
         *     
         */
        public Float getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link Float }
         *     
         */
        public void setValue(Float value) {
            this.value = value;
        }

        /**
         * Gets the value of the readingQualities property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the readingQualities property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReadingQualities().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MeterReading.Readings.ReadingQualities }
         * 
         * 
         */
        public List<MeterReading.Readings.ReadingQualities> getReadingQualities() {
            if (readingQualities == null) {
                readingQualities = new ArrayList<MeterReading.Readings.ReadingQualities>();
            }
            return this.readingQualities;
        }

        /**
         * Gets the value of the readingType property.
         * 
         * @return
         *     possible object is
         *     {@link MeterReading.Readings.ReadingType }
         *     
         */
        public MeterReading.Readings.ReadingType getReadingType() {
            return readingType;
        }

        /**
         * Sets the value of the readingType property.
         * 
         * @param value
         *     allowed object is
         *     {@link MeterReading.Readings.ReadingType }
         *     
         */
        public void setReadingType(MeterReading.Readings.ReadingType value) {
            this.readingType = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="quality" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "quality"
        })
        public static class ReadingQualities {

            @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#", required = true)
            protected String quality;

            /**
             * Gets the value of the quality property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getQuality() {
                return quality;
            }

            /**
             * Sets the value of the quality property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setQuality(String value) {
                this.quality = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class ReadingType {

            @XmlAttribute(name = "ref")
            protected String ref;

            /**
             * Gets the value of the ref property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRef() {
                return ref;
            }

            /**
             * Sets the value of the ref property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRef(String value) {
                this.ref = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="mRID" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mrid"
    })
    public static class ServiceDeliveryPoint {

        @XmlElement(name = "mRID", namespace = "http://iec.ch/TC57/2009/MeterReadings#", required = true)
        protected String mrid;

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

    }

}
