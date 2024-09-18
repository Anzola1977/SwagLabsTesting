Feature: Checking the functionality of the product page

  Background:
    Given user is on the main page
    And user clicks the addToCart button
    When clicks the name of product link

  @positive
  @product
  Scenario: transition from the main page to the product page
    Then the user goes to the product page

  @positive
  @product
  Scenario: functionality of delete button on product page
    When user clicks the remove button from product page
    And clicks the cart badge
    Then the item is removed from the cart

  @positive
  @product
  Scenario: functionality of Add to Cart button on product page
    When user clicks the remove button from product page
    Then the Add to cart button on the product page appears

  @positive
  @product
  Scenario: functionality of All Items in drop down menu from product page
    When user clicks the burger menu
    And clicks AllItems button
    Then the user goes to the main page

  @positive
  @product
  Scenario: Back to products link functionality
    When user clicks the Back to products link
    Then the user goes to the main page