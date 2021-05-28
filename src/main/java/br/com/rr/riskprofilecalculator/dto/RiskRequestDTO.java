package br.com.rr.riskprofilecalculator.dto;

import br.com.rr.riskprofilecalculator.enumeration.MaritalStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RiskRequestDTO {

    private Integer age;
    private Integer dependents;
    private HouseDTO house;
    private Integer income;

    @JsonProperty("marital_status")
    private MaritalStatus maritalStatus;

    @JsonProperty("risk_questions")
    private List<Integer> riskQuestions;

    private VehicleDTO vehicle;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDependents() {
        return dependents;
    }

    public void setDependents(Integer dependents) {
        this.dependents = dependents;
    }

    public HouseDTO getHouse() {
        return house;
    }

    public void setHouse(HouseDTO house) {
        this.house = house;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public List<Integer> getRiskQuestions() {
        return riskQuestions;
    }

    public void setRiskQuestions(List<Integer> riskQuestions) {
        this.riskQuestions = riskQuestions;
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }
}
