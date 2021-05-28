package br.com.rr.riskprofilecalculator.mapper;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.dto.ScoreDTO;
import br.com.rr.riskprofilecalculator.enumeration.InsurancePlan;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RiskMapper {

    public ScoreDTO toScore(ContextDTO context) {
        ScoreDTO response = context.getResponse();
        response.setAuto(calculate(response.getAuto(), context.getAuto().getValue()));
        response.setHome(calculate(response.getHome(), context.getHome().getValue()));
        response.setDisability(calculate(response.getDisability(), context.getDisability().getValue()));
        response.setLife(calculate(response.getLife(), context.getLife().getValue()));

        return response;
    }

    private InsurancePlan calculate(InsurancePlan existingPlan, Integer calculatedValue) {

        if(Objects.equals(InsurancePlan.INELIGIBLE, existingPlan)) {
            return existingPlan;
        }

        if(calculatedValue <= 0) {
            return InsurancePlan.ECONOMIC;
        }

        if(calculatedValue >= 3) {
            return InsurancePlan.RESPONSIBLE;
        }

        return InsurancePlan.REGULAR;
    }
}
