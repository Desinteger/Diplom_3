package site.nomoreparties.stellarburgers.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Optional;

public class WebDriverFactory {
    static ChromeOptions options = new ChromeOptions();
    public static WebDriver get() {
        WebDriver webdriver;
        String browserName = Optional.ofNullable(System.getProperty("browser"))
                .orElse(Optional.ofNullable(System.getenv("browser"))
                        .orElse("chrome"));
        options.addArguments("--remote-allow-origins=*");

        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                webdriver = new ChromeDriver(options);
                break;
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                options.setBinary("C:/Users/degne/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
                webdriver = new ChromeDriver(options);
                break;
            default:
                throw new RuntimeException("Browser not found: " + browserName);
        }
        return webdriver;
    }
}