package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import pages.*;

public class signUpPage {
    private AppiumDriver<MobileElement> driver;

    public signUpPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



        // Android Locators
        @AndroidFindBy(id = "com.rentfly.app:id/privacyPolicyLink")
        private MobileElement androidPrivacyPolicyLink;

        @AndroidFindBy(id = "com.rentfly.app:id/termsConditionsLink")
        private MobileElement androidTermsConditionsLink;

        @AndroidFindBy(id = "com.rentfly.app:id/acceptButton")
        private MobileElement androidAcceptButton;

        @AndroidFindBy(id = "com.rentfly.app:id/alreadyRegisteredButton")
        private MobileElement androidAlreadyRegisteredButton;

        @AndroidFindBy(id = "com.rentfly.app:id/mobileNumberField")
        private MobileElement androidMobileNumberField;

        @AndroidFindBy(id = "com.rentfly.app:id/passwordField")
        private MobileElement androidPasswordField;

        @AndroidFindBy(id = "com.rentfly.app:id/confirmPasswordField")
        private MobileElement androidConfirmPasswordField;

        @AndroidFindBy(id = "com.rentfly.app:id/showPasswordIcon")
        private MobileElement androidShowPasswordIcon;

        @AndroidFindBy(id = "com.rentfly.app:id/registerButton")
        private MobileElement androidRegisterButton;

        @AndroidFindBy(id = "com.rentfly.app:id/errorMessage")
        private MobileElement androidErrorMessage;

        @AndroidFindBy(id = "com.rentfly.app:id/passwordStrengthMeter")
        private MobileElement androidPasswordStrengthMeter;

        @AndroidFindBy(id = "com.rentfly.app:id/firstNameField")
        private MobileElement androidFirstNameField;

        @AndroidFindBy(id = "com.rentfly.app:id/lastNameField")
        private MobileElement androidLastNameField;

        @AndroidFindBy(id = "com.rentfly.app:id/emailField")
        private MobileElement androidEmailField;

        @AndroidFindBy(id = "com.rentfly.app:id/phoneField")
        private MobileElement androidPhoneField;

        @AndroidFindBy(id = "com.rentfly.app:id/countryCodeField")
        private MobileElement androidCountryCodeField;


        @iOSXCUITFindBy(accessibility = "privacyPolicyLink")
        private MobileElement iosPrivacyPolicyLink;

        @iOSXCUITFindBy(accessibility = "termsConditionsLink")
        private MobileElement iosTermsConditionsLink;

        @iOSXCUITFindBy(accessibility = "acceptButton")
        private MobileElement iosAcceptButton;

        @iOSXCUITFindBy(accessibility = "alreadyRegisteredButton")
        private MobileElement iosAlreadyRegisteredButton;

        @iOSXCUITFindBy(accessibility = "mobileNumberField")
        private MobileElement iosMobileNumberField;

        @iOSXCUITFindBy(accessibility = "passwordField")
        private MobileElement iosPasswordField;

        @iOSXCUITFindBy(accessibility = "confirmPasswordField")
        private MobileElement iosConfirmPasswordField;

        @iOSXCUITFindBy(accessibility = "showPasswordIcon")
        private MobileElement iosShowPasswordIcon;

        @iOSXCUITFindBy(accessibility = "registerButton")
        private MobileElement iosRegisterButton;

        @iOSXCUITFindBy(accessibility = "errorMessage")
        private MobileElement iosErrorMessage;

        @iOSXCUITFindBy(accessibility = "passwordStrengthMeter")
        private MobileElement iosPasswordStrengthMeter;

        @iOSXCUITFindBy(accessibility = "firstNameField")
        private MobileElement iosFirstNameField;

        @iOSXCUITFindBy(accessibility = "lastNameField")
        private MobileElement iosLastNameField;

        @iOSXCUITFindBy(accessibility = "emailField")
        private MobileElement iosEmailField;

        @iOSXCUITFindBy(accessibility = "phoneField")
        private MobileElement iosPhoneField;

