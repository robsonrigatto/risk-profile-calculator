package br.com.rr.riskprofilecalculator.steps.impl;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.dto.ScoreDTO;
import br.com.rr.riskprofilecalculator.enumeration.InsurancePlan;
import br.com.rr.riskprofilecalculator.steps.StepCalculator;
import org.springframework.stereotype.Component;

@Component
public class AboveAgeStepCalculator implements StepCalculator {

    @Override
    public ContextDTO applyStep(ContextDTO context) {
        Integer age = context.getRequest().getAge();

        if(age > 60) {
            ScoreDTO response = context.getResponse();
            response.setDisability(InsurancePlan.INELIGIBLE);
            response.setLife(InsurancePlan.INELIGIBLE);
        }

        return context;
    }
}
