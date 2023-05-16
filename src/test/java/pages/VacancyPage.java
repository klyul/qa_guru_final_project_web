package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VacancyPage {

    private final SelenideElement citiesLine = $("p.careers_place");
    private final SelenideElement requirementsLine = $x("//p[contains(text(),'Требования')]");
    private final SelenideElement responsibilitiesLine = $x("//p[contains(text(),'Обязанности')]");
    private final SelenideElement conditionsLine = $x("//p[contains(text(),'Условия')]");


    @Step("Проверяем, что присутствуют главные элементы на странице вакансии")
    public void checkMainElements() {
        citiesLine.shouldBe(visible);
        requirementsLine.shouldBe(visible);
        responsibilitiesLine.shouldBe(visible);
        conditionsLine.shouldBe(visible);
    }

    @Step("Проверяем, что вакансия открывается для конкретного города")
    public void checkOpeningCityVacancy(String value) {
        assertTrue(citiesLine.text().contains(value));

    }
}
