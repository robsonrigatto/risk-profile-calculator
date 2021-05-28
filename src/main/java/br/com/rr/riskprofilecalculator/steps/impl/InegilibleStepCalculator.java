package br.com.rr.riskprofilecalculator.steps.impl;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.dto.RiskRequestDTO;
import br.com.rr.riskprofilecalculator.enumeration.InsurancePlan;
import br.com.rr.riskprofilecalculator.steps.StepCalculator;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class InegilibleStepCalculator implements StepCalculator {

    @Override
    public ContextDTO applyStep(ContextDTO context) {
        RiskRequestDTO request = context.getRequest();

        boolean noIncome = Objects.equals(request.getIncome(), 0);
        if(noIncome) {
            context.getResponse().setDisability(InsurancePlan.INELIGIBLE);
        }

        boolean noVehicle = request.getVehicle() == null;
        if(noVehicle) {
            context.getResponse().setAuto(InsurancePlan.INELIGIBLE);
        }

        boolean noHouses = request.getHouse() == null;
        if(noHouses) {
            context.getResponse().setHome(InsurancePlan.INELIGIBLE);
        }

        return context;
    }
}
