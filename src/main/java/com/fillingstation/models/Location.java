package com.fillingstation.models;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private int locationId;
    private String name;
    private String address;
    private List<PricingPlan> pricingPlans = new ArrayList<>();
    private List<ChargingStation> stations = new ArrayList<>();

    public Location(int locationId, String name, String address) {
        this.locationId = locationId;
        this.name = name;
        this.address = address;
    }

    public void addStation(ChargingStation station) {
        this.stations.add(station);
    }

    public void updatePricingPlan(PricingPlan plan) {
        this.pricingPlans.add(plan);
    }

    public String getStatus() {
        long availableStations = stations.stream()
                .filter(s -> "FREE".equals(s.getStatus()))
                .count();
        return "Stations: " + stations.size() + ", Available: " + availableStations;
    }


    public String getName() { return name; }
    public List<ChargingStation> getStations() { return stations; }
    public List<PricingPlan> getPricingPlans() { return pricingPlans; }
}