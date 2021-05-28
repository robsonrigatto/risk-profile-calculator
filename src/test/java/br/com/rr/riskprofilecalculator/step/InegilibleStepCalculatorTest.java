package br.com.rr.riskprofilecalculator.step;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.dto.HouseDTO;
import br.com.rr.riskprofilecalculator.dto.RiskRequestDTO;
import br.com.rr.riskprofilecalculator.dto.VehicleDTO;
import br.com.rr.riskprofilecalculator.enumeration.InsurancePlan;
import br.com.rr.riskprofilecalculator.steps.impl.InegilibleStepCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class InegilibleStepCalculatorTest {

    @Autowired
    private InegilibleStepCalculator step;

    @Test
    public void stepTest_noneAll() {
        RiskRequestDTO request = new RiskRequestDTO();
        request.setIncome(0);
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertEquals(InsurancePlan.INELIGIBLE, context.getResponse().getDisability());
        assertEquals(InsurancePlan.INELIGIBLE, context.getResponse().getAuto());
        assertEquals(InsurancePlan.INELIGIBLE, context.getResponse().getHome());
    }

    @Test
    public void stepTest_withIncome() {
        RiskRequestDTO request = new RiskRequestDTO();
        request.setIncome(100);
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertNull(context.getResponse().getDisability());
        assertEquals(InsurancePlan.INELIGIBLE, context.getResponse().getAuto());
        assertEquals(InsurancePlan.INELIGIBLE, context.getResponse().getHome());
    }

    @Test
    public void stepTest_withVehicle() {
        RiskRequestDTO request = new RiskRequestDTO();
        request.setIncome(0);
        request.setVehicle(new VehicleDTO());
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertEquals(InsurancePlan.INELIGIBLE, context.getResponse().getDisability());
        assertNull(context.getResponse().getAuto());
        assertEquals(InsurancePlan.INELIGIBLE, context.getResponse().getHome());
    }

    @Test
    public void stepTest_withHouse() {
        RiskRequestDTO request = new RiskRequestDTO();
        request.setIncome(0);
        request.setHouse(new HouseDTO());
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertEquals(InsurancePlan.INELIGIBLE, context.getResponse().getDisability());
        assertEquals(InsurancePlan.INELIGIBLE, context.getResponse().getAuto());
        assertNull(context.getResponse().getHome());
    }
}