package page_object;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * Page object для страницы регистрации
 */
public class RegisterPagePO {

    //Локатор для поля "Имя"
    public static SelenideElement fieldNameFromRegistration =
            $(byXpath("(//input)[1]"));
    //Локатор для поля "Email"
    public static SelenideElement fieldEmailFromRegistration =
            $(byXpath("(//input)[2]"));
    //Локатор для поля "Пароль"
    public static SelenideElement fieldPasswordFromRegistration =
            $(byXpath("//input[@type = 'password']"));
    //Локатор кнопки "Зарегистрироваться"
    public static SelenideElement registerBtn =
            $(byXpath("//button[@class ='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']" +
                    "[contains(text(), 'Зарегистрироваться')]"));
    //Локатор уведомления "Неверный пароль" при попытке зарегистрироваться с паролем меньше 6 символов
    public static SelenideElement errorNoValidPassword =
            $(".input__error.text_type_main-default");

    //Локатор кнопки "Войти" в форме регистрации
    public static SelenideElement signInFromRegisterPage =
//            $(byXpath("//a[@class = 'Auth_link__1fOlj'][@href = '/login']"));
            $(byXpath("//a[@class = 'Auth_link__1fOlj'][contains(text(), 'Войти')]"));


}
