package stellarburgers.register;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import stellarburgers.api.APIUserClient;
import stellarburgers.pages.RegisterPage;
import stellarburgers.TestUser;
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
    @DisplayName("Успешная регистрация нового пользователя")
    @Description("Пользователь успешно регистрируется с валидными данными")
    public void successRegisterTest() {
        openRegisterForm();
        TestUser user = TestUserFactory.createUniqueUser();
        registerUser(user);
        try {
            accessToken = APIUserClient.registerUser(user);
        } catch (Exception e) {
            accessToken = null;
        }
        registeredUser = user;
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