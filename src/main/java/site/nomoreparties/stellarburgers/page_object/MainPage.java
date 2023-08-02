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
    private static final By bunTubSelected = xpath("//div[contains(@class, 'tab_tab__1SPyG') and contains(@class, 'tab_tab_type_current__2BEPc') and contains(@class, 'pt-4') and contains(@class, 'pr-10') and contains(@class, 'pb-4') and contains(@class, 'pl-10') and contains(@class, 'noselect')]//span[contains(@class, 'text_type_main-default') and text()='Булки']");
    private static final By sauceTubSelected = xpath("//div[contains(@class, 'tab_tab__1SPyG') and contains(@class, 'tab_tab_type_current__2BEPc') and contains(@class, 'pt-4') and contains(@class, 'pr-10') and contains(@class, 'pb-4') and contains(@class, 'pl-10') and contains(@class, 'noselect')]//span[contains(@class, 'text_type_main-default') and text()='Соусы']");
    private static final By fillingTubSelected = xpath("//div[contains(@class, 'tab_tab__1SPyG') and contains(@class, 'tab_tab_type_current__2BEPc') and contains(@class, 'pt-4') and contains(@class, 'pr-10') and contains(@class, 'pb-4') and contains(@class, 'pl-10') and contains(@class, 'noselect')]//span[contains(@class, 'text_type_main-default') and text()='Начинки']");

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

    public boolean isBunTabSelected(){  return webdriver.findElement(bunTubSelected).isDisplayed();   }

    public boolean isSauceTabSelected(){
        return webdriver.findElement(sauceTubSelected).isDisplayed();
    }

    public boolean isFillingTabSelected(){
        return webdriver.findElement(fillingTubSelected).isDisplayed();
    }

}
