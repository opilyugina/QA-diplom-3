package stellarburgers.register;

import io.qameta.allure.Step;
import stellarburgers.pages.LoginPage;
import stellarburgers.pages.MainPage;
import stellarburgers.pages.RegisterPage;
import stellarburgers.util.BaseTest;
import stellarburgers.TestUser;

public class RegisterSteps extends BaseTest {

    @Step("Открыть форму регистрации")
    protected void openRegisterForm() {
        openMainPage();
        new MainPage(driver).clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToRegister();
    }

    @Step("Заполнить и отправить форму регистрации")
    protected void registerUser(TestUser user) {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.setName(user.getName());
        registerPage.setEmail(user.getEmail());
        registerPage.setPassword(user.getPassword());
        registerPage.clickRegister();
    }
}