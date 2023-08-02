package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.page_object.*;

import static org.junit.Assert.*;

@DisplayName("Тесты: авторизация")
public class LoginTest extends BaseTest {

    @Before
    public void registerUser(){
        getUserActions().createUser(getUser());
    }

    @DisplayName("Тест авторизации по кнопке 'Войти в аккаунт' на главной странице")
    @Test
    public void testLoginFromSignInAccountButton() {
        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.clickSignInAccountButton();
        LoginPage objLoginPage = new LoginPage(getDriver());
        objLoginPage.loginUser(getUser().getEmail(), getUser().getPassword());
        objLoginPage.clickSignInButton();
        objMainPage.clickPersonalAreaButton();
        ProfilePage objProfilePage = new ProfilePage(getDriver());
        assertTrue(objProfilePage.isLoginProcessed());
    }

    @DisplayName("Тест авторизации по кнопке 'Личный кабинет' на главной странице и перехода в Личный кабинет")
    @Test
    public void testLoginFromPersonalAreaButton(){
        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.clickPersonalAreaButton();
        LoginPage objLoginPage = new LoginPage(getDriver());
        objLoginPage.loginUser(getUser().getEmail(), getUser().getPassword());
        objLoginPage.clickSignInButton();
        objMainPage.clickPersonalAreaButton();
        ProfilePage objProfilePage = new ProfilePage(getDriver());
        assertTrue(objProfilePage.isLoginProcessed());
    }

    @DisplayName("Тест авторизации по кнопке 'Войти' на странице регистрации")
    @Test
    public void testLoginFromRegistrationButton(){
        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.clickPersonalAreaButton();
        LoginPage objLoginPage = new LoginPage(getDriver());
        objLoginPage.clickRegisterButton();
        RegisterPage objRegisterPage = new RegisterPage(getDriver());
        objRegisterPage.clickSingInButton();
        objLoginPage.loginUser(getUser().getEmail(), getUser().getPassword());
        objLoginPage.clickSignInButton();
        objMainPage.clickPersonalAreaButton();
        ProfilePage objProfilePage = new ProfilePage(getDriver());
        assertTrue(objProfilePage.isLoginProcessed());
    }

    @DisplayName("Тест авторизации по кнопке 'Восстановить пароль' на странице авторизации")
    @Test
    public void testLoginFromResetPasswordButton(){
        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.clickSignInAccountButton();
        LoginPage objLoginPage = new LoginPage(getDriver());
        objLoginPage.clickResetPasswordButton();
        ForgotPasswordPage objForgotPasswordPage = new ForgotPasswordPage(getDriver());
        objForgotPasswordPage.clickSignInButton();
        objLoginPage.loginUser(getUser().getEmail(), getUser().getPassword());
        objLoginPage.clickSignInButton();
        objMainPage.clickPersonalAreaButton();
        ProfilePage objProfilePage = new ProfilePage(getDriver());
        assertTrue(objProfilePage.isLoginProcessed());
    }

    @DisplayName("Тест выхода из аккаунта по кнопке 'Выход' в личном кабинете")
    @Test
    public void testLogoutFromExitButtonInPersonalArea(){
        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.clickSignInAccountButton();
        LoginPage objLoginPage = new LoginPage(getDriver());
        objLoginPage.loginUser(getUser().getEmail(), getUser().getPassword());
        objLoginPage.clickSignInButton();
        objMainPage.clickPersonalAreaButton();
        PersonalAreaPage objPersonalAreaPage = new PersonalAreaPage(getDriver());
        objPersonalAreaPage.clickExitButton();
        assertTrue(objLoginPage.isLoginButtonDisplayed());
    }
}
