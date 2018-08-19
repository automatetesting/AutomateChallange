@smoke
Feature: Valtech

  Scenario Outline: Check the login page
    When I am on the Valtech home page and login using "<browser>"
    Then The recent blog section is displayed
    When I click on the "<page>"
    Then The "<page>" is dispalyed


    Examples:
      | browser | page     |
      | chrome  | ABOUT    |
      | chrome  | SERVICES |
      | firefox | WORK     |


