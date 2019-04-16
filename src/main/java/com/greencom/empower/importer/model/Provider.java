package com.greencom.empower.importer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;
import com.greencom.empower.importer.model.customeragreement.UsagePoint;
import com.greencom.empower.importer.model.customeragreement.UsagePoints;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Provider extends AbstractEntity {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String id;
    private Map<String, String> properties = new HashMap<>();
    private Set<Device> devices = new HashSet<>();


    public Provider(CustomerAgreement customerAgreement) {

        addProperty("provider.type", "customerAgreement");
        addProperty("user", "empower");

        addProperty("mrid", customerAgreement.getMRID());
        addProperty("name", customerAgreement.getName());
        addProperty("aliasName", customerAgreement.getAliasName());
        addProperty("title", customerAgreement.getTitle());
        addProperty("subject", customerAgreement.getSubject());

        addProperty("docStatus.dateTime", customerAgreement.getDocStatus().getDateTime().toString());
        addProperty("docStatus.value", customerAgreement.getDocStatus().getValue());
        addProperty("docStatus.reason", customerAgreement.getDocStatus().getReason());

        addProperty("service.id", customerAgreement.getServiceCategory().getMRID());
        addProperty("service.name", customerAgreement.getServiceCategory().getName());

        addProperty("validityInterval.start", customerAgreement.getValidityInterval().getStart().toString());
        addProperty("validityInterval.end", customerAgreement.getValidityInterval().getEnd().toString());

        addProperty("customer.id", customerAgreement.getCustomer().getMRID());
        addProperty("customer.name", customerAgreement.getCustomer().getName());
        addProperty("customer.status.dateTime", customerAgreement.getCustomer().getStatus().getDateTime().toString());
        addProperty("customer.status.value", customerAgreement.getCustomer().getStatus().getValue());

        addProperty("customerAccount.id", customerAgreement.getCustomerAccount().getMRID());

        UsagePoints usagePoints = customerAgreement.getUsagePoints();
        if (usagePoints != null) {
            for (UsagePoint usagePoint : usagePoints.getUsagePoint()) {
                Device device = new Device();
                device.setId(usagePoint.getMRID());
                device.addProperty("usagePoint.id", usagePoint.getMRID());
                device.addProperty("usagePoint.name", usagePoint.getName());
                devices.add(device);
            }
        }
    }

    public void addProperty(String key, String value) {
        if (properties == null) {
            properties = new HashMap<>();
        }
        properties.put(key, value);
    }

    public String getProperty(String key) {
        return properties.get(key);
    }
}
