package com.cdn.pru.repository;

import com.cdn.pru.entity.PruInfo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PruInfoRepository {


    public PruInfo getCurrentPru(String instrument) {
        return new PruInfo(instrument, 15, new BigDecimal("105.49"));
    }

}
