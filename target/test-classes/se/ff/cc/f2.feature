@smoke
Feature: f2
  Scenario: s2
    Given some other start condition
    When something is else done
    Then something else should happen

  Scenario Outline: Check the login page
    When I am on the home page and login using "<browser>"
    Then I provide email as "<email>"

    Examples:
      | browser | email           |
#      | firefox | hello@hello.com |
      | chrome | hello@hello.com |