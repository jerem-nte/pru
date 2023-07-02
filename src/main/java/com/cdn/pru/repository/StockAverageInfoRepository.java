package com.cdn.pru.repository;

import com.cdn.pru.entity.StockAverageInfo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StockAverageInfoRepository {


    public StockAverageInfo getCurrentPru(String instrument) {
        return new StockAverageInfo(instrument, 15, new BigDecimal("105.49"));
    }

}
