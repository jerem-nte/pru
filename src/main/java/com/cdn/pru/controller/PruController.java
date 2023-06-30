package com.cdn.pru.controller;

import com.cdn.pru.entity.PruInfo;
import com.cdn.pru.service.PruCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class PruController {

    @Autowired
    private PruCalculatorService pruCalculatorService;

    @GetMapping("/simulate")
    public PruInfo getPrud(@RequestParam String instrument, @RequestParam int nbShares, @RequestParam BigDecimal price) {

        return pruCalculatorService.simulate(instrument, nbShares, price);
    }


}
