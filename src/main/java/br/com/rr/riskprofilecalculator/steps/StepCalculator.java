package br.com.rr.riskprofilecalculator.steps;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.dto.RiskRequestDTO;
import org.springframework.stereotype.Component;

public interface StepCalculator {

    ContextDTO applyStep(ContextDTO context);
}
