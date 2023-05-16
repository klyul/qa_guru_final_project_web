package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static helpers.GeneralMethods.setBannerCookie;

public class TrainingPage {

    private final SelenideElement trainingPageHeading = $("h1.f__h1");
    private final SelenideElement ourSchools = $x("//h2[contains(text(),'Наши школы')]");
    private final SelenideElement schoolDescription = $(".school_description");
    private final SelenideElement blockEntryInstruction = $("div.popast_text");


    @Step("Проверяем открытие страницы с обучением")
    public void openPage() {
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
