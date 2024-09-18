Feature: Checking of the checkout pages functionality

  Background:
    Given user is on the main page
    And user clicks the addToCart button
    And clicks the cart badge
    And user clicks the checkout button

  @positive
  @checkout
  Scenario: Checking of input information about client and continue button
    When user input first name, last name and postal code
    And clicks continue button
    Then the user goes to the checkout page two

  @positive
  @checkout
  Scenario: Checking of the cancel button on checkout page one
    When user clicks the cancel button
    Then the user goes to the cart page

  @positive
  @checkout
  Scenario: Checking of the cancel button on checkout page two
    And user input first name, last name and postal code
    And clicks continue button
    When user clicks the cancel button on the second page of the checkout
    Then the user goes to the main page

  @positive
  @checkout
  Scenario: Checking of the finish button
    And user input first name, last name and postal code
    And clicks continue button
    When user clicks the finish button
    Then the success message appears

  @positive
  @checkout
  Scenario: Checking of the back home button
    And user input first name, last name and postal code
    And clicks continue button
    And user clicks the finish button
    When user clicks the back home button
    Then the user goes to the main page





