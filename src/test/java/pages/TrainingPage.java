package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static helpers.GeneralMethods.setBannerCookie;

public class TrainingPage {

    SelenideElement trainingPageHeading = $("h1.f__h1");
    SelenideElement ourSchools = $x("//h2[contains(text(),'Наши школы')]");
    SelenideElement schoolDescription = $(".school_description");
    SelenideElement blockEntryInstruction = $("div.popast_text");




    @Step("Проверяем открытие страницы с обучением")
    public void openPage(){
        setBannerCookie();
        open("/?route=information/training");
    }
    @Step("Проверяем главные элементы страницы с обучением")
    public void mainElementsShouldBePresent() {
        trainingPageHeading.shouldBe(visible);
        ourSchools.shouldBe(visible);
        schoolDescription.shouldBe(visible);
        blockEntryInstruction.shouldBe(visible);

    }
}
