package web;

import com.codeborne.selenide.Condition;
import components.ContactUsForm;
import components.TopMenu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTests extends TestBaseBint {

    MainPage mainPage = new MainPage();
    TopMenu topMenu = new TopMenu();
    ContactUsForm contactUsForm = new ContactUsForm();


    @Test
    @DisplayName("Проверяем часть меню сайта")
    void menuTest() {
        mainPage.openPage();
        mainPage.clickTopMenuButton();
        topMenu.menuItemsShouldBePresent();
    }

    @Test
    @DisplayName("Проверяем часть формы обратной связи")
    void feedbackFormTest01() {
        mainPage.openPage();
        mainPage.clickConntactUsButton();
        contactUsForm.checkRequiredFormElements();
    }

    @AfterEach
    void tearDown() {
        closeWindow();
    }

    @ParameterizedTest
    @ValueSource(strings = {"акция", "новая", "услуг", "проверки", "условия", "команде", "тестирования", "клиентский", "опыт", "система"})
    void bellSearchTest(String value) {

        mainPage.openPage();
        $("#search-open").shouldBe(Condition.interactable);
        $("#search-open").click();

        $("input[name=search]").sendKeys(value);
        $("input[name=search]").pressEnter();

        $$("h2").first().shouldHave(Condition.text("Поиск - " + value));
        $$("h2").get(1).shouldHave(Condition.text("Результаты поиска"));

        int warnings = $$x("//b[contains(text(),'Warning')]").size();
        Assertions.assertEquals(0, warnings, "Не должно быть PHP warnings");

    }
}
