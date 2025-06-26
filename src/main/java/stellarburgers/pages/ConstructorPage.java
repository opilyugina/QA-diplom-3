package stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructorPage extends BasePage {
    public static final By BUNS_TAB = By.xpath("//span[text()='Булки']");
    public static final By SAUCES_TAB = By.xpath("//span[text()='Соусы']");
    public static final By FILLINGS_TAB = By.xpath("//span[text()='Начинки']");
    public static final By ACTIVE_TAB = By.xpath("//div[contains(@class,'tab_tab_type_current')]");

    public ConstructorPage(WebDriver driver) {
        super(driver);
    }

    @Step("Переход на вкладку: {tabName}")
    public void goToTab(String tabName) {
        if (!isTabActive(tabName)) {
            click(getTabLocator(tabName));
        }
    }

    private By getTabLocator(String tabName) {
        switch (tabName) {
            case "Булки": return BUNS_TAB;
            case "Соусы": return SAUCES_TAB;
            case "Начинки": return FILLINGS_TAB;
            default: throw new IllegalArgumentException("Неизвестная вкладка: " + tabName);
        }
    }

    @Step("Получение текста активной вкладки")
    public String getActiveTabText() {
        return getText(ACTIVE_TAB);
    }

    public boolean isTabActive(String tabName) {
        return getActiveTabText().equals(tabName);
    }
}