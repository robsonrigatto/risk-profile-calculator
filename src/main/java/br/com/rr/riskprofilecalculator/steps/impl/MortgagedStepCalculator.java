package br.com.rr.riskprofilecalculator.steps.impl;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.dto.HouseDTO;
import br.com.rr.riskprofilecalculator.dto.RiskRequestDTO;
import br.com.rr.riskprofilecalculator.enumeration.OwnershipStatus;
import br.com.rr.riskprofilecalculator.steps.StepCalculator;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MortgagedStepCalculator implements StepCalculator {

    @Override
    public ContextDTO applyStep(ContextDTO context) {
        RiskRequestDTO request = context.getRequest();
        HouseDTO house = request.getHouse();

        if(house != null && Objects.equals(OwnershipStatus.MORTGAGED, house.getOwnershipStatus())) {
            context.getHome().increase();
            context.getDisability().increase();
        }

        return context;
    }
}
