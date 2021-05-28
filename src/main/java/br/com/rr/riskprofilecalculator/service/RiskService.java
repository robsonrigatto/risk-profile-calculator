package br.com.rr.riskprofilecalculator.service;

import br.com.rr.riskprofilecalculator.dto.RiskRequestDTO;
import br.com.rr.riskprofilecalculator.dto.ScoreDTO;

public interface RiskService {

    ScoreDTO calculate(RiskRequestDTO request);

}