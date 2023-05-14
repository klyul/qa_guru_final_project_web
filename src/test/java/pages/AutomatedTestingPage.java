package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.GeneralMethods.setBannerCookie;

public class AutomatedTestingPage {
    SelenideElement headTittle = $("h2.head-title_text");
    SelenideElement solutionTittle = $("h3.head-title_text");
    SelenideElement advantagesTittle = $("div.blue-st h3");
    SelenideElement contactUsButton = $("button#button_open_stay");


    @Step("Проверяем открытие страницы с автоматизированным тестированием")
    public void openPage() {
        setBannerCookie();
        open("/Automation/AutomatedLabTesting");
    }

    @Step("Проверяем главные элементы страницы с автоматизированным тестированием")
    public void mainElementsShouldBePresent() {
        headTittle.shouldBe(visible);
        solutionTittle.shouldBe(visible);
        advantagesTittle.shouldBe(visible);
        contactUsButton.shouldBe(interactable);


    }
}
