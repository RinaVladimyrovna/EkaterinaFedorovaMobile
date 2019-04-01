package cloudApi;

import entities.ApiConstants;
import io.restassured.RestAssured;

import java.io.File;

import static entities.ApiConstants.*;
import static io.restassured.RestAssured.given;

public class RequestsToCloud {

    public static void installApplication(String appToInstall, String serial, String token) {
        RestAssured.baseURI = BASE_URL.toString();
        given().urlEncodingEnabled(true)
                .multiPart(new File(appToInstall))
                .header(AUTH_HEADER.toString(), AUTH_HEADER_PREVALUE.toString() + token)
                .post(INSTALL_URL.toString() + serial)
                .then().statusCode(201);
    }

    public static void reserveDeviceBySerial(String serial, String token) {
        RestAssured.baseURI = BASE_URL.toString();
        given().urlEncodingEnabled(true)
                .header(AUTH_HEADER.toString(), AUTH_HEADER_PREVALUE.toString() + token)
                .header(CONTANT_TYPE_HEADER.toString(), CONTACT_TYPE_HEADER_VALUE.toString())
                .post(RESERVE_URL.toString() + serial)
                .then().statusCode(200);
    }

}
