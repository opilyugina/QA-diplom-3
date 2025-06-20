package stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;
import stellarburgers.pages.ConstructorPage;
import stellarburgers.pages.MainPage;
import stellarburgers.util.BaseTest;

import java.util.Arrays;
import java.util.Collection;

@DisplayName("Проверка вкладок конструктора")
@RunWith(Parameterized.class)
public class ConstructorTabsTests extends BaseTest {
    private ConstructorPage constructorPage;

    @Parameterized.Parameter(0)
    public String tabToClick;

    @Parameterized.Parameter(1)
    public String expectedTab;

    @Parameterized.Parameters(name = "Клик по \"{0}\" активирует \"{1}\"")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Соусы", "Соусы"},
                {"Булки", "Булки"},
                {"Начинки", "Начинки"}
        });
    }

    @Before
    public void setUpTest() {
        openMainPage();
        new MainPage(driver).clickConstructor();
        constructorPage = new ConstructorPage(driver);
    }

    @Test
    @DisplayName("Проверка активации вкладок конструктора")
    @Description("Проверяет, что при нажатии на \"{0}\" открывается вкладка \"{1}\"")
    public void tabActivationTest() {
        constructorPage.goToTab(tabToClick);
        assertEquals(expectedTab, constructorPage.getActiveTabText());
    }
}