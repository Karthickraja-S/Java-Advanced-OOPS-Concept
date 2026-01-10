package com.internal;

import com.enums.PaymentMode;
import com.enums.VehicleType;
import com.internal.chargecalculator.ChargeStrategy;
import com.internal.chargecalculator.EventBasedCharging;
import com.internal.paymentprocessor.PaymentFactoryProvider;
import com.models.Ticket;
import com.models.Vehicle;

import java.time.LocalDateTime;
import java.util.*;

public class ParkingLot {
    private static Map<Integer,ParkingFloor> parkingFloors = new HashMap<>();
    Map<Long,Ticket> currentTicket = new HashMap<>();
    private ChargeStrategy strategy = new ChargeStrategy(new EventBasedCharging());

    static  {
        ParkingFloor floor1 = new ParkingFloor();
        floor1.addParkingSpots(new ParkingSpot(1,VehicleType.CAR));
        floor1.addParkingSpots(new ParkingSpot(2,VehicleType.CAR));
        floor1.addParkingSpots(new ParkingSpot(3,VehicleType.BIKE));
        floor1.addParkingSpots(new ParkingSpot(4,VehicleType.BIKE));

        ParkingFloor floor2 = new ParkingFloor();
        floor2.addParkingSpots(new ParkingSpot(1,VehicleType.CAR));
        floor2.addParkingSpots(new ParkingSpot(2,VehicleType.VAN));
        floor2.addParkingSpots(new ParkingSpot(3,VehicleType.VAN));

        parkingFloors.put(1,floor1);
        parkingFloors.put(2,floor2);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for(Integer floorNo : parkingFloors.keySet()) {
            ParkingSpot spot =  parkingFloors.get(floorNo).getAvailableParkingSpots(vehicle.getType());
            if(spot != null) {
                // can be parked
                LocalDateTime dateTime = LocalDateTime.now();
                long tktId = System.currentTimeMillis();
                boolean status = spot.tryOccupy();
                if(status) {
                    Ticket ticket = new Ticket(
                            tktId,
                            vehicle,
                            dateTime,
                            floorNo,
                            spot.getSpotNo());

                    System.out.printf("Your vehicle has been parked. " +
                            "Your ticket details : %s %n", ticket);
                    currentTicket.put(tktId, ticket);
                    return ticket;
                } else {
                    System.out.println("Seems someone booked..");
                }
            }
        }
        System.out.println("Parking slot is full");
        return null;
    }

    public void unparkVehicle(Ticket ticket) {
        if(!currentTicket.containsKey(ticket.getTicketId())) {
            // can throw custom exception
            System.out.println("Invalid ticket ID");
        }
        
        List<ParkingSpot> spots = parkingFloors.get(ticket.getFloorNo()).getAllParkingSpots();
        
        ParkingSpot spot = null;
        for(ParkingSpot spotD :spots) {
            if(spotD.getSpotNo() == ticket.getSlotNo()) {
                spot = spotD;
                break;
            }
        }
        // calculate fair and process payment. if payment success do the below line

        int fare = strategy.getFare(ticket);
        boolean status = new PaymentFactoryProvider()
                .getPaymentProcessor(PaymentMode.UPI)
                .processPayment(fare);
        if(status) {
            spot.unOccupy();
            System.out.println("Vehicle unparked successfully....");
        }
    }
}
