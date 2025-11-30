package com.fillingstation.managers;

import com.fillingstation.models.Location;
import com.fillingstation.models.PricingPlan;
import java.util.HashMap;
import java.util.Map;

public class PricingManager {
    private Map<Location, PricingPlan> locationPricing = new HashMap<>();

    public void setPricingForLocation(Location location, double acPrice, double dcPrice) {
        PricingPlan plan = new PricingPlan(locationPricing.size() + 1, acPrice, dcPrice);
        locationPricing.put(location, plan);
        location.updatePricingPlan(plan);
    }

    public double getACPrice(Location location) {
        return locationPricing.get(location).getAcRateFixed();
    }

    public double getDCPrice(Location location) {
        return locationPricing.get(location).getDcRateFixed();
    }

    public boolean hasPricing(Location location) {
        return locationPricing.containsKey(location);
    }
}