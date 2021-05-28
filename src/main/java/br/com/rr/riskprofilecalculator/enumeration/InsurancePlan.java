package br.com.rr.riskprofilecalculator.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InsurancePlan {

    INELIGIBLE, ECONOMIC, REGULAR, RESPONSIBLE;

    @JsonCreator
    public static InsurancePlan fromString(String key) {
        return key == null ? null : InsurancePlan.valueOf(key.toUpperCase());
    }

    @JsonValue
    public String getKey() {
        return this.name().toLowerCase();
    }
}
