package site.nomoreparties.stellarburgers.api;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class BaseClient {
    protected RequestSpecification getRequestSpecification() {
        RestAssured.baseURI= "https://stellarburgers.nomoreparties.site";
        return given()
                .header("Content-type", "application/json");
    }
}
