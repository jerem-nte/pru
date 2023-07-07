package com.cdn.pru.controller;

import com.cdn.pru.entity.StockAverageInfo;
import com.cdn.pru.service.StockAverageCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class StockAverageController {


    private StockAverageCalculatorService stockAverageCalculatorService;

    @Autowired
    public StockAverageController(StockAverageCalculatorService stockAverageCalculatorService) {
        this.stockAverageCalculatorService = stockAverageCalculatorService;
    }

    @GetMapping("/simulate")
    public StockAverageInfo getPrud(@RequestParam String instrument, @RequestParam int nbShares, @RequestParam BigDecimal price) {

        return stockAverageCalculatorService.simulate(instrument, nbShares, price);
    }


}
