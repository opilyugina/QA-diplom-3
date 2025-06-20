package stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.*;
import static stellarburgers.pages.MainPage.MAIN_PAGE_URL;

import stellarburgers.util.AuthorizedBaseTest;
import stellarburgers.pages.MainPage;
import stellarburgers.pages.ProfilePage;

@DisplayName("Тесты личного кабинета")
public class PersonalCabinetTests extends AuthorizedBaseTest {

    private void openPersonalCabinet() {
        new MainPage(driver).clickPersonalCabinet();
        waitForModalOverlayToDisappear();
    }

    @Test
    @DisplayName("Переход из личного кабинета на главную через кнопку 'Конструктор'")
    @Description("Происходит переход из личного кабинета на главную страницу через кнопку 'Конструктор'")
    public void goFromCabinetToConstructorTest() {
        openPersonalCabinet();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickConstructor();
        assertTrue(
                "Не произошел возврат на главную через конструктор",
                driver.getCurrentUrl().contains(MAIN_PAGE_URL)
        );
    }

    @Test
    @DisplayName("Переход из личного кабинета на главную через логотип")
    @Description("Происходит переход из личного кабинета на главную страницу через логотип")
    public void goFromCabinetToMainLogoTest() {
        openPersonalCabinet();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogo();
        assertTrue(
                "Не произошел возврат на главную через логотип",
                driver.getCurrentUrl().contains(MAIN_PAGE_URL)
        );
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Доступна страница личного кабинета")
    public void goToPersonalCabinetTest() {
        openPersonalCabinet();
        assertTrue(
                "Открыта не страница личного кабинета: " + driver.getCurrentUrl(),
                driver.getCurrentUrl().contains("/account")
        );
    }

    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Пользователь может выйти из аккаунта")
    public void logoutTest() {
        openPersonalCabinet();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickExit();
        assertTrue(driver.findElement(ProfilePage.EXIT_BUTTON).isDisplayed());
    }
}