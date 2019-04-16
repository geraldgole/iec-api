package com.greencom.empower.importer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Endpoint extends AbstractEntity {

    @JsonIgnore
    private String id;
    private String deviceId;
    private String providerId;
    private Map<String, String> properties;
    private Set<Endpoint> endpoints;


    public void addProperty(final String key, final String value) {
        if (properties == null) {
            properties = new HashMap<>();
        }
        properties.put(key, value);
    }


}
