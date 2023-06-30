package com.cdn.pru.service;

import com.cdn.pru.entity.PruInfo;
import com.cdn.pru.repository.PruInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PruCalculatorService {

    private PruInfoRepository pruRepository;

    @Autowired
    public PruCalculatorService(PruInfoRepository pruRepository) {
        this.pruRepository = pruRepository;
    }

    public PruInfo simulate(String instrument, int nbShares, BigDecimal price) {
        PruInfo currentPruInfo = pruRepository.getCurrentPru(instrument);
        int totalNbShares = nbShares + currentPruInfo.getNbShares();
        BigDecimal currentValo = currentPruInfo.getPru().multiply(new BigDecimal(currentPruInfo.getNbShares()));
        BigDecimal newPru = currentValo.add(price.multiply(new BigDecimal(nbShares))).divide(new BigDecimal(totalNbShares));

        return new PruInfo(instrument,  totalNbShares, newPru);

    }
}
