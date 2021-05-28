package br.com.rr.riskprofilecalculator.step;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.dto.HouseDTO;
import br.com.rr.riskprofilecalculator.dto.RiskRequestDTO;
import br.com.rr.riskprofilecalculator.enumeration.OwnershipStatus;
import br.com.rr.riskprofilecalculator.steps.impl.MortgagedStepCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MortgagedStepCalculatorTest {

    @Autowired
    private MortgagedStepCalculator step;

    @Test
    public void stepTest_noneHouse() {
        RiskRequestDTO request = new RiskRequestDTO();
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertEquals(0, context.getHome().getValue());
    }

    @Test
    public void stepTest_ownedHouse() {
        RiskRequestDTO request = new RiskRequestDTO();
        HouseDTO house = new HouseDTO();
        house.setOwnershipStatus(OwnershipStatus.OWNED);
        request.setHouse(house);
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertEquals(0, context.getHome().getValue());
    }

    @Test
    public void stepTest_mortgaged() {
        RiskRequestDTO request = new RiskRequestDTO();
        HouseDTO house = new HouseDTO();
        house.setOwnershipStatus(OwnershipStatus.MORTGAGED);
        request.setHouse(house);
        ContextDTO context = new ContextDTO(request, 0);
        context = step.applyStep(context);

        assertEquals(1, context.getHome().getValue());
        assertEquals(1, context.getDisability().getValue());
    }
}