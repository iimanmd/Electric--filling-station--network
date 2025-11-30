package com.fillingstation.models;

public class ChargingStation {
    private String stationId;
    private String mode;
    private String status;
    private Location location;

    public ChargingStation(String stationId, String mode, Location location) {
        this.stationId = stationId;
        this.mode = mode;
        this.status = "FREE";
        this.location = location;
    }

    public void startSession() {
        this.status = "OCCUPIED";
    }

    public void stopSession() {
        this.status = "FREE";
    }


    public String getStatus() { return status; }
    public String getMode() { return mode; }
    public String getStationId() { return stationId; }

    public Location getLocation() {
        return null;
    }
}