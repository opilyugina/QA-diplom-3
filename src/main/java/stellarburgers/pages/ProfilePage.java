package stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage {
    public static final By EXIT_BUTTON = By.xpath("//button[text()='Выход']");
    public static final By CONSTRUCTOR_BUTTON = By.xpath("//p[text()='Конструктор']");
    public static final By LOGO_BUTTON = By.xpath("//div[contains(@class,'AppHeader_header__logo')]");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по кнопке 'Выход'")
    public void clickExit() {
        waitVisible(EXIT_BUTTON);
        click(EXIT_BUTTON);
    }

    @Step("Клик по кнопке 'Конструктор'")
    public void clickConstructor() {
        waitVisible(CONSTRUCTOR_BUTTON);
        click(CONSTRUCTOR_BUTTON);
    }

    @Step("Клик по логотипу Stellar Burgers")
    public void clickLogo() {
        waitVisible(LOGO_BUTTON);
        click(LOGO_BUTTON);
    }
}