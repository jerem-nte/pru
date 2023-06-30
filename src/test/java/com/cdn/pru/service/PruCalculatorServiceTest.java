package com.cdn.pru.service;

import com.cdn.pru.entity.PruInfo;
import com.cdn.pru.repository.PruInfoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

public class PruCalculatorServiceTest {

    @Test
    public void testSimulate() {
        PruInfoRepository pruInfoRepository = Mockito.mock(PruInfoRepository.class);
        Mockito.when(pruInfoRepository.getCurrentPru("IBM")).thenReturn(new PruInfo("IBM", 15, new BigDecimal("105.49")));

        PruCalculatorService pruCalculatorService = new PruCalculatorService(pruInfoRepository);

        PruInfo expected = new PruInfo("IBM", 18, new BigDecimal("106.035"));

        Assertions.assertEquals(expected, pruCalculatorService.simulate("IBM", 3, new BigDecimal("108.76")));
    }

}