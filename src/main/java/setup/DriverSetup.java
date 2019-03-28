package setup;

import entities.Browsers;
import entities.PropertyNames;
import entities.PropertySets;
import entities.Warnings;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class DriverSetup extends TestProperties {

    /**
     * Initialize a driver with test properties
     */

    private static AppiumDriver driver;
    protected DesiredCapabilities capabilities;
    private static WebDriverWait wait;

    protected String aut;
    protected String sut;
    protected String testPlatform;
    protected String propertyDriver;
    protected String device;

    // Constructor initializes properties on driver creation
    protected DriverSetup(PropertySets set) throws IOException {
        super(set);
        aut = getProp(PropertyNames.AUT.toString());
        sut = getProp(PropertyNames.SUT.toString());
        testPlatform = getProp(PropertyNames.TEST_PLATFORM.toString());
        propertyDriver = getProp(PropertyNames.DRIVER.toString());
        device = getProp(PropertyNames.DEVICE.toString());
    }

    /**
     * Initialize driver with appropriate capabilities depending on platform and application
     *
     * @throws Exception
     */

    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;
        // Setup test platform: Android or iOS. Browser also depends on a platform.
        if ("Android".equals(testPlatform)) {
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
            capabilities.setCapability("chromedriverExecutable", System.getProperty("user.dir") + getProp(PropertyNames.DRIVER_PATH.toString()));
            browserName = Browsers.DEFAULT.toString();

        } else if ("iOS".equals(testPlatform)) {
            browserName = Browsers.SAFARI.toString();

        } else {
            throw new Exception(Warnings.UNKNOWN_PLATFORM.toString());
        }

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, testPlatform);

        // Setup type of application: mobile, web (or hybrid)
        if (aut != null && sut == null) {
            // Native
            File app = new File(aut);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else if (sut != null && aut == null) {
            // Web
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception(Warnings.UNCLEAR_TYPE.toString());
        }

        if (driver == null) {
            driver = new AppiumDriver(new URL(propertyDriver), capabilities);
        }

        if (wait == null) {
            wait = new WebDriverWait(driver(), 10);
        }

    }

    protected AppiumDriver driver() throws Exception {
        if (driver == null) prepareDriver();
        return driver;
    }

    protected WebDriverWait driverWait() throws Exception {
        return wait;
    }

}
