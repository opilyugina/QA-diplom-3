package stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final By LOGIN_BUTTON = By.xpath("//button[text()='Войти в аккаунт']");
    public static final By PERSONAL_CABINET_BUTTON = By.xpath("//p[text()='Личный Кабинет']");
    public static final By CONSTRUCTOR_BUTTON = By.xpath("//p[text()='Конструктор']");
    public static final By MODAL_OVERLAY = By.cssSelector(".Modal_modal_overlay__x2ZCr");
    public static final By PLACE_ORDER_BUTTON = By.xpath("//button[contains(text(),'Оформить заказ')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private void waitForModalOverlayToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(MODAL_OVERLAY));
    }

    @Step("Клик по кнопке 'Войти в аккаунт'")
    public void clickLoginButton() {
        waitVisible(LOGIN_BUTTON);
        waitForModalOverlayToDisappear();
        click(LOGIN_BUTTON);
    }

    @Step("Клик по кнопке 'Личный кабинет'")
    public void clickPersonalCabinet() {
        waitVisible(PERSONAL_CABINET_BUTTON);
        waitForModalOverlayToDisappear();
        click(PERSONAL_CABINET_BUTTON);
    }

    @Step("Клик по кнопке 'Конструктор'")
    public void clickConstructor() {
        waitVisible(CONSTRUCTOR_BUTTON);
        waitForModalOverlayToDisappear();
        click(CONSTRUCTOR_BUTTON);
    }
}