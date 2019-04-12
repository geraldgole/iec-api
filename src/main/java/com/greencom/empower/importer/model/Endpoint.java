package com.greencom.empower.importer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Endpoint {

    @JsonIgnore
    private String id;

    private String deviceId;

    private String providerId;

    private Map<String, String> properties;

    private Set<Endpoint> endpoints;

    public Endpoint() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public Set<Endpoint> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(Set<Endpoint> endpoints) {
        this.endpoints = endpoints;
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
                + ", \"deviceId\": \"" + deviceId + "\""
                + ", \"providerId\": \"" + providerId + "\""
                + ", \"properties\": " + properties
                + ", \"endpoints\": " + endpoints
                + "}";
    }
}
