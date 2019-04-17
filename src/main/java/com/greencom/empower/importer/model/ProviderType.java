package com.greencom.empower.importer.model;

import lombok.Getter;

@Getter
public enum ProviderType {

    CUSTOMER_AGREEMENT("customerAgreement"),
    METERING("metering");

    private String type;

    private ProviderType(String type) {
        this.type = type;
    }
}
