package com.cdn.pru.service;

import com.cdn.pru.entity.StockAverageInfo;
import com.cdn.pru.repository.StockAverageInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StockAverageCalculatorService {

    private static final Logger LOG = LoggerFactory.getLogger(StockAverageCalculatorService.class);

    private StockAverageInfoRepository stockAverageInfoRepository;

    @Autowired
    public StockAverageCalculatorService(StockAverageInfoRepository pruRepository) {
        this.stockAverageInfoRepository = pruRepository;
    }

    public StockAverageInfo simulate(String instrument, int nbShares, BigDecimal price) {

        LOG.info("Simulate average price for instrument {} given {} new shares at a price of {}", instrument, nbShares, price);

        StockAverageInfo currentPruInfo = stockAverageInfoRepository.getCurrentPru(instrument);
        int totalNbShares = nbShares + currentPruInfo.nbShares();
        BigDecimal currentValo = currentPruInfo.pru().multiply(new BigDecimal(currentPruInfo.nbShares()));
        BigDecimal newPru = currentValo.add(price.multiply(new BigDecimal(nbShares))).divide(new BigDecimal(totalNbShares));

        return new StockAverageInfo(instrument,  totalNbShares, newPru);

    }
}
