package page_object;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class ConstructorPagePO {

    //Локатор надписи "Соберите бургер" на странице конструктора
    public static SelenideElement ConstructorLogoPage =
            $(byXpath("//h1[@class = 'text text_type_main-large mb-5 mt-10'][contains(text(), 'Соберите бургер')]"));
    //Локатор раздела "Булки"
    public static SelenideElement ConstructorBurgerBuns =
            $(byXpath("//span[@class = 'text text_type_main-default'][contains(text(), 'Булки')]"));
    //Локатор раздела "Соусы"
    public static SelenideElement ConstructorBurgerSauces =
            $(byXpath("//span[@class = 'text text_type_main-default'][contains(text(), 'Соусы')]"));
    //Локатор раздела "Начинки"
    public static SelenideElement ConstructorBurgerToppings =
            $(byXpath("//span[@class = 'text text_type_main-default'][contains(text(), 'Начинки')]"));

    public static SelenideElement bunsLogo =
            $(byXpath("//h2[@class = 'text text_type_main-medium mb-6 mt-10'][contains(text(), 'Булки')]"));

    public static SelenideElement saucesLogo =
            $(byXpath("//h2[@class = 'text text_type_main-medium mb-6 mt-10'][contains(text(), 'Соусы')]"));

    public static SelenideElement toppingsLogo =
            $(byXpath("//h2[@class = 'text text_type_main-medium mb-6 mt-10'][contains(text(), 'Начинки')]"));
}

