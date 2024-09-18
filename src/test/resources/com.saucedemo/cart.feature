Feature: Checking of the cart page functionality

  Background:
    Given user is on the main page
    And user clicks the addToCart button

  @positive
  @cart
  Scenario: transition from the main page to the cart
    When clicks the cart badge
    Then the user goes to the cart page

  @positive
  @cart
  Scenario: continue shopping button functionality
    And clicks the cart badge
    When user clicks the continue shopping button
    Then the user goes to the main page

  @positive
  @cart
  Scenario: checkout button functionality
    And clicks the cart badge
    When user clicks the checkout button
    Then the user goes to the checkout page

  @positive
  @cart
  Scenario: remove button functionality
    And clicks the cart badge
    When user clicks the remove button from cart page
    Then the item is removed from the cart

  @positive
  @cart
  Scenario: transition from the cart page to the product page
    And clicks the cart badge
    When user clicks the name of product link
    Then the user goes to the product page