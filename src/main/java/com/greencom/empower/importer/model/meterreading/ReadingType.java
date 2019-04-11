
package com.greencom.empower.importer.model.meterreading;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReadingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReadingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mRID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="aliasName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="channelNumber" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="defaultQuality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="defaultValueDataType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dynamicConfiguration" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="intervalLength" type="{http://iec.ch/TC57/2009/MeterReadings#}Seconds" minOccurs="0"/>
 *         &lt;element name="kind" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="current"/>
 *               &lt;enumeration value="currentAngle"/>
 *               &lt;enumeration value="date"/>
 *               &lt;enumeration value="demand"/>
 *               &lt;enumeration value="energy"/>
 *               &lt;enumeration value="other"/>
 *               &lt;enumeration value="phaseAngle"/>
 *               &lt;enumeration value="power"/>
 *               &lt;enumeration value="powerFactor"/>
 *               &lt;enumeration value="pressure"/>
 *               &lt;enumeration value="time"/>
 *               &lt;enumeration value="voltage"/>
 *               &lt;enumeration value="voltageAngle"/>
 *               &lt;enumeration value="volume"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="multiplier" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="G"/>
 *               &lt;enumeration value="M"/>
 *               &lt;enumeration value="T"/>
 *               &lt;enumeration value="c"/>
 *               &lt;enumeration value="d"/>
 *               &lt;enumeration value="k"/>
 *               &lt;enumeration value="m"/>
 *               &lt;enumeration value="micro"/>
 *               &lt;enumeration value="n"/>
 *               &lt;enumeration value="none"/>
 *               &lt;enumeration value="p"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reverseChronology" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="unit">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="A"/>
 *               &lt;enumeration value="F"/>
 *               &lt;enumeration value="H"/>
 *               &lt;enumeration value="Hz"/>
 *               &lt;enumeration value="Hz-1"/>
 *               &lt;enumeration value="J"/>
 *               &lt;enumeration value="J/s"/>
 *               &lt;enumeration value="N"/>
 *               &lt;enumeration value="Pa"/>
 *               &lt;enumeration value="S"/>
 *               &lt;enumeration value="V"/>
 *               &lt;enumeration value="V/VAr"/>
 *               &lt;enumeration value="VA"/>
 *               &lt;enumeration value="VAh"/>
 *               &lt;enumeration value="VAr"/>
 *               &lt;enumeration value="VArh"/>
 *               &lt;enumeration value="W"/>
 *               &lt;enumeration value="W/Hz"/>
 *               &lt;enumeration value="W/s"/>
 *               &lt;enumeration value="Wh"/>
 *               &lt;enumeration value="deg"/>
 *               &lt;enumeration value="g"/>
 *               &lt;enumeration value="h"/>
 *               &lt;enumeration value="kg/J"/>
 *               &lt;enumeration value="m"/>
 *               &lt;enumeration value="m2"/>
 *               &lt;enumeration value="m3"/>
 *               &lt;enumeration value="min"/>
 *               &lt;enumeration value="none"/>
 *               &lt;enumeration value="ohm"/>
 *               &lt;enumeration value="rad"/>
 *               &lt;enumeration value="s"/>
 *               &lt;enumeration value="s-1"/>
 *               &lt;enumeration value="ÂºC"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
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
@XmlType(name = "ReadingType", namespace = "http://iec.ch/TC57/2009/MeterReadings#", propOrder = {
    "mrid",
    "aliasName",
    "channelNumber",
    "defaultQuality",
    "defaultValueDataType",
    "dynamicConfiguration",
    "intervalLength",
    "kind",
    "multiplier",
    "name",
    "reverseChronology",
    "unit"
})
public class ReadingType {

    @XmlElement(name = "mRID", namespace = "http://iec.ch/TC57/2009/MeterReadings#", required = true)
    protected String mrid;
    @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#")
    protected String aliasName;
    @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#")
    protected BigInteger channelNumber;
    @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#")
    protected String defaultQuality;
    @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#")
    protected String defaultValueDataType;
    @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#")
    protected String dynamicConfiguration;
    @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#")
    protected Float intervalLength;
    @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#")
    protected String kind;
    @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#")
    protected String multiplier;
    @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#", required = true)
    protected String name;
    @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#")
    protected Boolean reverseChronology;
    @XmlElement(namespace = "http://iec.ch/TC57/2009/MeterReadings#", required = true)
    protected String unit;

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
     * Gets the value of the channelNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getChannelNumber() {
        return channelNumber;
    }

    /**
     * Sets the value of the channelNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setChannelNumber(BigInteger value) {
        this.channelNumber = value;
    }

    /**
     * Gets the value of the defaultQuality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultQuality() {
        return defaultQuality;
    }

    /**
     * Sets the value of the defaultQuality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultQuality(String value) {
        this.defaultQuality = value;
    }

    /**
     * Gets the value of the defaultValueDataType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultValueDataType() {
        return defaultValueDataType;
    }

    /**
     * Sets the value of the defaultValueDataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultValueDataType(String value) {
        this.defaultValueDataType = value;
    }

    /**
     * Gets the value of the dynamicConfiguration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDynamicConfiguration() {
        return dynamicConfiguration;
    }

    /**
     * Sets the value of the dynamicConfiguration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDynamicConfiguration(String value) {
        this.dynamicConfiguration = value;
    }

    /**
     * Gets the value of the intervalLength property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getIntervalLength() {
        return intervalLength;
    }

    /**
     * Sets the value of the intervalLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setIntervalLength(Float value) {
        this.intervalLength = value;
    }

    /**
     * Gets the value of the kind property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKind() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKind(String value) {
        this.kind = value;
    }

    /**
     * Gets the value of the multiplier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMultiplier() {
        return multiplier;
    }

    /**
     * Sets the value of the multiplier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMultiplier(String value) {
        this.multiplier = value;
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
     * Gets the value of the reverseChronology property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReverseChronology() {
        return reverseChronology;
    }

    /**
     * Sets the value of the reverseChronology property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReverseChronology(Boolean value) {
        this.reverseChronology = value;
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnit(String value) {
        this.unit = value;
    }

}
