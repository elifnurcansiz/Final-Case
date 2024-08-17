import driver.driverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.loginPage;

public class loginStep {

    private loginPage login_Page;

    // Constructor
    public void signUpPageSteps() {

        this.login_Page = new loginPage(driverManager.driver);
    }

    @When("the user clicks the {string} link on the login page")
    public void theUserClicksTheLinkOnTheLoginPage(String linkName) {
        login_Page.clickElement(linkName);
    }

    @Then("verify the {string} title")
    public void verifyTheTitle(String title) {

        Assert.assertTrue("Title not verified", login_Page.isTitleDisplayed(title));
    }

    @And("enters valid credentials")
    public void entersValidCredentials() {
        login_Page.enterText("Email", "valid.email@example.com");
        login_Page.enterText("Password", "validPassword");
    }

    @Then("verify that the user is logged in and {string} is active")
    public void verifyThatTheUserIsLoggedInAndIsActive(String feature) {

    }

    @When("the user checks the {string} checkbox on the login page")
    public void theUserChecksTheCheckboxOnTheLoginPage(String checkboxName) {
        login_Page.clickElement(checkboxName);
    }

    @Then("verify that {string} and {string} options are available")
    public void verifyThatAndOptionsAreAvailable(String option1, String option2) {

    }

    @Given("the user attempts to log in with incorrect credentials three times")
    public void theUserAttemptsToLogInWithIncorrectCredentialsThreeTimes() {

    }

    @Then("verify that the account is locked and displays {string}")
    public void verifyThatTheAccountIsLockedAndDisplays(String message) {

    }

    @Then("verify the {string} field on the login page")
    public void verifyTheFieldOnTheLoginPage(String fieldName) {
        // Implement field verification logic
    }

    @When("the user enters the email {string} and password {string}")
    public void theUserEntersTheEmailAndPassword(String email, String password) {
        login_Page.enterText("Email", email);
        login_Page.enterText("Password", password);
    }

    @Then("verify that the {string} message is displayed")
    public void verifyThatTheMessageIsDisplayed(String message) {

    }

    @Then("verify that the login attempt is recorded in the audit log with the timestamp and IP address")
    public void verifyThatTheLoginAttemptIsRecordedInTheAuditLogWithTimestampAndIPAddress() {
        String email = "user1@domain.com";  // Use actual test data or parameterize
        String ipAddress = "192.168.1.1";    // Use actual test data or parameterize
        Assert.assertTrue("Audit log entry not found", login_Page.isAuditLogEntryPresent(email, ipAddress));
    }

    @Then("verify the {string} message")
    public void verifyTheMessage(String message) {

    }
}
