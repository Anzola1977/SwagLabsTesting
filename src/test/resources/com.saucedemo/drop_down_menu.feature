Feature: Checking drop down menu functionality

  Background:
    Given user is on the main page
    When user clicks the burger menu

  @positive
  @dropDownMenu
  Scenario: Logout functionality
    And clicks Logout
    Then the user goes to the login page

  @positive
  @dropDownMenu
  Scenario: About functionality
    And clicks About
    Then the user goes to the SauceLabs page

  @positive
  @dropDownMenu
  @isolated
  Scenario: Close Menu functionality
    And clicks Close Menu
    Then menu closed