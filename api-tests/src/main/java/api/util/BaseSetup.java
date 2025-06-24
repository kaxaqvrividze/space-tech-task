package api.util;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

import static api.util.Config.API_KEY;
import static api.util.Config.BASE_URI;

public class BaseSetup {

    @Before
    public void setUp() {

        RestAssured.baseURI = BASE_URI;
        RestAssured.requestSpecification = RestAssured
                .given()
                .header("x-api-key", API_KEY);
    }



}
