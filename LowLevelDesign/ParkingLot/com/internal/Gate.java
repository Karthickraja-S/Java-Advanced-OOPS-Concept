package com.internal;

import com.models.Ticket;
import com.models.Vehicle;

public class Gate {
    // if a entry gate 1 has 2-3 parking lots, then we can maintain
    // Map<Integer,List<ParkingLot>> here.
    ParkingLot parkingLot = new ParkingLot();
    public Ticket parkVehicle(Vehicle vehicle) {
        return parkingLot.parkVehicle(vehicle);
    }
    public void unPark(Ticket ticket){
        parkingLot.unparkVehicle(ticket);
    }
}
