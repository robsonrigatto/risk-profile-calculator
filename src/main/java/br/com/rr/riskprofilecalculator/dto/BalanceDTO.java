package br.com.rr.riskprofilecalculator.dto;

public class BalanceDTO {

    private Integer value;

    public BalanceDTO() {
        this(0);
    }

    public BalanceDTO(Integer value) {
        this.value = value;
    }

    public BalanceDTO decrease() {
        return decrease(1);
    }

    public BalanceDTO decrease(Integer delta) {
        this.value = this.value - delta;
        return this;
    }

    public BalanceDTO increase() {
        return increase(1);
    }

    public BalanceDTO increase(Integer delta) {
        this.value = this.value + delta;
        return this;
    }

    public Integer getValue() {
        return value;
    }
}
