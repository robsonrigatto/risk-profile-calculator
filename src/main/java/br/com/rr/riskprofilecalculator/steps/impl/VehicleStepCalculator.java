package br.com.rr.riskprofilecalculator.steps.impl;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.dto.VehicleDTO;
import br.com.rr.riskprofilecalculator.steps.StepCalculator;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class VehicleStepCalculator implements StepCalculator {

    @Override
    public ContextDTO applyStep(ContextDTO context) {
        VehicleDTO vehicle = context.getRequest().getVehicle();

        if(vehicle == null) {
            return context;
        }

        int currentYear = LocalDate.now().getYear();
        int age = vehicle.getYear();
        int difference = currentYear - age;

        if(difference <= 5) {
            context.getAuto().increase();
        }

        return context;
    }
}
