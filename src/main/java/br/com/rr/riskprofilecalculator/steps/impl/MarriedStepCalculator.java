package br.com.rr.riskprofilecalculator.steps.impl;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.dto.RiskRequestDTO;
import br.com.rr.riskprofilecalculator.enumeration.MaritalStatus;
import br.com.rr.riskprofilecalculator.steps.StepCalculator;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MarriedStepCalculator implements StepCalculator {

    @Override
    public ContextDTO applyStep(ContextDTO context) {
        RiskRequestDTO request = context.getRequest();

        if(Objects.equals(MaritalStatus.MARRIED, request.getMaritalStatus())) {
            context.getLife().increase();
            context.getDisability().decrease();
        }

        return context;
    }
}
