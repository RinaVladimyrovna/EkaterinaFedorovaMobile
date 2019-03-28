package entities;

public enum PropertyNames {

    AUT("aut"),
    SUT("sut"),
    TEST_PLATFORM("platform"),
    DRIVER("driver"),
    DEVICE("deviceName"),
    DRIVER_PATH("driverPath");

    private String propertyName;

    PropertyNames(String propertyName) {
        this.propertyName = propertyName;
    }

    @Override
    public String toString() {
        return propertyName;
    }

}
