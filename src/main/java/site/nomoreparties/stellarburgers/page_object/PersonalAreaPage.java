package site.nomoreparties.stellarburgers.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class PersonalAreaPage {

    private WebDriver webdriver;
    public PersonalAreaPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    private static final By exitButton = xpath(".//button[contains(text(),'Выход')]");

    private static final By constructorButton = xpath(".//p[contains(text(),'Конструктор')]");

    private static final By logo = xpath("(//*[local-name()='svg' and namespace-uri()='http://www.w3.org/2000/svg'])[3]");

    public void clickExitButton(){ webdriver.findElement(exitButton).click(); }

    public void clickConstructorButton(){ webdriver.findElement(constructorButton).click(); }

    public void clickLogo() { webdriver.findElement(logo).click(); }
}
