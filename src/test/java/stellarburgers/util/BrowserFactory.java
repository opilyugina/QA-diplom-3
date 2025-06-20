package stellarburgers.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {
    private static final String DEFAULT_YANDEX_PATH =
            "C:\\Users\\lelya\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";

    public static WebDriver getDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                return new ChromeDriver();
            case "yandex":
                ChromeOptions options = new ChromeOptions();
                String yandexPath = System.getProperty("yandex.browser.path", DEFAULT_YANDEX_PATH);
                options.setBinary(yandexPath);
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                return new ChromeDriver(options);
            default:
                throw new IllegalArgumentException("Неизвестный браузер: " + browserName);
        }
    }
}