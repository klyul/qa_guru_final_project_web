package web;

import com.codeborne.selenide.Condition;
import components.ContactUsForm;
import components.TopMenu;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;
import pages.SearchResultsPage;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTests extends TestBaseBint {

    MainPage mainPage = new MainPage();
    TopMenu topMenu = new TopMenu();
    ContactUsForm contactUsForm = new ContactUsForm();
    SearchResultsPage searchResultsPage = new SearchResultsPage();


    @Test
    @Tag("bell")
    @DisplayName("Проверяем часть меню сайта")
    void menuTest() {
        mainPage.openPage();
        mainPage.clickTopMenuButton();
        topMenu.menuItemsShouldBePresent();
    }

    @Test
    @Tag("bell")
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

    @Tag("bell")
    @DisplayName("Проверяем отсутствие PHP warnings на странице результатов поиска")
    @ParameterizedTest
    @ValueSource(strings = {"акция","услуг", "проверки", "команде", "тестирования", "система"})
    void bellSearchPhpWarningsTest(String value) {

        mainPage.openPage();
        mainPage.searchFromMainPage(value);
        searchResultsPage.shouldHaveSearchTitles(value);
        Assertions.assertEquals(0, searchResultsPage.numberOfPhpWarnings(), "Не должно быть PHP warnings");

    }
}
