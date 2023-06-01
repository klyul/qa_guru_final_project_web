package web;

import components.ContactUsFormComponent;
import components.TopMenuComponent;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;
import pages.SearchResultsPage;

import static com.codeborne.selenide.Selenide.closeWindow;

public class MainPageTests extends TestBaseBint {

    MainPage mainPage = new MainPage();
    TopMenuComponent topMenuComponent = new TopMenuComponent();
    ContactUsFormComponent contactUsFormComponent = new ContactUsFormComponent();
    SearchResultsPage searchResultsPage = new SearchResultsPage();


    @Test
    @Tag("bell")
    @DisplayName("Проверяем часть меню сайта")
    void menuTest() {
        mainPage.openPage();
        mainPage.clickTopMenuButton();
        topMenuComponent.menuItemsShouldBePresent();
    }

    @Test
    @Tag("bell")
    @DisplayName("Проверяем часть формы обратной связи")
    void feedbackFormTest01() {
        mainPage.openPage();
        mainPage.clickConntactUsButton();
        contactUsFormComponent.checkRequiredFormElements();
    }

    @Tag("bell")
    @DisplayName("Проверяем отсутствие PHP warnings на странице результатов поиска")
    @ParameterizedTest
    @ValueSource(strings = {"акция", "услуг", "проверки", "команде", "тестирования"})
    void bellSearchPhpWarningsTest(String value) {

        mainPage.openPage();
        mainPage.searchFromMainPage(value);
        searchResultsPage.shouldHaveSearchTitles(value);
        Assertions.assertEquals(0, searchResultsPage.numberOfPhpWarnings(), "Не должно быть PHP warnings");

    }

    @AfterEach
    void tearDown() {
        closeWindow();
    }
}
