package com.southsystem.calc.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalcService {

    @Autowired
    private CalcRepository rep;

    public Iterable<Calc> getHistory() {
        return rep.findAll();
    }

    public Optional<Calc> getHistoryById(Long id) {
        return rep.findById(id);
    }

    public List<Calc> getHistoryByOperator(String operator) {
        return rep.findByOperation(operator);
    }

    public Calc sum(Calc calc) {
        calc.setTotal( calc.getFirstValue() + calc.getSecondValue());
        calc.setOperator("+");
        return rep.save(calc);
    }

    public Calc sub(Calc calc) {
        calc.setTotal(calc.getFirstValue() - calc.getSecondValue());
        calc.setOperator("-");
        return rep.save(calc);
    }

    public Calc multi(Calc calc) {
        calc.setTotal(calc.getFirstValue() * calc.getSecondValue());
        calc.setOperator("*");
        return rep.save(calc);
    }

    public Calc div(Calc calc) {
        calc.setTotal(calc.getFirstValue() / calc.getSecondValue());
        calc.setOperator("/");
        return rep.save(calc);
    }

    public Calc pot(Calc calc) {
        calc.setTotal(Math.pow(calc.getFirstValue(), calc.getSecondValue()));
        calc.setOperator("^");
        return rep.save(calc);
    }
}