
package com.greencom.empower.importer.model.meterreading;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the meterreading package. 
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

    private final static QName _MeterReadings_QNAME = new QName("http://iec.ch/TC57/2009/MeterReadings#", "MeterReadings");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: meterreading
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Pending }
     * 
     */
    public Pending createPending() {
        return new Pending();
    }

    /**
     * Create an instance of {@link MeterReading }
     * 
     */
    public MeterReading createMeterReading() {
        return new MeterReading();
    }

    /**
     * Create an instance of {@link MeterReading.Readings }
     * 
     */
    public MeterReading.Readings createMeterReadingReadings() {
        return new MeterReading.Readings();
    }

    /**
     * Create an instance of {@link MeterReading.MeterAsset }
     * 
     */
    public MeterReading.MeterAsset createMeterReadingMeterAsset() {
        return new MeterReading.MeterAsset();
    }

    /**
     * Create an instance of {@link MeterReading.IntervalBlocks }
     * 
     */
    public MeterReading.IntervalBlocks createMeterReadingIntervalBlocks() {
        return new MeterReading.IntervalBlocks();
    }

    /**
     * Create an instance of {@link MeterReading.IntervalBlocks.Pending }
     * 
     */
    public MeterReading.IntervalBlocks.Pending createMeterReadingIntervalBlocksPending() {
        return new MeterReading.IntervalBlocks.Pending();
    }

    /**
     * Create an instance of {@link MeterReading.IntervalBlocks.IntervalReadings }
     * 
     */
    public MeterReading.IntervalBlocks.IntervalReadings createMeterReadingIntervalBlocksIntervalReadings() {
        return new MeterReading.IntervalBlocks.IntervalReadings();
    }

    /**
     * Create an instance of {@link MeterReadings }
     * 
     */
    public MeterReadings createMeterReadings() {
        return new MeterReadings();
    }

    /**
     * Create an instance of {@link Status }
     * 
     */
    public Status createStatus() {
        return new Status();
    }

    /**
     * Create an instance of {@link MeterAsset }
     * 
     */
    public MeterAsset createMeterAsset() {
        return new MeterAsset();
    }

    /**
     * Create an instance of {@link ReadingType }
     * 
     */
    public ReadingType createReadingType() {
        return new ReadingType();
    }

    /**
     * Create an instance of {@link EndDeviceEvent }
     * 
     */
    public EndDeviceEvent createEndDeviceEvent() {
        return new EndDeviceEvent();
    }

    /**
     * Create an instance of {@link ReadingQuality }
     * 
     */
    public ReadingQuality createReadingQuality() {
        return new ReadingQuality();
    }

    /**
     * Create an instance of {@link Pending.ReadingType }
     * 
     */
    public Pending.ReadingType createPendingReadingType() {
        return new Pending.ReadingType();
    }

    /**
     * Create an instance of {@link MeterReading.CustomerAgreement }
     * 
     */
    public MeterReading.CustomerAgreement createMeterReadingCustomerAgreement() {
        return new MeterReading.CustomerAgreement();
    }

    /**
     * Create an instance of {@link MeterReading.ServiceDeliveryPoint }
     * 
     */
    public MeterReading.ServiceDeliveryPoint createMeterReadingServiceDeliveryPoint() {
        return new MeterReading.ServiceDeliveryPoint();
    }

    /**
     * Create an instance of {@link MeterReading.Readings.ReadingQualities }
     * 
     */
    public MeterReading.Readings.ReadingQualities createMeterReadingReadingsReadingQualities() {
        return new MeterReading.Readings.ReadingQualities();
    }

    /**
     * Create an instance of {@link MeterReading.Readings.ReadingType }
     * 
     */
    public MeterReading.Readings.ReadingType createMeterReadingReadingsReadingType() {
        return new MeterReading.Readings.ReadingType();
    }

    /**
     * Create an instance of {@link MeterReading.MeterAsset.Status }
     * 
     */
    public MeterReading.MeterAsset.Status createMeterReadingMeterAssetStatus() {
        return new MeterReading.MeterAsset.Status();
    }

    /**
     * Create an instance of {@link MeterReading.IntervalBlocks.ReadingType }
     * 
     */
    public MeterReading.IntervalBlocks.ReadingType createMeterReadingIntervalBlocksReadingType() {
        return new MeterReading.IntervalBlocks.ReadingType();
    }

    /**
     * Create an instance of {@link MeterReading.IntervalBlocks.Pending.ReadingType }
     * 
     */
    public MeterReading.IntervalBlocks.Pending.ReadingType createMeterReadingIntervalBlocksPendingReadingType() {
        return new MeterReading.IntervalBlocks.Pending.ReadingType();
    }

    /**
     * Create an instance of {@link MeterReading.IntervalBlocks.IntervalReadings.ReadingQualities }
     * 
     */
    public MeterReading.IntervalBlocks.IntervalReadings.ReadingQualities createMeterReadingIntervalBlocksIntervalReadingsReadingQualities() {
        return new MeterReading.IntervalBlocks.IntervalReadings.ReadingQualities();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeterReadings }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://iec.ch/TC57/2009/MeterReadings#", name = "MeterReadings")
    public JAXBElement<MeterReadings> createMeterReadings(MeterReadings value) {
        return new JAXBElement<MeterReadings>(_MeterReadings_QNAME, MeterReadings.class, null, value);
    }

}
