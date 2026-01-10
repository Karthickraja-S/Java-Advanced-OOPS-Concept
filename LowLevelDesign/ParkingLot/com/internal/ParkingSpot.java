package com.internal;

import com.enums.VehicleType;

import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingSpot {

    private final int spotNo;
    private final VehicleType type;

    // When 2 bikes comes in 2 different entry gates, only one spot need to be assigned.
    private final AtomicBoolean spotStatus = new AtomicBoolean(false);

    public ParkingSpot(int spotNo , VehicleType type) {
        this.spotNo = spotNo;
        this.type = type;
    }

    public boolean tryOccupy() {
        return spotStatus.compareAndSet(false,true);
    }
    public void unOccupy() {
        spotStatus.set(false);
    }
    public boolean isSpotOccupied() {
        return spotStatus.get();
    }
    public VehicleType getType() {
        return this.type;
    }
    public int getSpotNo() {
        return this.spotNo;
    }
}
