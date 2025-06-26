package stellarburgers.util;

import org.junit.After;
import org.junit.Before;
import stellarburgers.TestUser;
import stellarburgers.api.APIUserClient;
import stellarburgers.pages.LoginPage;
import stellarburgers.pages.MainPage;

public abstract class AuthorizedBaseTest extends BaseTest {
    protected TestUser testUser;
    protected String accessToken;

    @Before
    public void setUp() {
        super.setUp();
        testUser = TestUserFactory.createUniqueUser();
        accessToken = APIUserClient.registerUser(testUser).jsonPath().getString("accessToken");
        loginViaUI();
    }

    @After
    public void tearDown() {
        if (accessToken != null) {
            APIUserClient.deleteUser(accessToken);
        }
        super.tearDown();
    }

    protected void loginViaUI() {
        new MainPage(driver).clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail(testUser.getEmail());
        loginPage.setPassword(testUser.getPassword());
        loginPage.clickLoginButton();
        assertPlaceOrderButtonDisplayed();
    }
}