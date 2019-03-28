package entities;

public enum Browsers {

    FIREFOX("Firefox"),
    CHROME("Chrome"),
    DEFAULT("Browser"),
    SAFARI("Safari");

    public String browser;

    Browsers(String browser) {
        this.browser = browser;
    }

    @Override
    public String toString() {
        return browser;
    }

}
