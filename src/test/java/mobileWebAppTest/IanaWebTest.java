package mobileWebAppTest;

import entities.PropertySets;
import hooks.Hooks;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import pageObject.IanaWebPage;

import static org.testng.Assert.assertEquals;

@Test(groups = "web")
public class IanaWebTest extends Hooks {

    private IanaWebPage ianaWebPage = new IanaWebPage(driver());

    protected IanaWebTest() throws Exception {
        super(PropertySets.WEB);
    }

    @Test(description = "Open website")
    public void webTest() throws Exception {
        int statusCode;
        statusCode = RestAssured.get(sut).statusCode();
        assertEquals(200, statusCode);

        //1. Open site
        ianaWebPage.open(sut, driverWait());

        //2. Check page Title
        ianaWebPage.checkPageTitle();

    }

}
