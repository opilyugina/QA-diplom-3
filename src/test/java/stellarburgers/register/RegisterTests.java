package stellarburgers.register;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import stellarburgers.TestUser;
import stellarburgers.api.APIUserClient;
import stellarburgers.pages.RegisterPage;
import stellarburgers.util.TestUserFactory;

import static org.junit.Assert.*;

@DisplayName("Тесты регистрации")
public class RegisterTests extends RegisterSteps {
    private TestUser registeredUser;
    private String accessToken;

    @After
    public void cleanUp() {
        if (accessToken != null) {
            APIUserClient.deleteUser(accessToken);
        }
    }

    @Test
    public void successRegisterTest() {
        openRegisterForm();

        TestUser user = TestUserFactory.createUniqueUser();
        registerUser(user);
        registeredUser = user;

        Response loginResponse = APIUserClient.loginUser(user);

        Assert.assertEquals("Не удалось авторизоваться под только что зарегистрированным пользователем",
                200, loginResponse.getStatusCode());

        accessToken = loginResponse.jsonPath().getString("accessToken");
        Assert.assertNotNull("Access token не был получен после авторизации", accessToken);

        String responseEmail = loginResponse.jsonPath().getString("user.email");
        Assert.assertEquals("Email в ответе не совпадает с email зарегистрированного пользователя",
                user.getEmail().toLowerCase(), responseEmail.toLowerCase());
    }

    @Test
    @DisplayName("Ошибка при коротком пароле")
    @Description("Появляется ошибка при вводе слишком короткого пароля")
    public void errorShortPasswordTest() {
        openRegisterForm();
        TestUser user = TestUserFactory.createShortPasswordUser();
        registerUser(user);
        String error = new RegisterPage(driver).getErrorMessage();
        assertTrue("Ожидается ошибка о некорректном пароле", error.contains("Некорректный пароль"));
    }
}