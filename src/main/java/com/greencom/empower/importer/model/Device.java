package com.greencom.empower.importer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Device extends AbstractEntity {

    private String id;
    private Map<String, String> properties;
    private Set<Endpoint> endpoints;
    private String providerId;

    public void addProperty(String key, String value) {
        if (properties == null) {
            properties = new HashMap<>();
        }
        properties.put(key, value);
    }
}
