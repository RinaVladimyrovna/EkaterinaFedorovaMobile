package cloudApi;

import io.restassured.RestAssured;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RequestsToCloud {

    public static void installApplication(String appToInstall) {
        RestAssured.baseURI = "http://mobilecloud.epam.com";
        given().urlEncodingEnabled(true)
                .multiPart(new File(appToInstall))
                .header("Authorization", "Bearer 35156662-219f-4fa0-bc7d-03d9b1c2e229")
                .post("/automation/api/storage/install/92010481bcf335e3")
                .then().statusCode(201);
    }

}
