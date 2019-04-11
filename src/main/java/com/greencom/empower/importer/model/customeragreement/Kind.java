
package com.greencom.empower.importer.model.customeragreement;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for kind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="kind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="current"/>
 *     &lt;enumeration value="currentAngle"/>
 *     &lt;enumeration value="date"/>
 *     &lt;enumeration value="demand"/>
 *     &lt;enumeration value="energy"/>
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="phaseAngle"/>
 *     &lt;enumeration value="power"/>
 *     &lt;enumeration value="powerFactor"/>
 *     &lt;enumeration value="pressure"/>
 *     &lt;enumeration value="time"/>
 *     &lt;enumeration value="voltage"/>
 *     &lt;enumeration value="voltageAngle"/>
 *     &lt;enumeration value="volume"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "kind")
@XmlEnum
public enum Kind {

    @XmlEnumValue("current")
    CURRENT("current"),
    @XmlEnumValue("currentAngle")
    CURRENT_ANGLE("currentAngle"),
    @XmlEnumValue("date")
    DATE("date"),
    @XmlEnumValue("demand")
    DEMAND("demand"),
    @XmlEnumValue("energy")
    ENERGY("energy"),
    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("phaseAngle")
    PHASE_ANGLE("phaseAngle"),
    @XmlEnumValue("power")
    POWER("power"),
    @XmlEnumValue("powerFactor")
    POWER_FACTOR("powerFactor"),
    @XmlEnumValue("pressure")
    PRESSURE("pressure"),
    @XmlEnumValue("time")
    TIME("time"),
    @XmlEnumValue("voltage")
    VOLTAGE("voltage"),
    @XmlEnumValue("voltageAngle")
    VOLTAGE_ANGLE("voltageAngle"),
    @XmlEnumValue("volume")
    VOLUME("volume");
    private final String value;

    Kind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Kind fromValue(String v) {
        for (Kind c: Kind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
