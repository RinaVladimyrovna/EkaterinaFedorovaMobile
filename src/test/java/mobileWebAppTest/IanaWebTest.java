package mobileWebAppTest;

import entities.PropertySets;
import hooks.Hooks;
import io.restassured.RestAssured;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.IanaWebPage;

import static org.testng.Assert.assertEquals;

/**
 * Test to check browser work;
 * Be informed that default browser is used by default.
 * If you need chrome browser or others, please go to src/main/java/setup/DriverSetup.class
 * and src/main/java/entities/Browsers.class
 */
@Test(groups = "web")
public class IanaWebTest extends Hooks {

    private IanaWebPage ianaWebPage = new IanaWebPage(driver());

    @Parameters({"webPropertyFile"})
    protected IanaWebTest(String propertyFile) throws Exception {
        super(propertyFile);
    }

    @Test(description = "Open website")
    public void webTest() throws Exception {
        int statusCode;
        statusCode = RestAssured.get(sut).statusCode();
        assertEquals(200, statusCode);

        // Open site
        ianaWebPage.open(sut, driverWait());

        // Verify page Title
        ianaWebPage.checkPageTitle();

    }

}
