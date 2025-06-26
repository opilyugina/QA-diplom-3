package stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    public static final By NAME_INPUT = By.xpath("//label[contains(text(),'Имя')]/following-sibling::input");
    public static final By EMAIL_INPUT = By.xpath("//label[contains(text(),'Email')]/following-sibling::input");
    public static final By PASSWORD_INPUT = By.xpath("//label[contains(text(),'Пароль')]/following-sibling::input");
    public static final By REGISTER_BUTTON = By.xpath("//button[text()='Зарегистрироваться']");
    public static final By ERROR_MESSAGE = By.xpath("//p[contains(@class,'input__error')]");
    public static final By LOGIN_LINK = By.linkText("Войти");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод имени: {name}")
    public void setName(String name) {
        waitVisible(NAME_INPUT);
        type(NAME_INPUT, name);
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

    @Step("Клик по кнопке 'Зарегистрироваться'")
    public void clickRegister() {
        waitVisible(REGISTER_BUTTON);
        click(REGISTER_BUTTON);
    }

    @Step("Получить текст ошибки")
    public String getErrorMessage() {
        if (isVisible(ERROR_MESSAGE)) {
            return getText(ERROR_MESSAGE);
        }
        return "";
    }

    @Step("Переход к форме логина через ссылку 'Войти'")
    public void clickLoginViaLink() {
        waitVisible(LOGIN_LINK);
        click(LOGIN_LINK);
    }
}