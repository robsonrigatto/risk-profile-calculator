package br.com.rr.riskprofilecalculator.step;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.dto.RiskRequestDTO;
import br.com.rr.riskprofilecalculator.enumeration.InsurancePlan;
import br.com.rr.riskprofilecalculator.steps.impl.AboveAgeStepCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class AboveAgeStepCalculatorTest {

    @Autowired
    private AboveAgeStepCalculator step;

    @Test
    public void stepTest_below() {
        RiskRequestDTO request = new RiskRequestDTO();
        request.setAge(50);
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertNull(context.getResponse().getDisability());
    }

    @Test
    public void stepTest_above() {
        RiskRequestDTO request = new RiskRequestDTO();
        request.setAge(61);
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertEquals(InsurancePlan.INELIGIBLE, context.getResponse().getDisability());
    }
}
