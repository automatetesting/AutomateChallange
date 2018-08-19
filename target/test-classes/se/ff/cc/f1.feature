@smoke
Feature: f1

  Scenario Outline: Check the login page
    When I am on the home page and login using "<browser>"
    Then I provide email as "<email>"

#    @sidhuonly
#    Examples:
#      | browser | email           |
##      | firefox | hello@hello.com |
#      | chrome  | hello@hello.com |

#    @smoke
    Examples:
      | browser | email           |
      | firefox | hello@hello.com |
#      | chrome  | hello@hello.com |
