Feature: User registration page functionality

  Background:
    Given the user is on the tutorial screen
    When the user selects the "Skip Introduction" button
    And presses the "Register with Email" button
    And selects the "Individual" option on the Account Type screen

  @signUpPageLinkVerification
  Scenario: Validate Privacy Policy page
    When the user clicks the "Privacy Policy" link on the registration form
    Then verify that the "Privacy Policy" page is displayed

  @signUpPageLinkVerification
  Scenario: Validate Terms and Conditions page
    When the user clicks the "Terms and Conditions" link on the registration form
    Then verify that the "Terms and Conditions" page is displayed

  @signUpPageAcceptance
  Scenario: Agree to Privacy Policy
    When the user clicks the "Privacy Policy" link on the registration form
    Then the user agrees by clicking the "I Accept" button on the Privacy Policy page

  @signUpPageRedirect
  Scenario: Navigate to login page
    When the user clicks the "Already registered?" button on the registration form
    Then verify that the "Log in with Email" page is displayed

  @signUpPageInputValidation
  Scenario: Ensure all fields are filled
    When the user attempts to register without entering any information
    Then verify that the "Please complete all required fields" message is shown

  @signUpPageMobileCheck
  Scenario: Mobile number validation
    When the user enters a mobile number without the country code
    And attempts to register
    Then verify that the "Please include the country code" message is displayed

  @signUpPageUIFeedback
  Scenario: Display password strength indicator
    When the user types a password into the registration form
    Then verify that a password strength meter appears and indicates the strength level

  @signUpPageUIFeedback
  Scenario: Password visibility toggle
    When the user enters a password on the registration form
    And clicks the "Show Password" icon
    Then verify that the password is visible in plain text

  @signUpPageSecurityCheck
  Scenario: Block registration with weak password
    When the user enters a password that does not meet security criteria
    And tries to submit the form
    Then verify that the "Password is too weak" message is displayed, and the registration is blocked

  @signUpPageAcceptance
  Scenario: Agree to Terms and Conditions
    When the user clicks the "Terms and Conditions" link on the registration form
    Then the user agrees by clicking the "I Accept" button on the Terms and Conditions page

  @signUpPageMobileCheck
  Scenario: SMS verification for mobile number
    When the user enters a mobile number
    And clicks the "Register" button
    Then verify that an SMS verification code is sent to the provided number

  @signUpPageInputValidation
  Scenario: Validate email format
    When the user inputs an incorrectly formatted email address
    And clicks the "Register" button
    Then verify that the "Invalid email format" error message is shown
#####Database
  @signUpPageInitialCheck
  Scenario Outline: Verify input fields
    Then check the "<input1>" field on the registration form
    And check the "<input2>" field on the registration form
    And check the "<input3>" field on the registration form
    And check the "<input4>" field on the registration form
    And check the "<input5>" field on the registration form
    Examples:
      | input1      | input2     | input3   | input4   | input5        |
      | First Name  | Last Name  | Email ID | Password | Mobile Number |

  @signUpPageDBValidation
  Scenario Outline: Invalid email address format check
    When the user enters "<email>" into the email field on the registration form
    And fills in all other required fields correctly
    And submits the registration form
    Then verify that the "Invalid email address format" error message is shown
    Examples:
      | email            |
      | elif.doe.com     |
      | nur@doe         |
      | @domain.com      |

  @signUpPageDBValidation
  Scenario Outline: Duplicate email address check
    When the user enters an email address "<email>" that already exists in the database
    And fills in all other required fields correctly
    And submits the registration form
    Then verify that the "Email address already in use" error message is displayed
    Examples:
      | email            |
      | existing@domain.com |
      | user@example.com  |

  @signUpPageDBValidation
  Scenario Outline: Weak password validation
    When the user enters a weak password "<password>" on the registration form
    And fills in all other required fields correctly
    And submits the registration form
    Then verify that the "Password is too weak" error message is shown
    Examples:
      | password   |
      | 123456     |
      | password   |
      | qwerty     |

  @signUpPageDBValidation
  Scenario Outline: Password confirmation match
    When the user enters "<password>" in the password field
    And "<confirm_password>" in the confirm password field
    And submits the registration form
    Then verify that the "Passwords do not match" error message is displayed if the passwords don't match
    Examples:
      | password   | confirm_password |
      | MyPass123! | MyPass1234       |
      | Str0ngPass | Str0ngPass1      |
  @signUpPageDBInsertion
  Scenario Outline: Successful account creation
    When the user enters a valid "<first_name>", "<last_name>", "<email>", "<password>", and "<phone>"
    And submits the registration form
    Then verify that the account is successfully created in the database
    And verify that the user receives a "Welcome" email
    Examples:
      | first_name | last_name | email                      | password   | phone      |
      | Elifnur    | Cansiz     | elifnur.cansiz@domain.com | Str0ngPass | 5551234567 |
      | Ela        | Kocaali    | ela.kocaali@mail.com      | MyPass123! | 5559876543 |

  @signUpPageDBValidation
  Scenario Outline: Unique mobile number validation
    When the user enters a mobile number "<phone>" that already exists in the database
    And fills in all other required fields correctly
    And submits the registration form
    Then verify that the "Mobile number already in use" error message is displayed
    Examples:
      | phone      |
      | 5551234567 |
      | 5559876543 |
