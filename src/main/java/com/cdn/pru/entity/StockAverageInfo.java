package com.cdn.pru.entity;

import java.math.BigDecimal;

public record StockAverageInfo (String instrument, int nbShares, BigDecimal pru) {

}
