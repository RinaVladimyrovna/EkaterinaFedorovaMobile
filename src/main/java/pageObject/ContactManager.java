package pageObject;

import entities.NativeConsts;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


import static org.testng.Assert.assertTrue;

public class ContactManager {

    private AppiumDriver driver;

    private String base = NativeConsts.SELECTOR_BASE.toString();
    private By title = By.id("android:id/title");
    private By addButton = By.id(base + "addContactButton");
    private By nameField = By.id(base + "contactNameEditText");
    private By editField = By.id(base + "contactPhoneEditText");

    public ContactManager(AppiumDriver driver) {
        this.driver = driver;
    }

    public void openContactForm() {
        driver.findElement(addButton).click();
    }

    public void checkTitle() {
        assertTrue(driver.findElement(title).isDisplayed());
    }

    public void checkDisplayedElements() {
        assertTrue(driver.findElement(nameField).isDisplayed());
        assertTrue(driver.findElement(editField).isDisplayed());
    }

}
