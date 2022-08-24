package page_object;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class PersonalAreaPagePO {

    public static SelenideElement logOutBtn = $(byXpath("//button[contains(text(), 'Выход')]"));
}
