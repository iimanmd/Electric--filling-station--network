package com.fillingstation.models;

public class PricingPlan {
    private int planId;
    private double acRateFixed;
    private double dcRateFixed;
    private double rateEvaluation;
    public PricingPlan() {}

    public PricingPlan(int planId, double acRate, double dcRate) {
        this.planId = planId;
        this.acRateFixed = acRate;
        this.dcRateFixed = dcRate;
    }


    public double getAcRateFixed() { return acRateFixed; }
    public void setAcRateFixed(double acRateFixed) { this.acRateFixed = acRateFixed; }

    public double getDcRateFixed() { return dcRateFixed; }
    public void setDcRateFixed(double dcRateFixed) { this.dcRateFixed = dcRateFixed; }

    public void updateRate() {

    }
}