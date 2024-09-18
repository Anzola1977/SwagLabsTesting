Feature: Checking product sorting

  @positive
  @sort
  Scenario: price of product sorting from low to high
    Given user is on the main page
    When user selects sorting from low to high
    Then the product with the lowest price is displayed first

  @positive
  @sort
  Scenario: price of product sorting from high to low
    Given user is on the main page
    When user selects sorting from high to low
    Then the product with the highest price is displayed first