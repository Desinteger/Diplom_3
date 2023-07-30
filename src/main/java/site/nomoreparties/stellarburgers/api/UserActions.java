package site.nomoreparties.stellarburgers.api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserActions extends BaseClient {
    private static final String REGISTER_USER = "/api/auth/register";
    private static final String LOGIN_USER = "/api/auth/login";
    private static final String DATA_USER = "/api/auth/user";
    public static final String LOGOUT_USER = "/api/auth/logout";

    @Step("Создание пользователя")
    public Response createUser(User user) {
        return given(getRequestSpecification())
                .body(user)
                .when()
                .post(REGISTER_USER);
    }

    @Step("Логин пользователя")
    public Response loginUser(UserLogin userLogin) {
         return given(getRequestSpecification())
                .body(userLogin)
                .when()
                .post(LOGIN_USER);
    }

    @Step("Выход из системы по токену")
    public Response logOutUser(String accessToken) {
        RequestSpecification request = given(getRequestSpecification());
        if (accessToken != null) {
            request = request.header("Authorization", accessToken);
        }
        return request.when().post(LOGOUT_USER);
    }

    @Step("Удаление пользователя по токену")
    public Response deleteUser(String accessToken) {
        RequestSpecification request = given(getRequestSpecification());
        if (accessToken != null) {
            request = request.header("Authorization", accessToken);
        }
        return request.when().delete(DATA_USER);
    }
}
