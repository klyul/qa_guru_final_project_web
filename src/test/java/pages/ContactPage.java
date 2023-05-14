package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.GeneralMethods.setBannerCookie;

public class ContactPage {
    SelenideElement branches = $("div.block-gray ul[role=tablist]");
    SelenideElement officeDescription = $("div.tab-pane.active h3");
    SelenideElement submitButton = $("#submit_your_app_open");



    @Step("Проверяем открытие страницы с контактами")
    public void openPage() {
        setBannerCookie();
        open("/index.php?route=information/contact");
    }

    @Step("Проверяем главные элементы страницы с контактами")
    public void mainElementsShouldBePresent(String value) {
        branches.shouldBe(visible);
        submitButton.shouldBe(interactable);
        officeDescription.shouldBe(visible);
    }
}