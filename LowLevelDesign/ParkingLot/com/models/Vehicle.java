package com.models;

import com.enums.VehicleType;

public class Vehicle {
    private final String vehicleNo;
    private final VehicleType type;
    public Vehicle(String vehicleNo , VehicleType type) {
        this.vehicleNo = vehicleNo;
        this.type = type;
    }
    public String getVehicleNo() {return vehicleNo;}
    public VehicleType getType() {return type;}

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNo='" + vehicleNo + '\'' +
                ", type=" + type +
                '}';
    }
}
