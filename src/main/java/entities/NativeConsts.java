package entities;

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
