
package com.greencom.empower.importer.model.meterreading;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MeterReadings complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeterReadings">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MeterReading" type="{http://iec.ch/TC57/2009/MeterReadings#}MeterReading" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ReadingType" type="{http://iec.ch/TC57/2009/MeterReadings#}ReadingType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterReadings", namespace = "http://iec.ch/TC57/2009/MeterReadings#", propOrder = {
    "meterReading",
    "readingType"
})
public class MeterReadings {

    @XmlElement(name = "MeterReading", namespace = "http://iec.ch/TC57/2009/MeterReadings#")
    protected List<MeterReading> meterReading;
    @XmlElement(name = "ReadingType", namespace = "http://iec.ch/TC57/2009/MeterReadings#")
    protected List<ReadingType> readingType;

    /**
     * Gets the value of the meterReading property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meterReading property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeterReading().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MeterReading }
     * 
     * 
     */
    public List<MeterReading> getMeterReading() {
        if (meterReading == null) {
            meterReading = new ArrayList<MeterReading>();
        }
        return this.meterReading;
    }

    /**
     * Gets the value of the readingType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the readingType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReadingType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReadingType }
     * 
     * 
     */
    public List<ReadingType> getReadingType() {
        if (readingType == null) {
            readingType = new ArrayList<ReadingType>();
        }
        return this.readingType;
    }

}
