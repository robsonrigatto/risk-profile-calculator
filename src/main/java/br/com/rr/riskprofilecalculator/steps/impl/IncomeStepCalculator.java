package br.com.rr.riskprofilecalculator.steps.impl;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.dto.RiskRequestDTO;
import br.com.rr.riskprofilecalculator.steps.StepCalculator;
import org.springframework.stereotype.Component;

@Component
public class IncomeStepCalculator implements StepCalculator {

    @Override
    public ContextDTO applyStep(ContextDTO context) {
        RiskRequestDTO request = context.getRequest();

        Integer income = request.getIncome();

        if(income > 200000) {
            context.getDisability().decrease();
            context.getHome().decrease();
            context.getLife().decrease();
            context.getAuto().decrease();
        }

        return context;
    }
}
