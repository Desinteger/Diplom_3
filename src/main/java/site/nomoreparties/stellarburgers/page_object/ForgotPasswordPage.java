package site.nomoreparties.stellarburgers.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class ForgotPasswordPage {
    private WebDriver webdriver;
    public ForgotPasswordPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }
    private static final By signInButton = xpath(".//a[contains(text(),'Войти')]");
    public void clickSignInButton() { webdriver.findElement(signInButton).click(); }
}
