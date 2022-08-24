package page_object;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Page object для страницы заказа (после успешной авторизации пользователя)
 */
public class MainPagePO {

    //Локатор кнопки "Конструктор" в хедере страницы
    public static SelenideElement constructorBtnInHeader =
            $(byXpath("//p[@class ='AppHeader_header__linkText__3q_va ml-2'][contains(text(), 'Конструктор')]"));
    //Локатор кнопки "Лента Заказов" в хедере страницы
    public static SelenideElement orderFeedBtnInHeader =
            $(byXpath("//p[@class ='AppHeader_header__linkText__3q_va ml-2'][contains(text(), 'Лента Заказов')]"));
    //Локатор кнопки "Личный Кабинет" в хедере страницы
    public static SelenideElement personalAreaBtnInHeader =
            $(byXpath("//p[@class ='AppHeader_header__linkText__3q_va ml-2'][contains(text(), 'Личный Кабинет')]"));

    //Локатор кнопки "Оформить"
    public static SelenideElement orderBtn =
            $(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_large__G21Vg");
    //Локатор кнопки "Войти в аккаунт"
    public static SelenideElement signInBtn =
            $(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_large__G21Vg");
    //Локатор кнопки "Личный кабинет"
    public static SelenideElement personalAreaBtn = $(byAttribute("href", "/account"));

    //Локатор кнопки "Stellar Burger" в шапке страницы
    public static SelenideElement stellarBurgerBtn = $(byAttribute("href", "/"));
}
