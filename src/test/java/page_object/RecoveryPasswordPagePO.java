package page_object;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryPasswordPagePO {

    //Локатор кнопки "Восстановить пароль"
    public static SelenideElement signInFromRecoveryPasswordBtn =
            $(byXpath("//a[@class = 'Auth_link__1fOlj'][@href = '/login']"));
}
