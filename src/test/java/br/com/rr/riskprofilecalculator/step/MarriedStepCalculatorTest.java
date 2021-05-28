package br.com.rr.riskprofilecalculator.step;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.dto.RiskRequestDTO;
import br.com.rr.riskprofilecalculator.enumeration.MaritalStatus;
import br.com.rr.riskprofilecalculator.steps.impl.MarriedStepCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MarriedStepCalculatorTest {

    @Autowired
    private MarriedStepCalculator step;

    @Test
    public void stepTest_single() {
        RiskRequestDTO request = new RiskRequestDTO();
        request.setMaritalStatus(MaritalStatus.SINGLE);
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertEquals(0, context.getLife().getValue());
        assertEquals(0, context.getDisability().getValue());
    }

    @Test
    public void stepTest_married() {
        RiskRequestDTO request = new RiskRequestDTO();
        request.setMaritalStatus(MaritalStatus.MARRIED);
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertEquals(1, context.getLife().getValue());
        assertEquals(-1, context.getDisability().getValue());
    }
}