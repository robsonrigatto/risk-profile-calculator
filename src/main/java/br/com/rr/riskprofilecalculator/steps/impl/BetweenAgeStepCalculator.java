package br.com.rr.riskprofilecalculator.steps.impl;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.steps.StepCalculator;
import org.springframework.stereotype.Component;

@Component
public class BetweenAgeStepCalculator implements StepCalculator {

    @Override
    public ContextDTO applyStep(ContextDTO context) {
        Integer age = context.getRequest().getAge();

        if(age >= 30 && age <= 40) {
            context.getDisability().decrease();
            context.getHome().decrease();
            context.getLife().decrease();
            context.getAuto().decrease();
        }

        return context;
    }
}
