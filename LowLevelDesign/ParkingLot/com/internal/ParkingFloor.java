package com.internal;

import com.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    public void addParkingSpots(ParkingSpot spot ) {
        parkingSpots.add(spot);
    }

    public ParkingSpot getAvailableParkingSpots(VehicleType type) {
        for(ParkingSpot spot : parkingSpots) {
            if (!spot.isSpotOccupied() && spot.getType().equals(type)) {
                return spot;
            }
        }
        return null;
    }
    public List<ParkingSpot> getAllParkingSpots() {
        return parkingSpots;
    }

}
