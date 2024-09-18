Feature: E2E Testing the product purchase process

  @positive
  @E2E
  @isolated
  Scenario: Checking the product purchase process
    Given user is on the main page
    And user clicks the name of product link
    And user clicks the addToCart button from product page
    And clicks the cart badge
    When user clicks the checkout button
    And user input first name, last name and postal code
    And clicks continue button
    And user clicks the finish button
    Then the success message appears