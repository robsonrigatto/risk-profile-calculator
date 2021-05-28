package br.com.rr.riskprofilecalculator.step;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.dto.RiskRequestDTO;
import br.com.rr.riskprofilecalculator.steps.impl.DependentsStepCalculator;
import br.com.rr.riskprofilecalculator.steps.impl.IncomeStepCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class IncomeStepCalculatorTest {

    @Autowired
    private IncomeStepCalculator step;

    @Test
    public void stepTest_below() {
        RiskRequestDTO request = new RiskRequestDTO();
        request.setIncome(100000);
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertEquals(0, context.getLife().getValue());
    }

    @Test
    public void stepTest_limit() {
        RiskRequestDTO request = new RiskRequestDTO();
        request.setIncome(200000);
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertEquals(0, context.getLife().getValue());
    }

    @Test
    public void stepTest_above() {
        RiskRequestDTO request = new RiskRequestDTO();
        request.setIncome(200001);
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertEquals(-1, context.getLife().getValue());
    }
}