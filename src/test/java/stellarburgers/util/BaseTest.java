package stellarburgers.util;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stellarburgers.pages.MainPage;

import static org.junit.Assert.assertTrue;
import static stellarburgers.pages.MainPage.MAIN_PAGE_URL;
import static stellarburgers.pages.MainPage.PLACE_ORDER_BUTTON;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        driver = BrowserFactory.getDriver(browser);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(30));
        openMainPage();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    protected void openMainPage() {
        driver.get(MAIN_PAGE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MainPage.LOGIN_BUTTON));
        waitForModalOverlayToDisappear();
    }

    protected void waitForModalOverlayToDisappear() {
        By overlay = By.cssSelector(".Modal_modal_overlay__x2ZCr");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));
    }

    protected void assertPlaceOrderButtonDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PLACE_ORDER_BUTTON));
        assertTrue(
                "Кнопка 'Оформить заказ' не отображается после входа",
                driver.findElement(PLACE_ORDER_BUTTON).isDisplayed()
        );
    }
}