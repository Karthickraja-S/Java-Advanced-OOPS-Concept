package com.models;

import java.time.LocalDateTime;

public class Ticket {

    private long ticketId;
    private Vehicle vehicle;
    private LocalDateTime parkedTime;
    private int floorNo;
    private int slotNo;

    public Ticket(long ticketId, Vehicle vehicle, LocalDateTime parkedTime, int floorNo, int slotNo) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkedTime = parkedTime;
        this.floorNo = floorNo;
        this.slotNo = slotNo;
    }

    public long getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getParkedTime() {
        return parkedTime;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public int getSlotNo() {
        return slotNo;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", vehicle=" + vehicle +
                ", parkedTime=" + parkedTime +
                ", floorNo=" + floorNo +
                ", slotNo=" + slotNo +
                '}';
    }
}
