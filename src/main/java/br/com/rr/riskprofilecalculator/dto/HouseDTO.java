package br.com.rr.riskprofilecalculator.dto;

import br.com.rr.riskprofilecalculator.enumeration.OwnershipStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HouseDTO {

    @JsonProperty("ownership_status")
    private OwnershipStatus ownershipStatus;

    public OwnershipStatus getOwnershipStatus() {
        return ownershipStatus;
    }

    public void setOwnershipStatus(OwnershipStatus ownershipStatus) {
        this.ownershipStatus = ownershipStatus;
    }
}
