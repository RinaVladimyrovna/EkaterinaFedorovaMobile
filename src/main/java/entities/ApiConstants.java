package entities;

public enum ApiConstants {

    BASE_URL("http://mobilecloud.epam.com"),
    RESERVE_URL("/automation/api/device/"),
    INSTALL_URL("/automation/api/storage/install/"),
    AUTH_HEADER("Authorization"),
    CONTANT_TYPE_HEADER("Content-Type"),
    AUTH_HEADER_PREVALUE("Bearer "),
    CONTACT_TYPE_HEADER_VALUE("application/json");


    public String constant;

    ApiConstants(String constant) {
        this.constant = constant;
    }

    @Override
    public String toString() {
        return constant;
    }

}
