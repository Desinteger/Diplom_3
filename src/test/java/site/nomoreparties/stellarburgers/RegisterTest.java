package site.nomoreparties.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.nomoreparties.stellarburgers.page_object.LoginPage;
import site.nomoreparties.stellarburgers.page_object.MainPage;
import site.nomoreparties.stellarburgers.page_object.RegisterPage;

import static org.junit.Assert.*;

@DisplayName("Тесты: регистрация")
public class RegisterTest extends BaseTest {

    @DisplayName("Тест успешной регистрации пользователя со всеми валидаными полями")
    @Test
    public void testIfRegistrationIsSuccessfulWithValidField() {
        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.clickPersonalAreaButton();
        LoginPage objLoginPage = new LoginPage(getDriver());
        objLoginPage.clickRegisterButton();
        RegisterPage objRegisterPage = new RegisterPage(getDriver());
        objRegisterPage.registerUser(getUser().getName(), getUser().getEmail(), getUser().getPassword());
        objRegisterPage.clickRegisterButton();
        assertTrue(objLoginPage.isLoginButtonDisplayed());
    }

    @DisplayName("Тест регистрации пользователя со некорректным паролем")
    @Test
    public void testIfRegistrationIsSuccessfulWithIncorrectPassword() {
        MainPage objMainPage = new MainPage(getDriver());
        objMainPage.clickPersonalAreaButton();
        LoginPage objLoginPage = new LoginPage(getDriver());
        objLoginPage.clickRegisterButton();
        RegisterPage objRegisterPage = new RegisterPage(getDriver());
        objRegisterPage.registerUserWithIncorrectPassword(getUser().getName(), getUser().getEmail());
        objRegisterPage.setIncorrectPassword();
        objRegisterPage.clickRegisterButton();
        assertTrue(objRegisterPage.isRegisterNotProcessed());
    }
}