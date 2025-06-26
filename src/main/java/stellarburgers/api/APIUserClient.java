package stellarburgers.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import stellarburgers.TestUser;

import static io.restassured.RestAssured.given;

public class APIUserClient {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/auth";

    public static Response registerUser(TestUser user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .post(BASE_URL + "/register");
    }

    public static Response deleteUser(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .delete(BASE_URL + "/user");
    }

    public static Response loginUser(TestUser user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .post(BASE_URL + "/login");
    }
}