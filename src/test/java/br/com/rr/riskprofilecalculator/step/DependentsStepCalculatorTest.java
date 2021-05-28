package br.com.rr.riskprofilecalculator.step;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.dto.RiskRequestDTO;
import br.com.rr.riskprofilecalculator.steps.impl.BetweenAgeStepCalculator;
import br.com.rr.riskprofilecalculator.steps.impl.DependentsStepCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DependentsStepCalculatorTest {

    @Autowired
    private DependentsStepCalculator step;

    @Test
    public void stepTest_noDependents() {
        RiskRequestDTO request = new RiskRequestDTO();
        request.setDependents(0);
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertEquals(0, context.getLife().getValue());
    }

    @Test
    public void stepTest_withDependencies() {
        RiskRequestDTO request = new RiskRequestDTO();
        request.setDependents(2);
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertEquals(1, context.getLife().getValue());
    }
}
