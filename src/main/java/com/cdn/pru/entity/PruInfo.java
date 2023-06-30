package com.cdn.pru.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class PruInfo {

    private String instrument;
    private int nbShares;
    private BigDecimal pru;

    public PruInfo(String instrument, int nbShares, BigDecimal pru) {
        this.instrument = instrument;
        this.nbShares = nbShares;
        this.pru = pru;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public int getNbShares() {
        return nbShares;
    }

    public void setNbShares(int nbShares) {
        this.nbShares = nbShares;
    }

    public BigDecimal getPru() {
        return pru;
    }

    public void setPru(BigDecimal pru) {
        this.pru = pru;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PruInfo pruInfo = (PruInfo) o;
        return nbShares == pruInfo.nbShares && Objects.equals(instrument, pruInfo.instrument) && Objects.equals(pru, pruInfo.pru);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instrument, nbShares, pru);
    }
}
