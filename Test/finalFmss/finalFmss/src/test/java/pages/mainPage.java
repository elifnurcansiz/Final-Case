package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import pages.*;

public class mainPage {

    private AppiumDriver<MobileElement> driver;

    // Constructor
    public mainPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for Android

    @AndroidFindBy(id = "com.rentfly.android:id/page_title")
    private MobileElement pageTitleAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/page_content")
    private MobileElement pageContentAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/privacy_policy_link")
    private MobileElement privacyPolicyLinkAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/terms_and_conditions_link")
    private MobileElement termsAndConditionsLinkAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/support_link")
    private MobileElement supportLinkAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/language_dropdown")
    private MobileElement languageDropdownAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/register_with_email_button")
    private MobileElement registerWithEmailButtonAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/personal_button")
    private MobileElement personalButtonAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/business_button")
    private MobileElement businessButtonAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/sign_in_with_google_button")
    private MobileElement signInWithGoogleButtonAndroid;

    // Locators for iOS

    @iOSXCUITFindBy(accessibility = "page_title")
    private MobileElement pageTitleiOS;

    @iOSXCUITFindBy(accessibility = "page_content")
    private MobileElement pageContentiOS;

    @iOSXCUITFindBy(accessibility = "privacy_policy_link")
    private MobileElement privacyPolicyLinkiOS;

    @iOSXCUITFindBy(accessibility = "terms_and_conditions_link")
    private MobileElement termsAndConditionsLinkiOS;

    @iOSXCUITFindBy(accessibility = "support_link")
    private MobileElement supportLinkiOS;

    @iOSXCUITFindBy(accessibility = "language_dropdown")
    private MobileElement languageDropdowniOS;

    @iOSXCUITFindBy(accessibility = "register_with_email_button")
    private MobileElement registerWithEmailButtoniOS;

    @iOSXCUITFindBy(accessibility = "personal_button")
    private MobileElement personalButtoniOS;

    @iOSXCUITFindBy(accessibility = "business_button")
    private MobileElement businessButtoniOS;

    @iOSXCUITFindBy(accessibility = "sign_in_with_google_button")
    private MobileElement signInWithGoogleButtoniOS;

    // Methods to interact with the page elements

    // Click a link in the footer
    public void clickFooterLink(String linkText) {
        if (isAndroid()) {
            switch (linkText) {
                case "Privacy Policy":
                    privacyPolicyLinkAndroid.click();
                    break;
                case "Terms and Conditions":
                    termsAndConditionsLinkAndroid.click();
                    break;
                case "Support":
                    supportLinkAndroid.click();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid link text: " + linkText);
            }
        } else {
            switch (linkText) {
                case "Privacy Policy":
                    privacyPolicyLinkiOS.click();
                    break;
                case "Terms and Conditions":
                    termsAndConditionsLinkiOS.click();
                    break;
                case "Support":
                    supportLinkiOS.click();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid link text: " + linkText);
            }
        }
    }



    // Select a language from the dropdown
    public void clickLanguageDropdown() {
        if (isAndroid()) {
            languageDropdownAndroid.click();
        } else {
            languageDropdowniOS.click();
        }
    }

    // Select a language from the dropdown based on the language name
    public void selectLanguage(String language) {
        if (isAndroid()) {
            driver.findElementByXPath("//android.widget.TextView[@text='" + language + "']").click();
        } else {
            driver.findElementByXPath("//XCUIElementTypeStaticText[@name='" + language + "']").click();
        }
    }


    public boolean isPageTitleDisplayed(String expectedTitle) {
        MobileElement titleElement = isAndroid() ? pageTitleAndroid : pageTitleiOS;
        return titleElement.isDisplayed() && titleElement.getText().equals(expectedTitle);
    }

    // Method to check if the page content is displayed in French
    public boolean isPageContentInFrench() {
        MobileElement contentElement = isAndroid() ? pageContentAndroid : pageContentiOS;
        return contentElement.isDisplayed() && contentElement.getText().contains("français");
    }

    // Method to check if a button is present
    public boolean isButtonPresent(String buttonName) {
        switch (buttonName) {
            case "Personal":
                return (isAndroid() ? personalButtonAndroid : personalButtoniOS).isDisplayed();
            case "Business":
                return (isAndroid() ? businessButtonAndroid : businessButtoniOS).isDisplayed();
            default:
                throw new IllegalArgumentException("Invalid button name: " + buttonName);
        }
    }


    // Click the "Sign in with Google" button
    public void clickGoogleSignInButton() {
        if (isAndroid()) {
            signInWithGoogleButtonAndroid.click();
        } else {
            signInWithGoogleButtoniOS.click();
        }
    }

    // Click the "Register with Email" button
    public void clickRegisterWithEmailButton() {
        if (isAndroid()) {
            registerWithEmailButtonAndroid.click();
        } else {
            registerWithEmailButtoniOS.click();
        }
    }

    // Click the "Individual" option on the Account Type screen
    public void clickIndividualOption() {
        if (isAndroid()) {
            personalButtonAndroid.click();
        } else {
            personalButtoniOS.click();
        }
    }

    // Click the "Business" option on the Account Type screen
    public void clickBusinessOption() {
        if (isAndroid()) {
            businessButtonAndroid.click();
        } else {
            businessButtoniOS.click();
        }
    }

    // Platform check
    private boolean isAndroid() {
        return driver.getPlatformName().equalsIgnoreCase("Android");
    }
    public boolean isMessageDisplayed(String message) {
        if (isAndroid()) {
            return driver.findElementByXPath("//android.widget.TextView[@text='" + message + "']").isDisplayed();
        } else {
            return driver.findElementByXPath("//XCUIElementTypeStaticText[@name='" + message + "']").isDisplayed();
        }
    }
}
