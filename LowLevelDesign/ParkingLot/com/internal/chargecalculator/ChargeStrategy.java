package com.internal.chargecalculator;

import com.models.Ticket;

public class ChargeStrategy {
    private final ChargeCalculator chargeCalculator;
    public ChargeStrategy(ChargeCalculator chargeCalculator) {
        this.chargeCalculator = chargeCalculator;
    }
    public int getFare(Ticket ticket) {
        return chargeCalculator.getFare(ticket);
    }
}
