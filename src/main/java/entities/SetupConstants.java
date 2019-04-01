package entities;

public enum SetupConstants {

    DRIVER_PREFIX("http://EPM-TSTF:"),
    DRIVER_POSTFIX("@mobilecloud.epam.com:8080/wd/hub");

    public String constant;

    SetupConstants(String constant) {
        this.constant = constant;
    }

    @Override
    public String toString() {
        return constant;
    }

}
