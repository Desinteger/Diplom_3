package site.nomoreparties.stellarburgers;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.api.User;
import site.nomoreparties.stellarburgers.api.UserActions;
import site.nomoreparties.stellarburgers.api.UserGenerator;
import site.nomoreparties.stellarburgers.api.UserLogin;
import site.nomoreparties.stellarburgers.browsers.WebDriverFactory;

import java.time.Duration;

import static site.nomoreparties.stellarburgers.config.AppConfig.APP_URL;
import io.restassured.response.Response;

public class BaseTest {
    WebDriver webdriver;
    User user = new User();
    UserActions userActions = new UserActions();
    private final UserLogin userLogin = new UserLogin(user.getEmail(), user.getPassword());

    public void webDriver() {
        webdriver = WebDriverFactory.get();
        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        webdriver.get(APP_URL);
    }

    public WebDriver getDriver() {
        return webdriver;
    }

    public UserActions getUserActions(){
        return userActions;
    }

    public User getUser() { return user; }

    public UserLogin getUserLogin(){ return userLogin; }

    @Before
    public void setUp(){
        user = UserGenerator.random();
        webDriver();
    }

    @After
    public void teardown() {
        Response response = getUserActions().loginUser(getUserLogin());
        if (response.jsonPath().get("success").equals(true)) {
                getUserActions()
                        .logOutUser(response.jsonPath()
                        .get("accessToken"));
                getUserActions()
                        .deleteUser(response.jsonPath()
                        .get("accessToken"));
  }
        webdriver.quit();
    }
}
