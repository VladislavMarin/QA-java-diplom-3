import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page_object.AuthPagePO;
import page_object.ConstructorPagePO;
import page_object.MainPagePO;

import static com.codeborne.selenide.Selenide.open;
import static utils.Utils.*;
import static utils.Utils.deleteUser;

/**
 * Класс для тестирования переходов по разделам в шапке на главной странице
 */
public class TestMainPage {

    @Before
    public void setUp() {
        Configuration.browserSize = "1366x768";
        open(BASE_URL);
        userRegistration(name, email, password);
        loginUser(email, password);
    }

    @After
    public void tearDown() {
        deleteUser();
    }

    /**
     * Тест на переход в личный кабинет
     */
    @Test
    public void testGoToPersonalArea() {
        MainPagePO.personalAreaBtnInHeader.click();

        AuthPagePO.PersonalAreaElement.
                shouldHave(Condition.exactText("В этом разделе вы можете изменить свои персональные данные"));
    }
    
    /**
     * Тест на переход в коструктор из личного кабинета 
     */
    @Test
    public void testGoToConstructorFromPersonalArea() {
        MainPagePO.personalAreaBtnInHeader.click();
        MainPagePO.constructorBtnInHeader.click();

        ConstructorPagePO.ConstructorLogoPage.shouldHave(Condition.exactText("Соберите бургер"));
    }

    @Test
    public void name() {
    }
}
