package pageObject;

import entities.WebConstants;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class IanaWebPage {

    private AppiumDriver driver;

    public IanaWebPage(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
    }

    public void open(String sut, WebDriverWait driverWait) {
        driver.get(sut);
        driverWait.until(ExpectedConditions.urlToBe(sut));
    }

    // Assert Title
    public void checkPageTitle() {
        assertEquals(driver.getTitle(), WebConstants.TITLE.toString());
    }

}
