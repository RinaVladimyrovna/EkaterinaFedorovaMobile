package entities;

/**
 * These are used to take off hardcoded values of code.
 * It is better to rearrange code a bit and use reflection.
 */

public enum PropertyNames {

    AUT("aut"),
    SUT("sut"),
    TEST_PLATFORM("platform"),
    DRIVER("driver"),
    DEVICE("deviceName"),
    DRIVER_PATH("driverPath"),
    PACKAGE("appPackage"),
    ACTIVITY("appActivity");

    private String propertyName;

    PropertyNames(String propertyName) {
        this.propertyName = propertyName;
    }

    @Override
    public String toString() {
        return propertyName;
    }

}
