package br.com.rr.riskprofilecalculator.step;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.dto.RiskRequestDTO;
import br.com.rr.riskprofilecalculator.dto.VehicleDTO;
import br.com.rr.riskprofilecalculator.steps.impl.VehicleStepCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VehicleStepCalculatorTest {

    @Autowired
    private VehicleStepCalculator step;

    @Test
    public void stepTest_noVehicle() {
        RiskRequestDTO request = new RiskRequestDTO();
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertEquals(0, context.getAuto().getValue());
    }

    @Test
    public void stepTest_oldVehicle() {
        RiskRequestDTO request = new RiskRequestDTO();
        VehicleDTO vehicle = new VehicleDTO();
        vehicle.setYear(2000);
        request.setVehicle(vehicle);
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertEquals(0, context.getAuto().getValue());
    }

    @Test
    public void stepTest_newVehicle() {
        RiskRequestDTO request = new RiskRequestDTO();
        VehicleDTO vehicle = new VehicleDTO();
        vehicle.setYear(2020);
        request.setVehicle(vehicle);
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertEquals(1, context.getAuto().getValue());
    }
}
