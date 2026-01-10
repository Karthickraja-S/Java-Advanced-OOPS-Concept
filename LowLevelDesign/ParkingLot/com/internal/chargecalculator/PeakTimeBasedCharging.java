package com.internal.chargecalculator;

import com.models.Ticket;

import java.time.LocalDateTime;

public class PeakTimeBasedCharging implements ChargeCalculator{
    @Override
    public int getFare(Ticket ticket) {
        LocalDateTime parkedTime = ticket.getParkedTime();
        LocalDateTime now = LocalDateTime.now();

        // need to check whether the parkedTime - now falls within [6PM to 9PM]


        return 0;
    }
}
