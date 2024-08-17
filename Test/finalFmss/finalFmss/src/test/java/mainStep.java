import driver.driverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.mainPage;

public class mainStep {
    private mainPage main_Page;

    public mainStep() {
        this.main_Page = new mainPage (driverManager.driver);
    }

    @When("the user clicks the {string} link")
    public void theUserClicksTheLink(String linkText) {
        main_Page.clickFooterLink(linkText);
    }

    @Then("confirm the {string} title is visible")
    public void confirmTheTitleIsVisible(String title) {
        boolean isVisible = main_Page.isPageTitleDisplayed(title);
        assert isVisible : title + " title is not visible.";
    }

    @When("the user selects the {string} button")
    public void theUserSelectsTheButton(String buttonName) {
        switch (buttonName) {
            case "Sign in with Google":
                main_Page.clickGoogleSignInButton();
                break;
            case "Register with Email":
                main_Page.clickRegisterWithEmailButton();
                break;
        }
    }

    @Then("verify the {string} message is displayed")
    public void verifyTheMessageIsDisplayed(String message) {
        boolean isDisplayed = main_Page.isMessageDisplayed(message);
        assert isDisplayed : message + " message is not displayed.";
    }

    @And("selects the {string} option on the Account Type screen")
    public void selectsTheOptionOnTheAccountTypeScreen(String option) {
        switch (option) {
            case "Individual":
                main_Page.clickIndividualOption();
                break;
            case "Business":
                main_Page.clickBusinessOption();
                break;
        }
    }

    @Then("verify that the {string} title is displayed")
    public void verifyThatTheTitleIsDisplayed(String title) {
        boolean isTitleDisplayed = main_Page.isPageTitleDisplayed(title);
        assert isTitleDisplayed : title + " title is not displayed.";
    }

    @When("the user clicks the {string} link in the footer")
    public void theUserClicksTheLinkInTheFooter(String linkText) {
        main_Page.clickFooterLink(linkText);
    }

    @Then("verify that the {string} page is displayed with the correct title")
    public void verifyThatThePageIsDisplayedWithTheCorrectTitle(String pageTitle) {
        boolean isPageDisplayed = main_Page.isPageTitleDisplayed(pageTitle);
        assert isPageDisplayed : pageTitle + " page is not displayed.";
    }

    @When("the user selects the language dropdown")
    public void theUserSelectsTheLanguageDropdown() {
        main_Page.clickLanguageDropdown();
    }

    @And("chooses {string}")
    public void chooses(String language) {
        main_Page.selectLanguage(language);
    }

    @Then("confirm that the page content is displayed in French")
    public void confirmThatThePageContentIsDisplayedInFrench() {
        boolean isFrench = main_Page.isPageContentInFrench();
        assert isFrench : "Page content is not displayed in French.";
    }

    @Then("verify the presence of the {string} button")
    public void verifyThePresenceOfTheButton(String buttonName) {
        boolean isPresent = main_Page.isButtonPresent(buttonName);
        assert isPresent : buttonName + " button is not present.";
    }

    @And("confirm the presence of the {string} button")
    public void confirmThePresenceOfTheButton(String buttonName) {
        boolean isPresent = main_Page.isButtonPresent(buttonName);
        assert isPresent : buttonName + " button is not present.";
    }
}