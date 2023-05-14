package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static helpers.GeneralMethods.setBannerCookie;

public class AutomatedTestingPage {


    @Step("Проверяем открытие страницы с автоматизированным тестированием")
    public void openPage() {
        setBannerCookie();
        open("/Automation/AutomatedLabTesting");
    }

}
