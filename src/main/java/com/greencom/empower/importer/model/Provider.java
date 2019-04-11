package com.greencom.empower.importer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greencom.empower.importer.model.customeragreement.CustomerAgreement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Provider {

    @JsonIgnore
    private String id;

    private Map<String, String> properties;

    private Set<Device> devices = new HashSet<>();

    public Provider() {
    }

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
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public Set<Device> getDevices() {
        return devices;
    }

    public void setDevices(Set<Device> devices) {
        this.devices = devices;
    }

    public void addProperty(String key, String value) {

        if (properties == null)
            properties = new HashMap<>();

        properties.put(key, value);
    }

    @Override
    public String toString() {
        return "{"
                + "\"id\": \"" + id + "\""
                + ", \"properties\": " + properties
                + ", \"devices\": " + devices
                + "}";
    }
}
