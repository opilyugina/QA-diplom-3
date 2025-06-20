package stellarburgers.login;

import io.qameta.allure.Step;
import stellarburgers.pages.LoginPage;
import stellarburgers.pages.MainPage;
import stellarburgers.pages.RegisterPage;
import stellarburgers.util.BaseTest;

public class LoginSteps extends BaseTest {

    @Step("Открыть форму логина через главную")
    protected void openLoginFormFromMain() {
        openMainPage();
        new MainPage(driver).clickLoginButton();
    }

    @Step("Открыть форму логина через Личный кабинет")
    protected void openLoginFormFromPersonalCabinet() {
        openMainPage();
        new MainPage(driver).clickPersonalCabinet();
    }

    @Step("Открыть форму логина через регистрацию")
    protected void openLoginFormViaRegister() {
        openLoginFormFromMain();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToRegister();
        new RegisterPage(driver).clickLoginViaLink();
    }

    @Step("Открыть форму логина через восстановление пароля")
    protected void openLoginFormViaForgotPassword() {
        openLoginFormFromMain();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToForgotPassword();
        new RegisterPage(driver).clickLoginViaLink();
    }
}