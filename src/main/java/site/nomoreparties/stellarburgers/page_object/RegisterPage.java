package site.nomoreparties.stellarburgers.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.*;

public class RegisterPage {
    private WebDriver webdriver;

    public RegisterPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }
    private static final By nameField = xpath(".//fieldset[1]/div/div/input");
    private static final By emailField = xpath(".//fieldset[2]/div/div/input");
    private static final By passwordField = xpath(".//fieldset[3]/div/div/input");
    private static final By registerButton = xpath(".//button[contains(text(),'Зарегистрироваться')]");
    private static final By errorText = xpath(".//p[contains(text(),'Некорректный пароль')]");
    private static final By signInButton = xpath(".//a[contains(text(),'Войти')]");

    public void registerUser(String name, String email, String password){
        setName(name);
        setEmail(email);
        setPassword(password);
    }

    public void registerUserWithIncorrectPassword(String name, String email){
        setName(name);
        setEmail(email);
    }

    public void setName(String name) { webdriver.findElement(nameField).sendKeys(name); }

    public void setEmail(String email) {
        webdriver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) { webdriver.findElement(passwordField).sendKeys(password); }

    public void setIncorrectPassword() {
        String incorrectPassword = "12345";
        webdriver.findElement(passwordField).sendKeys(incorrectPassword);
    }

    public void clickRegisterButton() {
        webdriver.findElement(registerButton).click();
    }

    public boolean isRegisterNotProcessed(){
        return webdriver.findElement(errorText).isDisplayed();
    }

    public void clickSingInButton() {
        webdriver.findElement(signInButton).click();
    }
}
