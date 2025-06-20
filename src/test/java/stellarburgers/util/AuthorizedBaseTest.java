package stellarburgers.util;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stellarburgers.api.APIUserClient;
import stellarburgers.TestUser;

public abstract class AuthorizedBaseTest extends BaseTest {
    protected TestUser testUser;
    protected String accessToken;

    @Before
    public void setUp() {
        super.setUp();
        testUser = TestUserFactory.createUniqueUser();
        accessToken = APIUserClient.registerUser(testUser);
        loginViaUI();
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            APIUserClient.deleteUser(accessToken);
            accessToken = null;
        }
        super.tearDown();
    }

    protected void loginViaUI() {
        driver.get("https://stellarburgers.nomoreparties.site/login");

        By emailInput = By.xpath("//label[contains(text(),'Email')]/following-sibling::input");
        By passwordInput = By.xpath("//label[contains(text(),'Пароль')]/following-sibling::input");
        By loginButton = By.xpath("//button[text()='Войти']");

        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(emailInput));
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(testUser.getEmail());

        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(passwordInput));
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(testUser.getPassword());

        WebElement button = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(loginButton));
        button.click();

        assertPlaceOrderButtonDisplayed();
    }
}