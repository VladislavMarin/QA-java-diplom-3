
import com.codeborne.selenide.*;
import org.junit.Before;
import org.junit.Test;
import page_object.AuthPagePO;
import page_object.MainPagePO;
import page_object.RegisterPagePO;
import utils.Utils;

import static com.codeborne.selenide.Selenide.open;
import static utils.Utils.*;

/**
 * Класс для тестирования регистрации пользователя
 */

public class TestUserRegistration {

    @Before
    public void setUp() {
        Configuration.browserSize = "1366x768";
        Configuration.browser = "chrome";
//        Configuration.browser = "firefox";
        open(BASE_URL);
    }

    /**
     * Тест на регистрацию пользователя, где пароль меньше 6 символов
     */
    @Test
    public void testUserRegistrationWithNoValidPassword() {

        MainPagePO.personalAreaBtn.click();
        AuthPagePO.registerBtn.scrollTo().click();

        RegisterPagePO.fieldNameFromRegistration.setValue(name);
        RegisterPagePO.fieldEmailFromRegistration.setValue(email);
        RegisterPagePO.fieldPasswordFromRegistration.setValue("12345");

        RegisterPagePO.registerBtn.click();

        RegisterPagePO.errorNoValidPassword.isDisplayed();
        RegisterPagePO.errorNoValidPassword.shouldHave(Condition.exactText("Некорректный пароль"));
    }

    /**
     * Тест на успешную регистрацию пользователя
     */
    @Test
    public void testUserRegistrationWithValidData() {

        userRegistration(name, email, password);

        AuthPagePO.loginBtn.shouldBe(Condition.visible);
        loginUser(email, password);

        MainPagePO.orderBtn.shouldBe(Condition.visible);

        Utils.deleteUser();
    }
}
