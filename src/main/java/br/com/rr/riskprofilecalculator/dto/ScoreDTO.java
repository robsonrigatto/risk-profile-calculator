package br.com.rr.riskprofilecalculator.dto;

import br.com.rr.riskprofilecalculator.enumeration.InsurancePlan;

public class ScoreDTO {

    private InsurancePlan auto;
    private InsurancePlan disability;
    private InsurancePlan home;
    private InsurancePlan life;

    public InsurancePlan getAuto() {
        return auto;
    }

    public void setAuto(InsurancePlan auto) {
        this.auto = auto;
    }

    public InsurancePlan getDisability() {
        return disability;
    }

    public void setDisability(InsurancePlan disability) {
        this.disability = disability;
    }

    public InsurancePlan getHome() {
        return home;
    }

    public void setHome(InsurancePlan home) {
        this.home = home;
    }

    public InsurancePlan getLife() {
        return life;
    }

    public void setLife(InsurancePlan life) {
        this.life = life;
    }
}
