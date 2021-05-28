package br.com.rr.riskprofilecalculator.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MaritalStatus {

    MARRIED, SINGLE;

    @JsonCreator
    public static MaritalStatus fromString(String key) {
        return key == null ? null : MaritalStatus.valueOf(key.toUpperCase());
    }

    @JsonValue
    public String getKey() {
        return this.name().toLowerCase();
    }
}
