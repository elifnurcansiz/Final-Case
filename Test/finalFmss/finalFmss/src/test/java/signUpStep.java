import driver.driverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.mainPage;
import pages.signUpPage;

import java.sql.DriverManager;

public class signUpStep {
    private signUpPage signUp_Page;

    public void signUpPageSteps() {

        this.signUp_Page = new signUpPage(driverManager.driver);
    }

    @When("the user enters a mobile number without the country code")
    public void enterMobileNumberWithoutCountryCode() {
        signUp_Page.enterMobileNumber("1234567890"); // Sample mobile number
    }

    @Then("verify that the Please include the country code message is displayed")
    public void verifyCountryCodeMessage() {

        Assert.assertEquals("Country code error message is not displayed.", "Expected Error Message", signUp_Page.isErrorMessageDisplayed());

    }

    @When("the user enters a password that does not meet security criteria")
    public void enterWeakPassword() {
        signUp_Page.enterPassword("12345"); // Weak password example
        signUp_Page.enterConfirmPassword("12345");
    }

    @Then("verify that the Password is too weak message is displayed")
    public void verifyWeakPasswordMessage() {
        Assert.assertEquals("Country code error message is not displayed.", "Expected Error Message", signUp_Page.isErrorMessageDisplayed());

    }

    @When("the user enters a valid {string}, {string}, {string}, {string}, and {string}")
    public void enterValidDetails(String firstName, String lastName, String email, String password, String phone) {
        signUp_Page.enterFirstName(firstName);
        signUp_Page.enterLastName(lastName);
        signUp_Page.enterEmail(email);
        signUp_Page.enterPassword(password);
        signUp_Page.enterConfirmPassword(password);
        signUp_Page.enterPhone(phone);
    }

    @Then("verify that the account is successfully created in the database")
    public void verifyAccountCreation() {
      //
    }

    @When("the user enters an email address {string} that already exists in the database")
    public void enterDuplicateEmail(String email) {
        signUp_Page.enterEmail(email);
        signUp_Page.enterPassword("ValidPassword1!");
        signUp_Page.enterConfirmPassword("ValidPassword1!");
        signUp_Page.enterFirstName("John");
        signUp_Page.enterLastName("Doe");
        signUp_Page.enterPhone("1234567890");
    }

    @When("the user enters a weak password {string} on the registration form")
    public void enterWeakPasswordWithParam(String password) {
        signUp_Page.enterPassword(password);
        signUp_Page.enterConfirmPassword(password);
    }

    @When("the user enters {string} in the password field")
    public void enterPassword(String password) {
        signUp_Page.enterPassword(password);
    }

    @When("the user enters {string} in the confirm password field")
    public void enterConfirmPassword(String confirmPassword) {
        signUp_Page.enterConfirmPassword(confirmPassword);
    }

    @Then("verify that the Passwords do not match error message is displayed if the passwords don't match")
    public void verifyPasswordMismatchMessage() {
        Assert.assertEquals("Country code error message is not displayed.", "Expected Error Message", signUp_Page.isErrorMessageDisplayed());

    }

    @Then("verify that the Mobile number already in use error message is displayed")
    public void verifyDuplicateMobileNumberMessage() {
        Assert.assertEquals("Country code error message is not displayed.", "Expected Error Message", signUp_Page.isErrorMessageDisplayed());

    }

    @When("the user enters a mobile number {string} that already exists in the database")
    public void enterDuplicateMobileNumber(String phone) {
        signUp_Page.enterPhone(phone);
        signUp_Page.enterEmail("test@example.com");
        signUp_Page.enterPassword("ValidPassword1!");
        signUp_Page.enterConfirmPassword("ValidPassword1!");
        signUp_Page.enterFirstName("John");
        signUp_Page.enterLastName("Doe");
    }
}
