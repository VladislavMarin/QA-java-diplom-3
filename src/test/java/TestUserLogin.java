import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page_object.*;

import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;
import static utils.Utils.*;

public class TestUserLogin {

    @Before
    public void setUp() {
        Configuration.browserSize = "1366x768";
        Configuration.browser = "chrome";
//        Configuration.browser = "firefox";
        open(BASE_URL);
        userRegistration(name, email, password);
    }

    @After
    public void tearDown() {
        deleteUser();
    }

    /**
     * Тест на авторизацию по кнопке «Войти в аккаунт» на главной
     */
    @Test
    public void testLoggingUserFromMainPage() {

        MainPagePO.signInBtn.click();

        EnterData();

        MainPagePO.orderBtn.shouldBe(Condition.visible);
    }

    /**
     * Тест на авторизацию через кнопку «Личный кабинет»
     */
    @Test
    public void testLoggingUserFromPersonalArea() {

        loginUser(email, password);

        MainPagePO.orderBtn.shouldBe(Condition.visible);
    }

    /**
     * Тест на авторизацию через кнопку в форме регистрации
     */
    @Test
    public void testLoggingUserFromRegistrationPage() {

        MainPagePO.personalAreaBtnInHeader.click();
        AuthPagePO.registerBtn.click();
//        RegisterPagePO.signInFromRegisterPage.scrollTo().click();

        actions().moveToElement(RegisterPagePO.signInFromRegisterPage).click(RegisterPagePO.signInFromRegisterPage).perform();
        EnterData();

        MainPagePO.orderBtn.shouldBe(Condition.visible);
    }

    /**
     * Тест на авторизацию через кнопку в форме восстановления пароля
     */
    @Test
    public void testLoggingUserFromRecoveryPasswordPage() {

        MainPagePO.personalAreaBtnInHeader.click();
        AuthPagePO.recoveryPasswordBtn.scrollTo().click();
        RecoveryPasswordPagePO.signInFromRecoveryPasswordBtn.scrollTo().click();

        EnterData();

        MainPagePO.orderBtn.shouldBe(Condition.visible);
    }

    /**
     * Тест выхода по кнопке «Выйти» в личном кабинете
     */
    @Test
    public void testUserLogOut() {
        loginUser(email, password);

        MainPagePO.personalAreaBtnInHeader.click();

        PersonalAreaPagePO.logOutBtn.click();

        AuthPagePO.PersonalAreaLogoInput.shouldHave(Condition.exactText("Вход"));
    }

    /**
     * Метод ввода данных на странице авторизации пользователя
     */
    public void EnterData() {
        AuthPagePO.loginBtn.scrollTo().shouldBe(Condition.visible);

        AuthPagePO.fieldEmail.setValue(email);
        AuthPagePO.fieldPassword.setValue(password);

        actions().moveToElement(AuthPagePO.loginBtn).click(AuthPagePO.loginBtn).perform();
    }
}
