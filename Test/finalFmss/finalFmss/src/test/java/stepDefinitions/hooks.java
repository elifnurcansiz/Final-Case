package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import driver.driverManager;
import java.net.MalformedURLException;

public class hooks {

    @Before
    public void setUp() throws MalformedURLException {
        driverManager.initializeDriver("android");
    }

    @After
    public void tearDown() {
        if (driverManager.driver != null) {
            driverManager.driver.quit();
        }
    }

}