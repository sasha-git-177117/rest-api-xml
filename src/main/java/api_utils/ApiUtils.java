package api_utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtils {

    public static Response getResponse(String url) {
        return RestAssured.get(url)
                .then()
                .extract()
                .response();
    }

}
