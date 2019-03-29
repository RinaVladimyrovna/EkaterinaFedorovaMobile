package entities;

/**
 * Just a title made as a constant
 */

public enum WebConstants {

    TITLE("Internet Assigned Numbers Authority");

    public String constant;

    WebConstants(String constant) {
        this.constant = constant;
    }

    @Override
    public String toString() {
        return constant;
    }

}
