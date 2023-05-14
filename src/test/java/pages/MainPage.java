package pages;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.Attach.GeneralMethods.setBannerCookie;

public class MainPage {
    SelenideElement topMenuButton = $("div#top-menu");
    SelenideElement contactUsButton = $("button#stay_connect_open");
    SelenideElement topSearchButton = $("#search-open");
    SelenideElement topSearchInput = $("input[name=search]");


    @Step("Открываем главную страницу")
    public void openPage() {
        setBannerCookie();
        open("/");

    }

    @Step("Кликаем на главное меню")
    public void clickTopMenuButton(){
        topMenuButton.click();
    }

    @Step("Кликаем на Свяжитесь с нами")
    public void clickConntactUsButton(){contactUsButton.click();

    }

    @Step("Поиск на главной странице")
    public void searchFromMainPage(String value) {
        topSearchButton.shouldBe(Condition.interactable);
        topSearchButton.click();

        topSearchInput.sendKeys(value);
        topSearchInput.pressEnter();
    }


}