        @iOSXCUITFindBy(accessibility = "countryCodeField")
        private MobileElement iosCountryCodeField;
    private MobileElement getPrivacyPolicyLink() {
        return driver instanceof AndroidDriver ? androidPrivacyPolicyLink : iosPrivacyPolicyLink;
    }

    private MobileElement getTermsConditionsLink() {
        return driver instanceof AndroidDriver ? androidTermsConditionsLink : iosTermsConditionsLink;
    }

    private MobileElement getAcceptButton() {
        return driver instanceof AndroidDriver ? androidAcceptButton : iosAcceptButton;
    }

    private MobileElement getAlreadyRegisteredButton() {
        return driver instanceof AndroidDriver ? androidAlreadyRegisteredButton : iosAlreadyRegisteredButton;
    }

    private MobileElement getMobileNumberField() {
        return driver instanceof AndroidDriver ? androidMobileNumberField : iosMobileNumberField;
    }

    private MobileElement getPasswordField() {
        return driver instanceof AndroidDriver ? androidPasswordField : iosPasswordField;
    }

    private MobileElement getConfirmPasswordField() {
        return driver instanceof AndroidDriver ? androidConfirmPasswordField : iosConfirmPasswordField;
    }

    private MobileElement getShowPasswordIcon() {
        return driver instanceof AndroidDriver ? androidShowPasswordIcon : iosShowPasswordIcon;
    }

    private MobileElement getRegisterButton() {
        return driver instanceof AndroidDriver ? androidRegisterButton : iosRegisterButton;
    }

    private MobileElement getErrorMessage() {
        return driver instanceof AndroidDriver ? androidErrorMessage : iosErrorMessage;
    }

    private MobileElement getPasswordStrengthMeter() {
        return driver instanceof AndroidDriver ? androidPasswordStrengthMeter : iosPasswordStrengthMeter;
    }

    private MobileElement getFirstNameField() {
        return driver instanceof AndroidDriver ? androidFirstNameField : iosFirstNameField;
    }

    private MobileElement getLastNameField() {
        return driver instanceof AndroidDriver ? androidLastNameField : iosLastNameField;
    }

    private MobileElement getEmailField() {
        return driver instanceof AndroidDriver ? androidEmailField : iosEmailField;
    }

    private MobileElement getPhoneField() {
        return driver instanceof AndroidDriver ? androidPhoneField : iosPhoneField;
    }

    private MobileElement getCountryCodeField() {
        return driver instanceof AndroidDriver ? androidCountryCodeField : iosCountryCodeField;
    }

    // Common Methods
    public boolean isPrivacyPolicyPageDisplayed() {
        return getPrivacyPolicyLink().isDisplayed();
    }

    public boolean isTermsConditionsPageDisplayed() {
        return getTermsConditionsLink().isDisplayed();
    }

    public void clickPrivacyPolicyLink() {
        getPrivacyPolicyLink().click();
    }

    public void clickTermsConditionsLink() {
        getTermsConditionsLink().click();
    }

    public void acceptPolicy() {
        getAcceptButton().click();
    }

    public void clickAlreadyRegisteredButton() {
        getAlreadyRegisteredButton().click();
    }

    public void enterMobileNumber(String mobileNumber) {
        getMobileNumberField().sendKeys(mobileNumber);
    }

    public void enterPassword(String password) {
        getPasswordField().sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        getConfirmPasswordField().sendKeys(confirmPassword);
    }

    public void clickShowPasswordIcon() {
        getShowPasswordIcon().click();
    }

    public void clickRegisterButton() {
        getRegisterButton().click();
    }

    public String isErrorMessageDisplayed() {
        return String.valueOf(getErrorMessage().isDisplayed());
    }

    public boolean isPasswordStrengthMeterDisplayed() {
        return getPasswordStrengthMeter().isDisplayed();
    }

    public void enterFirstName(String firstName) {
        getFirstNameField().sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        getLastNameField().sendKeys(lastName);
    }

    public void enterEmail(String email) {
        getEmailField().sendKeys(email);
    }

    public void enterPhone(String phone) {
        getPhoneField().sendKeys(phone);
    }

    public void enterCountryCode(String countryCode) {
        getCountryCodeField().sendKeys(countryCode);
    }
        }


