package mobileNativeAppTest;

import hooks.Hooks;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.ContactManager;

/**
 * Test to check Contact Manager on Andtroid or iOS platform.
 */
@Test(groups = "native")
public class ContactManagerTest extends Hooks {

    @Parameters({"nativePropertyFile"})
    protected ContactManagerTest(String propertyFile) throws Exception {

        super(propertyFile);

    }

    @Test(description = "Open Add Contact screen and verify displayed elements")
    public void simplestAddContactScreenTest() throws Exception {

        ContactManager contactManager = new ContactManager(driver());

        // Open contact form
        contactManager.openContactForm();

        // Verify title
        contactManager.checkTitle();

        // Verify presence of Name field and Edit field
        contactManager.checkDisplayedElements();

    }

}
