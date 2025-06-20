package stellarburgers.login;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@DisplayName("Тесты авторизации")
public class LoginTests extends LoginSteps {

    @Test
    @DisplayName("Вход через главную страницу")
    @Description("Проверка входа через кнопку 'Войти в аккаунт' на главной странице")
    public void loginViaMainPageButtonTest() {
        openLoginFormFromMain();
    }

    @Test
    @DisplayName("Вход через 'Личный кабинет'")
    @Description("Проверка входа через кнопку 'Личный кабинет'")
    public void loginViaPersonalCabinetButtonTest() {
        openLoginFormFromPersonalCabinet();
    }

    @Test
    @DisplayName("Вход через ссылку 'Войти' в регистрации")
    @Description("Проверка входа через ссылку 'Войти' на странице регистрации")
    public void loginViaRegisterFormButtonTest() {
        openLoginFormViaRegister();
    }

    @Test
    @DisplayName("Вход через ссылку 'Войти' в восстановлении пароля")
    @Description("Проверка входа через ссылку 'Войти' на странице восстановления пароля")
    public void loginViaForgotPasswordFormButtonTest() {
        openLoginFormViaForgotPassword();
    }
}