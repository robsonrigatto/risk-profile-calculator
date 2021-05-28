package br.com.rr.riskprofilecalculator.step;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.dto.RiskRequestDTO;
import br.com.rr.riskprofilecalculator.steps.impl.BelowAgeStepCalculator;
import br.com.rr.riskprofilecalculator.steps.impl.BetweenAgeStepCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BetweenAgeStepCalculatorTest {

    @Autowired
    private BetweenAgeStepCalculator step;

    @Test
    public void stepTest_between() {
        RiskRequestDTO request = new RiskRequestDTO();
        request.setAge(35);
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertEquals(-1, context.getDisability().getValue());
    }

    @Test
    public void stepTest_above() {
        RiskRequestDTO request = new RiskRequestDTO();
        request.setAge(61);
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertEquals(0, context.getDisability().getValue());
    }
}
