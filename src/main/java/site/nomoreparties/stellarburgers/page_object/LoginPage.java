package site.nomoreparties.stellarburgers.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class LoginPage {
    private WebDriver webdriver;
    public LoginPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    private static final By registerButton = xpath(".//a[contains(text(),'Зарегистрироваться')]");
    private static final By loginButton = xpath(".//button[contains(text(),'Войти')]");
    private static final By resetPasswordButton = xpath (".//a[contains(text(),'Восстановить пароль')]");
    private static final By emailField = xpath(".//input[@name='name']");
    private static final By passwordField = xpath(".//input[@name='Пароль']");
    private static final By signInButton = xpath(".//form/button");

    public void loginUser(String email, String password){
        setEmail(email);
        setPassword(password);
    }

    public void setEmail(String email) { webdriver.findElement(emailField).sendKeys(email); }

    public void setPassword(String password) { webdriver.findElement(passwordField).sendKeys(password); }

    public void clickRegisterButton() {
        webdriver.findElement(registerButton).click();
    }

    public void clickSignInButton() { webdriver.findElement(signInButton).click(); }

    public boolean isLoginButtonDisplayed() {
        return webdriver.findElement(loginButton).isDisplayed();
    }

    public void clickResetPasswordButton() { webdriver.findElement(resetPasswordButton).click(); }

}
