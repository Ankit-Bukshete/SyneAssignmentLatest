Feature: Admin Test Feature

#  Background:
#    Given the user is on the login page
#    When the user enters the "Admin" and "admin123"

#  Scenario Outline: Add Admin
#    Given the user is on the login page
#    When the user enters the "Admin" and "admin123"
#    And the user adds new Admin "<username>"
#    Then add user success message should be displayed
#    Examples:
#      | username |
#      | testuser |

    Scenario: Login
      Given the user is on the login page
      When the user enters the "Admin" and "admin123"

