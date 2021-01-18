package com.southsystem.calc.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CalcRepository extends CrudRepository<Calc, Long> {
    List<Calc> findByOperation(String operator);
}
