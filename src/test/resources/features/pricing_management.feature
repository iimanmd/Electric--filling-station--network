Feature: Pricing Management
  As an Owner
  I want to manage pricing for locations
  So that I can optimize revenue

  Scenario: Set initial pricing for location
    Given the location "Vienna Central" exists
    And the location has no pricing defined
    When the owner sets AC price to 0.30 per kWh for "Vienna Central"
    And the owner sets DC price to 0.45 per kWh for "Vienna Central"
    Then location "Vienna Central" should have active pricing
    And AC price should be 0.30
    And DC price should be 0.45

  Scenario: Update pricing multiple times per day
    Given location "Vienna Central" has AC price 0.30
    When the owner updates AC price to 0.35 for "Vienna Central"
    Then the AC price should be 0.35 for "Vienna Central"