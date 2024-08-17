package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import pages.*;

public class passwordResetPage {

    private AppiumDriver<MobileElement> driver;

    public passwordResetPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for Android
    @AndroidFindBy(id = "com.rentfly.android:id/email_field")
    private MobileElement emailFieldAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/reset_button")
    private MobileElement resetButtonAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/error_message")
    private MobileElement errorMessageAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/expired_link_message")
    private MobileElement expiredLinkMessageAndroid;

    @AndroidFindBy(id = "com.rentfly.android:id/success_message")
    private MobileElement successMessageAndroid;

    // Locators for iOS
    @iOSXCUITFindBy(accessibility = "email_field")
    private MobileElement emailFieldiOS;

    @iOSXCUITFindBy(accessibility = "reset_button")
    private MobileElement resetButtoniOS;

    @iOSXCUITFindBy(accessibility = "error_message")
    private MobileElement errorMessageiOS;

    @iOSXCUITFindBy(accessibility = "expired_link_message")
    private MobileElement expiredLinkMessageiOS;

    @iOSXCUITFindBy(accessibility = "success_message")
    private MobileElement successMessageiOS;

    // Method to enter email
    public void enterEmail(String email) {
        if (isAndroid()) {
            emailFieldAndroid.sendKeys(email);
        } else {
            emailFieldiOS.sendKeys(email);
        }
    }

    // Method to click the reset button
    public void clickResetButton() {
        if (isAndroid()) {
            resetButtonAndroid.click();
        } else {
            resetButtoniOS.click();
        }
    }

    // Method to check for error message
    public String getErrorMessage() {
        if (isAndroid()) {
            return errorMessageAndroid.getText();
        } else {
            return errorMessageiOS.getText();
        }
    }

    // Method to check for expired link message
    public String getExpiredLinkMessage() {
        if (isAndroid()) {
            return expiredLinkMessageAndroid.getText();
        } else {
            return expiredLinkMessageiOS.getText();
        }
    }

    // Method to check for success message
    public String getSuccessMessage() {
        if (isAndroid()) {
            return successMessageAndroid.getText();
        } else {
            return successMessageiOS.getText();
        }
    }

    // Platform check
    private boolean isAndroid() {
        return driver.getPlatformName().equalsIgnoreCase("Android");
    }
}
