Feature: User authentication page functionality

  Background:
  Given User is on the Tutorial page
   When the user clicks the "Skip Tour" button
   And clicks the "Already have an account?" button



  @loginPageRecovery
  Scenario: Password recovery process
    When the user clicks the "Forgot password?" link on the login page
    Then verify the "Reset your password" title

  @loginPageGoogleAuth
  Scenario: Login using Google Account
    When the user clicks the "Sign in with Google" button on the login page
    Then verify the "Sign in with your Google account" title

  @loginPageAccountCreation
  Scenario: Create a new account
    When the user clicks the "Create an account" button on the login page
    And selects the "Individual" option on the Account Type page
    Then verify the "Register Your Account" title


  @loginPageRememberMe
  Scenario: Remember me functionality
    When the user checks the "Remember me" checkbox on the login page
    And enters valid credentials
    And clicks the "Sign in" button
    Then verify that the user is logged in and "Remember me" is active

  @loginPageSocialLogin
  Scenario: Social media login options
    When the user views the login page
    Then verify that "Login with Facebook" and "Login with Twitter" options are available

  @loginPageSecurityCheck
  Scenario: Account lockout after multiple failed attempts
    Given the user attempts to log in with incorrect credentials three times
    Then verify that the account is locked and displays "Too many failed attempts, please try again later."

    ##Database

  @loginPageBasicCheck
  Scenario Outline: Input fields verification
    Then verify the "<input1>" field on the login page
    And verify the "<input2>" field on the login page
    Examples:
      | input1   | input2   |
      | Username | Password |


  @loginPageDBValidation
  Scenario Outline: Attempt to login with a disabled account
    When the user enters the email "<email>" and password "<password>"
    And clicks the "Login" button
    Then verify that the "Your account is disabled" message is displayed
    And the user cannot log in
    Examples:
      | email              | password     |
      | elifnur@gmail.com  | Elif1234     |
      | ela@gmail.ccom     | Blocked123!  |

  @loginPageValidation
  Scenario Outline: Invalid password validation
    Then enter "<email>" in the email field
    And enter "<password>" in the password field
    And click the "Sign in" button on the login page
    And verify the "Invalid password!" message
    Examples:
      | email            | password    |
      | user@example.com | password123 |


  @loginPageErrorCheck
  Scenario Outline: Non-existent email validation
    Then enter "<email>" in the email field
    And enter "<password>" in the password field
    And click the "Sign in" button on the login page
    And verify the "Email not registered!" message
    Examples:
      | email            | password     |
      | test@example.com | password1234 |

  @loginPageAudit
  Scenario Outline: Login attempt audit logging
    When the user enters the email "<email>" and password "<password>"
    And clicks the "Login" button
    Then verify that the login attempt is recorded in the audit log with the timestamp and IP address
    Examples:
      | email              | password    |
      | user1@domain.com   | SecurePass1 |
      | user2@domain.com   | Welcome123! |

  @loginPageEmptyFieldCheck
  Scenario Outline: Blank fields validation
    Then enter "<email>" in the email field
    And enter "<password>" in the password field
    And click the "Sign in" button on the login page
    And verify the "Fields cannot be empty!" message
    Examples:
      | email               | password       |
      |                     | elifnur1234.   |
      | elifnur@gmail.com   |                |
