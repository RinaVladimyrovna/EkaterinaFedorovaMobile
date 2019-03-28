package entities;

public enum PropertySets {

    /**
     * One can select a property set according to application type
     */
    NATIVE("src/main/resources/properties/native.properties"),
    WEB("src/main/resources/properties/web.properties"),
    IOS_NATIVE("src/main/resources/properties/nativeIos.properties"),
    IOS_WEB("src/main/resources/properties/webIos.properties");

    private String propertySet;

    PropertySets(String propertySet) {
        this.propertySet = propertySet;
    }

    @Override
    public String toString() {
        return propertySet;
    }

}
