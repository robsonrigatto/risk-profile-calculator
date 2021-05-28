package br.com.rr.riskprofilecalculator.dto;

public class ContextDTO {

    private RiskRequestDTO request;
    private ScoreDTO response;
    private BalanceDTO auto;
    private BalanceDTO disability;
    private BalanceDTO home;
    private BalanceDTO life;

    public ContextDTO(RiskRequestDTO request, Integer baseScore) {
        this.request = request;
        this.response = new ScoreDTO();
        this.auto = new BalanceDTO(baseScore);
        this.disability = new BalanceDTO(baseScore);
        this.home = new BalanceDTO(baseScore);
        this.life = new BalanceDTO(baseScore);
    }

    public RiskRequestDTO getRequest() {
        return request;
    }

    public ScoreDTO getResponse() {
        return response;
    }

    public void setResponse(ScoreDTO response) {
        this.response = response;
    }

    public BalanceDTO getAuto() {
        return auto;
    }

    public BalanceDTO getDisability() {
        return disability;
    }

    public BalanceDTO getHome() {
        return home;
    }

    public BalanceDTO getLife() {
        return life;
    }
}
