package com.greencom.empower.importer.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Device {

    private String id;

    private Map<String, String> properties;

    private Set<Endpoint> endpoints;


    public Device() {
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
                + ", \"properties\": " + properties
                + ", \"endpoints\": " + endpoints
                + "}";
    }
}
