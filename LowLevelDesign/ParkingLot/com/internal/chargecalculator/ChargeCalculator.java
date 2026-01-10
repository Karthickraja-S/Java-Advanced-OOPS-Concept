package com.internal.chargecalculator;

import com.models.Ticket;

public interface ChargeCalculator {
    public int getFare(Ticket ticket);
}
