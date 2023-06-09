package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static helpers.GeneralMethods.setBannerCookie;

public class ContactPage {
    private final SelenideElement branches = $("div.visible-lg div.block-gray");
    private final SelenideElement officeDescription = $("div.tab-pane.active h3");
    private final SelenideElement submitButton = $("#submit_your_app_open");


    @Step("Проверяем открытие страницы с контактами")
    public void openPage() {
        setBannerCookie();
        open("/index.php?route=information/contact");
    }

    @Step("Проверяем главные элементы страницы с контактами")
    public void mainElementsShouldBePresent() {
        branches.shouldBe(visible);
        submitButton.shouldBe(interactable);
        officeDescription.shouldBe(visible);
        Assertions.assertEquals(officeDescription.text(), "Московский офис");
    }

    @Step("Кликаем на имя города с филиалом, {0}")
    public void clickOnCityName(String value) {
        String cityLocator = String.format("//div[contains(@class,'visible-lg')]//a[contains(text(),'%s')]", value);
        $x(cityLocator).shouldBe(visible);
        $x(cityLocator).click();
    }


    @Step("Проверяем, что появилась информация о конкретном филиале {0}")
    public void checkOfficeName(String value) {
        Assertions.assertEquals(value, officeDescription.text());
    }

}
