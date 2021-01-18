package com.southsystem.calc.domain;

import javax.persistence.*;

@Entity
public class Calc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double firstValue;
    private String operator;
    private Double secondValue;
    private Double total;

    public Calc() {
    }

    public Calc(Double firstValue, String operator, Double secondValue, Double total) {
        this.firstValue = firstValue;
        this.operator = operator;
        this.secondValue = secondValue;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public Double getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(Double firstValue) {
        this.firstValue = firstValue;
    }

    public Double getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(Double secondValue) {
        this.secondValue = secondValue;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
