package stellarburgers.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import stellarburgers.TestUser;

import static io.restassured.RestAssured.given;

public class APIUserClient {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api/auth";

    public static String registerUser(TestUser user) {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(user)
                .post(BASE_URL + "/register");
        if (response.statusCode() == 200 && response.jsonPath().getBoolean("success")) {
            return response.jsonPath().getString("accessToken");
        }
        throw new RuntimeException("Не удалось создать пользователя через API: " + response.asString());
    }

    public static void deleteUser(String accessToken) {
        given()
                .header("Authorization", accessToken)
                .delete(BASE_URL + "/user")
                .then()
                .statusCode(202);
    }
}