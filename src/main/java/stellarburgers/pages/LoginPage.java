package stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public static final By EMAIL_INPUT = By.xpath("//label[contains(text(),'Email')]/following-sibling::input");
    public static final By PASSWORD_INPUT = By.xpath("//label[contains(text(),'Пароль')]/following-sibling::input");
    public static final By LOGIN_BUTTON = By.cssSelector("button.button_button_type_primary__1O7Bx");
    public static final By REGISTER_LINK = By.linkText("Зарегистрироваться");
    public static final By FORGOT_PASSWORD_LINK = By.linkText("Восстановить пароль");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод e-mail: {email}")
    public void setEmail(String email) {
        waitVisible(EMAIL_INPUT);
        type(EMAIL_INPUT, email);
    }

    @Step("Ввод пароля: {password}")
    public void setPassword(String password) {
        waitVisible(PASSWORD_INPUT);
        type(PASSWORD_INPUT, password);
    }

    @Step("Клик по кнопке входа")
    public void clickLoginButton() {
        waitVisible(LOGIN_BUTTON);
        click(LOGIN_BUTTON);
    }

    @Step("Переход на форму регистрации")
    public void goToRegister() {
        waitVisible(REGISTER_LINK);
        click(REGISTER_LINK);
    }

    @Step("Переход на форму восстановления пароля")
    public void goToForgotPassword() {
        waitVisible(FORGOT_PASSWORD_LINK);
        click(FORGOT_PASSWORD_LINK);
    }

    public boolean isLoginButtonVisible() {
        return isVisible(LOGIN_BUTTON);
    }
}