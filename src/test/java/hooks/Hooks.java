package hooks;

import cloudApi.RequestsToCloud;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import setup.DriverSetup;

import java.io.IOException;

public class Hooks extends DriverSetup {

    /**
     * Required variables will be initialized by inherited constructor
     *
     * @throws IOException
     */
    public Hooks(String set) throws IOException {
        super(set);
    }

    /**
     * Install app on device on farm.
     * Prepare driver for native app test on farm and inform me in console.
     */
    @BeforeSuite(groups = "native", description = "Prepare driver to run test(s)")
    public void setUpNativeFarm() throws Exception {
        RequestsToCloud.installApplication(aut);
        prepareDriver();
        System.out.println("Driver prepared");

    }

    /**
     * Prepare driver for web app test on farm and inform me in console.
     */
    @BeforeSuite(groups = "web", description = "Prepare driver to run test(s)")
    public void setUpWeb() throws Exception {
        prepareDriver();
        System.out.println("Driver prepared");

    }

    /**
     * Close driver and inform me in console.
     */
    @AfterSuite(groups = {"native", "web"}, description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }

}
