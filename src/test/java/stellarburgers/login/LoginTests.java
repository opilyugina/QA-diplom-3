package stellarburgers.login;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import stellarburgers.pages.LoginPage;

import static org.junit.Assert.assertTrue;

@DisplayName("Тесты авторизации")
public class LoginTests extends LoginSteps {

    @Test
    @DisplayName("Вход через главную страницу")
    @Description("Проверка открытия формы входа через кнопку 'Войти в аккаунт' на главной странице")
    public void loginViaMainPageButtonTest() {
        openLoginFormFromMain();
        LoginPage loginPage = new LoginPage(driver);
        assertTrue("Форма логина не открылась", loginPage.isLoginButtonVisible());
    }

    @Test
    @DisplayName("Вход через 'Личный кабинет'")
    @Description("Проверка открытия формы входа через кнопку 'Личный кабинет'")
    public void loginViaPersonalCabinetButtonTest() {
        openLoginFormFromPersonalCabinet();
        LoginPage loginPage = new LoginPage(driver);
        assertTrue("Форма логина не открылась", loginPage.isLoginButtonVisible());
    }

    @Test
    @DisplayName("Вход через ссылку 'Войти' в регистрации")
    @Description("Проверка перехода на форму входа со страницы регистрации")
    public void loginViaRegisterFormButtonTest() {
        openLoginFormViaRegister();
        LoginPage loginPage = new LoginPage(driver);
        assertTrue("Форма логина не открылась", loginPage.isLoginButtonVisible());
    }

    @Test
    @DisplayName("Вход через ссылку 'Войти' в восстановлении пароля")
    @Description("Проверка перехода на форму входа со страницы восстановления пароля")
    public void loginViaForgotPasswordFormButtonTest() {
        openLoginFormViaForgotPassword();
        LoginPage loginPage = new LoginPage(driver);
        assertTrue("Форма логина не открылась", loginPage.isLoginButtonVisible());
    }
}