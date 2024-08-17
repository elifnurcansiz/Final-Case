Feature: Password Reset Functionality

  Background:
    Given the user is on the login page
    When the user clicks the "Forgot Password?" link
    And the user is redirected to the password reset page

  @resetPasswordPageDB
  Scenario Outline: Verify empty email address error
    When the user leaves the email field "<email>" blank
    And attempts to submit the password reset form
    Then confirm the "Email field cannot be empty!" error message is displayed
    Examples:
      | email |
      |       |


  @resetPasswordPageAction
  Scenario: Expired reset link check
    Given the user has received an expired reset link via email
    When the user attempts to use the expired reset link
    Then verify the "This reset link has expired, please request a new one!" message is displayed
    And ensure that the user is redirected to the password reset request page



  @resetPasswordPageDB
  Scenario: Reset password with a valid token
    Given the user has received a valid password reset token
    When the user submits the reset form with a new password
    Then verify that the password is updated in the database
    And confirm the user is able to log in with the new password

###Databaese
  @resetPasswordPageDB
  Scenario Outline: Invalid email address format validation
    When the user enters an incorrect email format "<email>"
    And tries to submit the password reset form
    Then verify the "Please enter a valid and registered email address!" error message is shown
    Examples:
      | email        |
      | example.com  |
      | user@.com    |
      | userdomain.com |
      | @example.com |

  @resetPasswordPageDB
  Scenario Outline: Reset request for non-registered email
    When the user inputs a non-registered email "<email>" in the reset form
    And submits the reset request
    Then ensure the "No account found with this email!" message appears
    Examples:
      | email               |
      | nonuser@domain.com  |
      | unknown@mail.com    |


  @resetPasswordPageDB
  Scenario Outline: Multiple reset attempts in short time
    Given the user has requested a password reset for "<email>" multiple times in a short period
    When the user tries to submit another reset request
    Then verify that the "Please wait before trying again!" message is displayed
    And ensure that the reset request is not processed in the database
    Examples:
      | email            |
      | frequent@user.com |
      | spam@domain.com  |
