package entities;

public enum Warnings {

    UNKNOWN_PLATFORM("Unknown mobile platform"),
    UNCLEAR_TYPE("Unclear type of mobile app");

    public String warning;

    Warnings(String warning) {
        this.warning = warning;
    }

    @Override
    public String toString() {
        return warning;
    }

}
