package com.internal.chargecalculator;

import com.models.Ticket;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

public class EventBasedCharging implements ChargeCalculator{
    @Override
    public int getFare(Ticket ticket) {

        LocalDateTime parkedTime = ticket.getParkedTime();
        LocalDateTime now = LocalDateTime.now();

        // just adding 2 hour to now for testing
        now = now.plusHours(2);
        //System.out.println(parkedTime);
        //System.out.println(now);

        Duration duration = Duration.between(parkedTime,now);
    //    System.out.println("DurationObject : "+duration);

        int hour =  (int) duration.toHours();

        int charge = hour * 20;
        DayOfWeek dayOfWeek = parkedTime.getDayOfWeek();
        if(dayOfWeek.equals(DayOfWeek.SATURDAY) || dayOfWeek.equals(DayOfWeek.SUNDAY) ) {
            System.out.println("Pricing additional charges of 10 rupees for saturday & sunday.");
            charge += hour*10;
        }

        return charge;
    }
}
