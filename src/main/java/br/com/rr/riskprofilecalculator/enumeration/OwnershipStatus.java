package br.com.rr.riskprofilecalculator.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OwnershipStatus {

    OWNED, MORTGAGED;

    @JsonCreator
    public static OwnershipStatus fromString(String key) {
        return key == null ? null : OwnershipStatus.valueOf(key.toUpperCase());
    }

    @JsonValue
    public String getKey() {
        return this.name().toLowerCase();
    }
}
