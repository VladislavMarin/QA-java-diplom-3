import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import page_object.AuthPagePO;
import page_object.ConstructorPagePO;

import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;
import static utils.Utils.*;

/**
 * Класс для тестирование переходов по разделам конструктора
 */
public class TestConstructor {

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
     * Тест на переход в раздел "Булки"
     */
    @Test
    public void testConstructorGoToTheBuns() {

        ConstructorGoTo(ConstructorPagePO.ConstructorBurgerBuns);

        ConstructorPagePO.bunsLogo.shouldHave(Condition.exactText("Булки"));
    }
    /**
     * Тест на переход в раздел "Соусы"
     */
    @Test
    public void testConstructorGoToTheSauces() {

        ConstructorGoTo(ConstructorPagePO.ConstructorBurgerSauces);

        ConstructorPagePO.saucesLogo.shouldHave(Condition.exactText("Соусы"));
    }
    /**
     * Тест на переход в раздел "Соусы"
     */
    @Test
    public void testConstructorGoToTheToppings() {

        ConstructorGoTo(ConstructorPagePO.ConstructorBurgerToppings);

        ConstructorPagePO.toppingsLogo.shouldHave(Condition.exactText("Начинки"));
    }
    /**
     * Метод прехода по разделам "Конструктора"
     */
    public void ConstructorGoTo(SelenideElement element) {
        actions().moveToElement(element).
                click(element).
                perform();
    }
}
