Feature: Checking of the login page functionality

  @positive
  @login
  Scenario Outline: positive login scenario
    Given user inputs username "<username>"
    And inputs password "secret_sauce"
    When user clicks the button login
    Then the main page appears

    Examples:
      | username                |
      | standard_user           |
      | problem_user            |
      | performance_glitch_user |
      | error_user              |
      | visual_user             |

  @negative
  @login
  Scenario: Negative login scenario
    Given user inputs username "locked_out_user"
    And inputs password "secret_sauce"
    When user clicks the button login
    Then the message appears

