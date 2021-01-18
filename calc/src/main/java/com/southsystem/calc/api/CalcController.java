package com.southsystem.calc.api;

import com.southsystem.calc.domain.Calc;
import com.southsystem.calc.domain.CalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/calc")
public class CalcController {

    @Autowired
    private CalcService service;

    @GetMapping("/history")
    public ResponseEntity<Iterable<Calc>> get() {
        return ResponseEntity.ok(service.getHistory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Calc> getById(@PathVariable("id") Long id) {
        Optional<Calc> history = service.getHistoryById(id);

        return history.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/operator/{operator}")
    public ResponseEntity getHistoryByOperator(@PathVariable ("operator") String operator) {
        List<Calc> historyCalc = service.getHistoryByOperator(operator);

        return historyCalc.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(historyCalc);
    }

    @GetMapping("/sum")
    public String soma(@RequestBody Calc calc) {
        Calc soma = service.sum(calc);

        return "Add Id:  " + soma.getId() + " | " + soma.getFirstValue() + " + " + soma.getSecondValue() +
                " = " + soma.getTotal();
    }

    @GetMapping("/sub")
    public String sub(@RequestBody Calc calc) {
        Calc sub = service.sub(calc);
        return "Sub Id:  " + sub.getId() + " | " + sub.getFirstValue() + " - " + sub.getSecondValue() +
                " = " + sub.getTotal();
    }

    @GetMapping("/multiply")
    public String multi(@RequestBody Calc calc) {
        Calc multi = service.multi(calc);
        return "Multiply Id:  " + multi.getId() + " | " + multi.getFirstValue() + " * " + multi.getSecondValue() +
                " = " + multi.getTotal();
    }

    @GetMapping("/division")
    public String division(@RequestBody Calc calc) {
        Calc div = service.div(calc);
        return "Divisão Id:  " + div.getId() + " | " + div.getFirstValue() + " / " + div.getSecondValue() +
                " = " + div.getTotal();
    }

    @GetMapping("/pow")
    public String div(@RequestBody Calc calc) {
        Calc pot = service.pot(calc);
        return "Pow Id:  " + pot.getId() + " | " + pot.getFirstValue() + " ^ " + pot.getSecondValue() +
                " = " + pot.getTotal();
    }
}

