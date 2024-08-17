Feature: Main Page Elements
  Background:
    Given the user is on the tutorial screen
    And the user clicks the "Skip Introduction" button

  @mainPageInitialCheck
  Scenario: Verify slogan text
    Then ensure the "Drive with the Freedom of Flight" message is displayed

  @mainPagePolicyCheck
  Scenario: Verify Privacy Policy page
    When the user clicks the "Privacy Policy" link
    Then confirm the "Privacy Policy" title is visible

  @mainPagePolicyCheck
  Scenario: Verify Terms of Service page
    When the user clicks the "Terms and Conditions" link
    Then confirm the "Terms and Conditions" title is visible

  @mainPageAuthentication
  Scenario: Sign in with Google Account
    When the user selects the "Sign in with Google" button
    Then verify the "Sign in with your Google account" message is displayed


  @mainPageRegistration
  Scenario: Email Sign-Up Process
    When the user clicks the "Register with Email" button
    And selects the "Individual" option on the Account Type screen
    Then verify that the "Create Your Account" title is displayed

  @mainPageNavigation
  Scenario: Navigate to Login Page
    When the user clicks the "Already registered?" link
    Then verify that the "Log in with Email" page is shown

  @mainPageFeatureCheck
  Scenario: Explore Features section
    When the user scrolls down to the "Features" section on the main page
    Then verify that the "Our Key Features" title is displayed
    And confirm that the list of features is visible

  @mainPageNavigation
  Scenario: Access the Support page
    When the user clicks the "Support" link in the footer
    Then verify that the "Customer Support" page is displayed with the correct title

  @mainPageLanguageSwitch
  Scenario: Switch site language
    When the user selects the language dropdown
    And chooses "French"
    Then confirm that the page content is displayed in French

    ###Database

  @mainPageRegistration
  Scenario Outline: Sign up using Email
    When the user selects the "Register with Email" button
    Then verify the presence of the "<option1>" button
    And confirm the presence of the "<option2>" button
    Examples:
      | option1  | option2 |
      | Personal | Business |

