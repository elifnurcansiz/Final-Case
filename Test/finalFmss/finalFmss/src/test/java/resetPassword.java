import driver.driverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.mainPage;
import pages.passwordResetPage;

public class resetPassword {

    private passwordResetPage passwordReset_Page;


    public resetPassword() {
        this.passwordReset_Page = new passwordResetPage(driverManager.driver);
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {

    }

    @When("the user clicks the {string} link")
    public void theUserClicksTheLink(String linkText) {

    }

    @And("the user is redirected to the password reset page")
    public void theUserIsRedirectedToThePasswordResetPage() {

    }

    @When("the user leaves the email field {string} blank")
    public void theUserLeavesTheEmailFieldBlank(String email) {
        passwordReset_Page.enterEmail(email);
    }

    @And("attempts to submit the password reset form")
    public void attemptsToSubmitThePasswordResetForm() {
        passwordReset_Page.clickResetButton();
    }

    @Then("confirm the {string} error message is displayed")
    public void confirmTheErrorMessageIsDisplayed(String expectedMessage) {
        String actualMessage = passwordReset_Page.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Given("the user has received an expired reset link via email")
    public void theUserHasReceivedAnExpiredResetLinkViaEmail() {

    }

    @When("the user attempts to use the expired reset link")
    public void theUserAttemptsToUseTheExpiredResetLink() {

    }

    @Then("verify the {string} message is displayed")
    public void verifyTheMessageIsDisplayed(String expectedMessage) {
        String actualMessage = passwordReset_Page.getExpiredLinkMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @And("ensure that the user is redirected to the password reset request page")
    public void ensureThatTheUserIsRedirectedToThePasswordResetRequestPage() {

    }

    @Given("the user has received a valid password reset token")
    public void theUserHasReceivedAValidPasswordResetToken() {

    }

    @When("the user submits the reset form with a new password")
    public void theUserSubmitsTheResetFormWithANewPassword() {

    }

    @Then("verify that the password is updated in the database")
    public void verifyThatThePasswordIsUpdatedInTheDatabase() {

    }

    @And("confirm the user is able to log in with the new password")
    public void confirmTheUserIsAbleToLogInWithTheNewPassword() {

    }

    @When("the user enters an incorrect email format {string}")
    public void theUserEntersAnIncorrectEmailFormat(String email) {
        passwordReset_Page.enterEmail(email);
    }

    @Then("verify the {string} error message is shown")
    public void verifyTheErrorMessageIsShown(String expectedMessage) {
        String actualMessage = passwordReset_Page.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("the user inputs a non-registered email {string} in the reset form")
    public void theUserInputsANonRegisteredEmailInTheResetForm(String email) {
        passwordReset_Page.enterEmail(email);
    }

    @Then("ensure the {string} message appears")
    public void ensureTheMessageAppears(String expectedMessage) {
        String actualMessage = passwordReset_Page.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Given("the user has requested a password reset for {string} multiple times in a short period")
    public void theUserHasRequestedAPasswordResetForMultipleTimesInAShortPeriod(String email) {

    }

    @When("the user tries to submit another reset request")
    public void theUserTriesToSubmitAnotherResetRequest() {
        passwordReset_Page.clickResetButton();
    }

    @Then("verify that the {string} message is displayed")
    public void verifyThatTheMessageIsDisplayed(String expectedMessage) {
        String actualMessage = passwordReset_Page.getErrorMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @And("ensure that the reset request is not processed in the database")
    public void ensureThatTheResetRequestIsNotProcessedInTheDatabase() {

    }
}