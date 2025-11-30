package java.com.fillingstation.stepdefinitions;

import io.cucumber.java.en.*;
import com.fillingstation.managers.*;
import com.fillingstation.models.*;
import static org.junit.jupiter.api.Assertions.*;

public class PricingStepDefinitions {

    private LocationManager locationManager = new LocationManager();
    private PricingManager pricingManager = new PricingManager();
    private Location testLocation;

    @Given("the location {string} exists")
    public void the_location_exists(String locationName) {
        testLocation = locationManager.findLocationByName(locationName);
        assertNotNull(testLocation, "Location should exist: " + locationName);
    }

    @Given("the location has no pricing defined")
    public void location_has_no_pricing() {
        assertFalse(pricingManager.hasPricing(testLocation));
    }

    @Given("location {string} has AC price {double}")
    public void location_has_ac_price(String locationName, Double price) {
        testLocation = locationManager.findLocationByName(locationName);
        pricingManager.setPricingForLocation(testLocation, price, 0.45);
    }

    @When("the owner sets AC price to {double} per kWh for {string}")
    public void set_ac_price(Double price, String locationName) {
        pricingManager.setPricingForLocation(testLocation, price, pricingManager.getDCPrice(testLocation));
    }

    @Then("location {string} should have active pricing")
    public void location_should_have_active_pricing(String locationName) {
        assertTrue(pricingManager.hasPricing(testLocation));
    }

    @Then("AC price should be {double}")
    public void ac_price_should_be(Double expectedPrice) {
        assertEquals(expectedPrice, pricingManager.getACPrice(testLocation), 0.001);
    }
}