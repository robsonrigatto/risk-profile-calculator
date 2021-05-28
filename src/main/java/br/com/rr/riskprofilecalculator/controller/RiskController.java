package br.com.rr.riskprofilecalculator.controller;

import br.com.rr.riskprofilecalculator.dto.RiskRequestDTO;
import br.com.rr.riskprofilecalculator.dto.ScoreDTO;
import br.com.rr.riskprofilecalculator.service.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiskController {

    @Autowired
    private RiskService riskService;

    @PostMapping("/risk/calculate")
    public ResponseEntity<ScoreDTO> calculate(@RequestBody RiskRequestDTO request) {
        ScoreDTO score = riskService.calculate(request);
        return ResponseEntity.ok(score);
    }
}
