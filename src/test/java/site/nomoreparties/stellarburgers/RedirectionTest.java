package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.page_object.LoginPage;
import site.nomoreparties.stellarburgers.page_object.MainPage;
import site.nomoreparties.stellarburgers.page_object.PersonalAreaPage;

import static org.junit.Assert.assertTrue;

@DisplayName("Тесты: переходы в конструктор")
public class RedirectionTest extends BaseTest {

    @Before
    public void registerAndLoginUser(){
        getUserActions().createUser(getUser());
        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.clickPersonalAreaButton();
        LoginPage objLoginPage = new LoginPage(getDriver());
        objLoginPage.loginUser(getUser().getEmail(), getUser().getPassword());
        objLoginPage.clickSignInButton();
        objMainPage.clickPersonalAreaButton();
    }

    @DisplayName("Тест перехода из Личного кабинета в Конструктор по клику на кнопку 'Конструктор'")
    @Test
    public void testRedirectToConstructorFromPersonalAreaByConstructorButton(){
        PersonalAreaPage objPersonalAreaPage = new PersonalAreaPage(getDriver());
        objPersonalAreaPage.clickConstructorButton();
        MainPage objMainPage = new MainPage(getDriver());
        assertTrue(objMainPage.isConstructorDisplayed());
    }

    @DisplayName("Тест перехода из Личного кабинета в конструктор по клику на лого 'Stellar Burgers'")
    @Test
    public void testRedirectToConstructorFromPersonalAreaByLogo(){
        PersonalAreaPage objPersonalAreaPage = new PersonalAreaPage(getDriver());
        objPersonalAreaPage.clickLogo();
        MainPage objMainPage = new MainPage(getDriver());
        assertTrue(objMainPage.isConstructorDisplayed());
    }
}
