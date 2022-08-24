package utils;

import com.codeborne.selenide.Condition;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import page_object.AuthPagePO;
import page_object.MainPagePO;
import page_object.RegisterPagePO;
import utils.user_login_response_deserialization.ResponseFinalDeserializationClass;

import java.io.File;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.actions;
import static io.restassured.RestAssured.given;

/**
 * Утилитный класс
 */
public class Utils {

    /**
     * Базовый адрес для регистрации и логина пользователя
     */
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";


    /**
     * Переменные используемые в качестве вводимых данных
     */
    public static final String name = "Martin";
    public static final String email = "martin@martin.ru";
    public static final String password = "password";

    /**
     * Спецификация запроса для запросов на дуление и логин ползователя
     */
    public static RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://stellarburgers.nomoreparties.site")
            .build().header("Content-Type", "application/json");
    /**
     * Адрес для авторизации пользователя
     */
    public static final String API_AUTH_LOGIN = "/api/auth/login";
    /**
     * Адрес для удаления пользователя
     */
    public static final String API_AUTH_USER = "/api/auth/user";

    /**
     * Метод удаления нового пользователя
     */
    public static void deleteUser() {

        File json = new File("src/test/java/resources/login/UserLoginValidData.json");

        ResponseFinalDeserializationClass responseAuth = given().
                spec(requestSpec).
                body(json).
                post(API_AUTH_LOGIN).
                body().
                as(ResponseFinalDeserializationClass.class);

        Response response = given().
                spec(requestSpec).
                header("Authorization", responseAuth.getAccessToken()).
                when().
                delete(API_AUTH_USER);

        response.then().assertThat().statusCode(202);
    }


    /**
     * Метод регистрации пользователя
     *
     * @param name
     * @param email
     * @param password
     */
    public static void userRegistration(String name, String email, String password) {

        MainPagePO.personalAreaBtn.click();
        AuthPagePO.registerBtn.scrollTo().click();

        RegisterPagePO.fieldNameFromRegistration.setValue(name);
        RegisterPagePO.fieldEmailFromRegistration.setValue(email);
        RegisterPagePO.fieldPasswordFromRegistration.setValue(password);

        RegisterPagePO.registerBtn.click();

        MainPagePO.stellarBurgerBtn.click();
    }

    /**
     * Метод логина пользователя
     *
     * @param email
     * @param password
     */
    public static void loginUser(String email, String password) {

        MainPagePO.personalAreaBtn.click();

        AuthPagePO.loginBtn.scrollTo().shouldBe(Condition.visible);

        AuthPagePO.fieldEmail.setValue(email);
        AuthPagePO.fieldPassword.setValue(password);

        actions().moveToElement(AuthPagePO.loginBtn).click(AuthPagePO.loginBtn).perform();
    }
}
