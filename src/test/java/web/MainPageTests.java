package web;

import components.ContactUsForm;
import components.TopMenu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.closeWindow;

public class MainPageTests extends TestBaseBint {

    MainPage mainPage = new MainPage();
    TopMenu topMenu = new TopMenu();
    ContactUsForm contactUsForm = new ContactUsForm();


    @Test
    @DisplayName("Проверяем часть меню сайта")
    void menuTest01() {
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
}
