package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pages.*;

public class loginPage {

    private AppiumDriver<MobileElement> driver;

    // Constructor
    public loginPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for Android
    @AndroidFindBy(id = "com.rentfly.android:id/forgot_password_link")
    private MobileElement forgotPasswordLinkAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/sign_in_with_google_button")
    private MobileElement signInWithGoogleButtonAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/create_account_button")
    private MobileElement createAccountButtonAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/individual_option")
    private MobileElement individualOptionAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/remember_me_checkbox")
    private MobileElement rememberMeCheckboxAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/sign_in_button")
    private MobileElement signInButtonAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/login_with_facebook")
    private MobileElement loginWithFacebookAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/login_with_twitter")
    private MobileElement loginWithTwitterAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/audit_log_entry")
    private MobileElement auditLogEntryAndroid;

    // Locators for iOS
    @iOSXCUITFindBy(accessibility = "forgot_password_link")
    private MobileElement forgotPasswordLinkiOS;

    @iOSXCUITFindBy(accessibility = "sign_in_with_google_button")
    private MobileElement signInWithGoogleButtoniOS;

    @iOSXCUITFindBy(accessibility = "create_account_button")
    private MobileElement createAccountButtoniOS;

    @iOSXCUITFindBy(accessibility = "individual_option")
    private MobileElement individualOptioniOS;

    @iOSXCUITFindBy(accessibility = "remember_me_checkbox")
    private MobileElement rememberMeCheckboxiOS;

    @iOSXCUITFindBy(accessibility = "sign_in_button")
    private MobileElement signInButtoniOS;

    @iOSXCUITFindBy(accessibility = "login_with_facebook")
    private MobileElement loginWithFacebookiOS;

    @iOSXCUITFindBy(accessibility = "login_with_twitter")
    private MobileElement loginWithTwitteriOS;

    @iOSXCUITFindBy(accessibility = "audit_log_entry")
    private MobileElement auditLogEntryiOS;

    // Click element on login page
    public void clickElement(String elementName) {
        if (isAndroid()) {
            switch (elementName) {
                case "Forgot password?":
                    forgotPasswordLinkAndroid.click();
                    break;
                case "Sign in with Google":
                    signInWithGoogleButtonAndroid.click();
                    break;
                case "Create an account":
                    createAccountButtonAndroid.click();
                    break;
                case "Remember me":
                    rememberMeCheckboxAndroid.click();
                    break;
                case "Sign in":
                    signInButtonAndroid.click();
                    break;
                case "Login with Facebook":
                    loginWithFacebookAndroid.click();
                    break;
                case "Login with Twitter":
                    loginWithTwitterAndroid.click();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid element name: " + elementName);
            }
        } else {
            switch (elementName) {
                case "Forgot password?":
                    forgotPasswordLinkiOS.click();
                    break;
                case "Sign in with Google":
                    signInWithGoogleButtoniOS.click();
                    break;
                case "Create an account":
                    createAccountButtoniOS.click();
                    break;
                case "Remember me":
                    rememberMeCheckboxiOS.click();
                    break;
                case "Sign in":
                    signInButtoniOS.click();
                    break;
                case "Login with Facebook":
                    loginWithFacebookiOS.click();
                    break;
                case "Login with Twitter":
                    loginWithTwitteriOS.click();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid element name: " + elementName);
            }
        }
    }

    // Enter text into an input field
    public void enterText(String elementName, String text) {
        if (isAndroid()) {
            switch (elementName) {
                case "Email":
                    MobileElement emailFieldAndroid = driver.findElementById("com.rentfly.android:id/email_input");
                    emailFieldAndroid.sendKeys(text);
                    break;
                case "Password":
                    MobileElement passwordFieldAndroid = driver.findElementById("com.rentfly.android:id/password_input");
                    passwordFieldAndroid.sendKeys(text);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid element name: " + elementName);
            }
        } else {
            switch (elementName) {
                case "Email":
                    MobileElement emailFieldiOS = driver.findElementByAccessibilityId("email_input");
                    emailFieldiOS.sendKeys(text);
                    break;
                case "Password":
                    MobileElement passwordFieldiOS = driver.findElementByAccessibilityId("password_input");
                    passwordFieldiOS.sendKeys(text);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid element name: " + elementName);
            }
        }
    }

    // Verify audit log entry
    public boolean isAuditLogEntryPresent(String email, String ipAddress) {
        if (isAndroid()) {
            return driver.findElementById("com.rentfly.android:id/audit_log_entry")
                    .getText().contains(email) && driver.findElementById("com.rentfly.android:id/audit_log_entry")
                    .getText().contains(ipAddress);
        } else {
            return driver.findElementByAccessibilityId("audit_log_entry")
                    .getText().contains(email) && driver.findElementByAccessibilityId("audit_log_entry")
                    .getText().contains(ipAddress);
        }
    }
    // Verify title
    public boolean isTitleDisplayed(String title) {
        if (isAndroid()) {
            try {
                MobileElement titleElement = driver.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", title)));
                return titleElement.isDisplayed();
            } catch (Exception e) {
                return false;
            }
        } else {
            try {
                MobileElement titleElement = driver.findElement(By.xpath(String.format("//XCUIElementTypeStaticText[@name='%s']", title)));
                return titleElement.isDisplayed();
            } catch (Exception e) {
                return false;
            }
        }
    }

    // Platform check
    private boolean isAndroid() {
        return driver.getPlatformName().equalsIgnoreCase("Android");

    }
}

