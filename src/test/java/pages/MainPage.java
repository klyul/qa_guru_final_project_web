package pages;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    SelenideElement topMenuButton = $("div#top-menu");
    SelenideElement contactUsButton = $("button#stay_connect_open");


    @Step("Открываем главную страницу")
    public void openPage() {
        open("/");
    }

    @Step("Кликаем на главное меню")
    public void clickTopMenuButton(){
        topMenuButton.click();
    }

    @Step("Кликаем на Свяжитесь с нами")
    public void clickConntactUsButton(){
        contactUsButton.click();
    }

}
