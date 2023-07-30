package site.nomoreparties.stellarburgers.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.*;

public class MainPage {
    private WebDriver webdriver;

    public MainPage(WebDriver webdriver) {
        this.webdriver = webdriver;
    }
    private static final By personalAreaButton = xpath(".//p[contains(text(),'Личный Кабинет')]");
    private static final By signInAccountButton = xpath(".//button[contains(text(),'Войти в аккаунт')]");
    private static final By checkOutButton = xpath(".//button[contains(text(),'Оформить заказ')]");
    private static final By fillingsSection = xpath(".//span[contains(text(),'Начинки')]");
    private static final By saucesSection = xpath(".//span[contains(text(),'Соусы')]");
    private static final By bunsSection = xpath(".//span[contains(text(),'Булки')]");
    private static final By fluorescentBunTitle = xpath(".//p[contains(text(),'Флюоресцентная булка R2-D3')]");
    private static final By sauceSpicyXTitle = xpath(".//p[contains(text(),'Соус Spicy-X')]");
    private static final By beefMeteoriteTitle = xpath(".//p[contains(text(),'Говяжий метеорит (отбивная)')]");


    public void clickPersonalAreaButton() {
        webdriver.findElement(personalAreaButton).click();
    }

    public void clickSignInAccountButton() {
        webdriver.findElement(signInAccountButton).click();
    }

    public boolean isConstructorDisplayed(){
        return webdriver.findElement(checkOutButton).isDisplayed();
    }

    public void clickFillingsSection() {
        webdriver.findElement(fillingsSection).click();
    }

    public void clickSaucesSection() {
        webdriver.findElement(saucesSection).click();
    }

    public void clickBunsSection() {
        webdriver.findElement(bunsSection).click();
    }

    public boolean isFluorescentBunTitleDisplayed(){
        return webdriver.findElement(fluorescentBunTitle).isDisplayed();
    }

    public boolean isSauceSpicyXTitleDisplayed(){
        return webdriver.findElement(sauceSpicyXTitle).isDisplayed();
    }

    public boolean isBeefMeteoriteTitleDisplayed(){
        return webdriver.findElement(beefMeteoriteTitle).isDisplayed();
    }

}
