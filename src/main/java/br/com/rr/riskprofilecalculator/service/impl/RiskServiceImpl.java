package br.com.rr.riskprofilecalculator.service.impl;

import br.com.rr.riskprofilecalculator.dto.ContextDTO;
import br.com.rr.riskprofilecalculator.dto.RiskRequestDTO;
import br.com.rr.riskprofilecalculator.dto.ScoreDTO;
import br.com.rr.riskprofilecalculator.mapper.RiskMapper;
import br.com.rr.riskprofilecalculator.service.RiskService;
import br.com.rr.riskprofilecalculator.steps.StepCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskServiceImpl implements RiskService {

    @Autowired
    private List<StepCalculator> steps;

    @Autowired
    private RiskMapper riskMapper;

    @Override
    public ScoreDTO calculate(RiskRequestDTO request) {
        int baseScore = request.getRiskQuestions().stream()
                .mapToInt(Integer::intValue)
                .sum();
        ContextDTO context = new ContextDTO(request, baseScore);

        for(StepCalculator step : steps) {
            context = step.applyStep(context);
        }

        return riskMapper.toScore(context);
    }
}
