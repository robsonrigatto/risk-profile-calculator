package br.com.rr.riskprofilecalculator.steps.impl;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.dto.RiskRequestDTO;
import br.com.rr.riskprofilecalculator.steps.StepCalculator;
import org.springframework.stereotype.Component;

@Component
public class DependentsStepCalculator implements StepCalculator {

    @Override
    public ContextDTO applyStep(ContextDTO context) {
        RiskRequestDTO request = context.getRequest();
        if(request.getDependents() > 0) {
            context.getDisability().increase();
            context.getLife().increase();
        }
        return context;
    }
}

