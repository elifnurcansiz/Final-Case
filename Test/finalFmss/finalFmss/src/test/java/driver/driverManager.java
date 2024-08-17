package driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.ios.IOSDriver;

public class driverManager {

    public static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> initializeDriver(String platform) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (platform.equalsIgnoreCase("android")) {
            capabilities.setCapability("appium:platformName", "Android");
            capabilities.setCapability("appium:platformVersion", "11");
            capabilities.setCapability("appium:automationName","UiAutomator2");
            capabilities.setCapability("appium:deviceName", "Pixel_7");

            capabilities.setCapability("appium:udid", "Android Emulator");
            capabilities.setCapability("appium:avd", "Pixel_6_Pro_API_32");


            capabilities.setCapability("appium:noReset", true); //false mu
            capabilities.setCapability("appium:app", "src/test/resources/applications/rentfly.apk");

            driver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/"), capabilities);


        } else if (platform.equalsIgnoreCase("ios")) {
            capabilities.setCapability("appium:platformName", "iOS");
            capabilities.setCapability("appium:automationName","XCUITest");
            capabilities.setCapability("appium:deviceName", "iPhone 14");

            capabilities.setCapability("appium:bundleId", "com.rentfly.app");
            capabilities.setCapability("appium:noReset", true);
            capabilities.setCapability("appium:app", "src/test/resources/applications/rentfly.apk");
            driver = new IOSDriver<>(new URL("http://127.0.0.1:4723"), capabilities);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}