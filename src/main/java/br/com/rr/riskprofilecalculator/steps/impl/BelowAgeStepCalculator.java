package br.com.rr.riskprofilecalculator.steps.impl;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.steps.StepCalculator;
import org.springframework.stereotype.Component;

@Component
public class BelowAgeStepCalculator implements StepCalculator {

    @Override
    public ContextDTO applyStep(ContextDTO context) {
        Integer age = context.getRequest().getAge();

        if(age < 30) {
            context.getDisability().decrease(2);
            context.getHome().decrease(2);
            context.getLife().decrease(2);
            context.getAuto().decrease(2);
        }

        return context;
    }
}
