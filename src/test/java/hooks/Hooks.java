package hooks;

import cloudApi.RequestsToCloud;
import entities.PropertySets;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.DriverSetup;

import java.io.IOException;

@Test(groups = {"native", "web"})
public class Hooks extends DriverSetup {


    /**
     * Required variables will be initialized by inherited constructor
     *
     * @throws IOException
     */
    public Hooks(PropertySets set) throws IOException {
        super(set);
    }

    /**
     * Prepare driver and inform me in console.
     */

    @BeforeSuite(description = "Prepare driver to run test(s)")
    public void setUp() throws Exception {
        RequestsToCloud.installApplication(aut);
        prepareDriver();
        System.out.println("Driver prepared");

    }

    /**
     * Close driver and inform me in console.
     */

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }

}
