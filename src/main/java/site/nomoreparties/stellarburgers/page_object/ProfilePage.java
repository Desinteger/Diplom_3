package site.nomoreparties.stellarburgers.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class ProfilePage {
    private WebDriver webdriver;
    public ProfilePage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }
    private static final By nameFiled = xpath(".//input[@name='Name']");
    public boolean isLoginProcessed(){
        return webdriver.findElement(nameFiled).isDisplayed();
    }
}
