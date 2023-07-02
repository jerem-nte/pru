package com.cdn.pru.service;

import com.cdn.pru.entity.StockAverageInfo;
import com.cdn.pru.repository.StockAverageInfoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

class StockAverageCalculatorServiceTest {

    @Test
    void testSimulate() {
        StockAverageInfoRepository pruInfoRepository = Mockito.mock(StockAverageInfoRepository.class);
        Mockito.when(pruInfoRepository.getCurrentPru("IBM")).thenReturn(new StockAverageInfo("IBM", 15, new BigDecimal("105.49")));

        StockAverageCalculatorService pruCalculatorService = new StockAverageCalculatorService(pruInfoRepository);

        StockAverageInfo expected = new StockAverageInfo("IBM", 18, new BigDecimal("106.035"));

        Assertions.assertEquals(expected, pruCalculatorService.simulate("IBM", 3, new BigDecimal("108.76")));
    }

}