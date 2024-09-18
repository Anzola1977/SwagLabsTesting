Feature: Add to cart functionality

  @positive
  @addToCart
  Scenario: Add to cart from main page
    Given user is on the main page
    When user clicks the addToCart button
    Then an icon for the number of items added to the cart appears

  @positive
  @addToCart
  Scenario: Checking of the Add to cart button functionality
    Given user is on the main page
    When user clicks the addToCart button
    Then a button to remove an item appears

  @positive
  @addToCart
  Scenario: Checking the possibility of changing from the Add to cart button to Remove button and backwards
    Given user is on the main page
    When user clicks the addToCart button
    And user clicks the remove button from main page
    Then the Add to cart button appears

  @positive
  @addToCart
  Scenario: Checking of the Remove button functionality
    Given user is on the main page
    And user clicks the addToCart button
    And user clicks the remove button from main page
    When clicks the cart badge
    Then the item is removed from the cart

  @positive
  @addToCart
  Scenario: Add to cart from product page
    Given user is on the main page
    And clicks the name of product link
    When user clicks the addToCart button from product page
    And clicks the cart badge
    Then In the cart we see the name of added product

  @positive
  @addToCart
  Scenario: Reset App State functionality from main page
    Given user is on the main page
    And user clicks the addToCart button
    When user clicks the burger menu
    And clicks Reset App State button
    And clicks the cart badge
    Then the item is removed from the cart

  @positive
  @addToCart
  Scenario: Reset App State functionality from product page
    Given user is on the main page
    And clicks the name of product link
    And user clicks the addToCart button from product page
    When user clicks the burger menu
    And clicks Reset App State button
    And clicks the cart badge
    Then the item is removed from the cart