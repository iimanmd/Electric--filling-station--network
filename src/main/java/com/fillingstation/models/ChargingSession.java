package com.fillingstation.models;

import java.time.LocalDateTime;
import java.time.Duration;

public class ChargingSession {
    private int sessionId;
    private Customer customer;
    private ChargingStation chargingStation;
    private LocalDateTime startTime;
    private int duration;
    private double transferredEnergy;
    private double price;

    public ChargingSession(int sessionId, Customer customer, ChargingStation station) {
        this.sessionId = sessionId;
        this.customer = customer;
        this.chargingStation = station;
        this.startTime = LocalDateTime.now();
        this.chargingStation.startSession();
    }

    public double calculateCost() {

        PricingPlan plan = chargingStation.getLocation().getPricingPlans().get(0);
        double rate = "AC".equals(chargingStation.getMode()) ?
                plan.getAcRateFixed() : plan.getDcRateFixed();
        return transferredEnergy * rate;
    }

    public void endSession(double energyConsumed) {
        this.transferredEnergy = energyConsumed;
        this.duration = (int) Duration.between(startTime, LocalDateTime.now()).toMinutes();
        this.price = calculateCost();
        this.chargingStation.stopSession();
    }

    public double getPrice() { return price; }
    public double getTransferredEnergy() { return transferredEnergy; }

    public int getSessionId() {
        return 0;
    }
}