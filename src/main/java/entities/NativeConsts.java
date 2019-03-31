package entities;

/**
 * Just a selector's base part made as a constant
 */
public enum NativeConsts {

    SELECTOR_BASE("com.example.android.contactmanager:id/");

    public String constant;

    NativeConsts(String constant) {
        this.constant = constant;
    }

    @Override
    public String toString() {
        return constant;
    }

}
