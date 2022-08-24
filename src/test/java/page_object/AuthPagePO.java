package page_object;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * Page object для страницы аутентификации
 */
public class AuthPagePO {
    //Локатор кнопки "Зарегистрроваться" на странице аутентификации
    public static SelenideElement registerBtn = $(byAttribute("href", "/register"));
    //Локатор поля "Email"
    public static SelenideElement fieldEmail =
            $(byXpath("//input[@class = 'text input__textfield text_type_main-default'][@type = 'text']"));
    //Локатор поля "Password"
    public static SelenideElement fieldPassword =
            $(byXpath("//input[@class = 'text input__textfield text_type_main-default'][@type = 'password']"));
    //Локатор кнопки "Войти"
    public static SelenideElement loginBtn =
            $(byXpath("//button[@class ='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']" +
                    "[contains(text(), 'Войти')]"));
    //Локатор кнопки "Восстановить пароль"
    public static SelenideElement recoveryPasswordBtn =
            $(byXpath("//a[@class = 'Auth_link__1fOlj'][@href = '/forgot-password']"));
    //Локатор надписи "Вход" на странице авторизации
    public static SelenideElement PersonalAreaLogoInput =
            $(byXpath("//h2[contains(text(), 'Вход')]"));

    public static SelenideElement PersonalAreaElement = $(".Account_text__fZAIn.text.text_type_main-default");
}
