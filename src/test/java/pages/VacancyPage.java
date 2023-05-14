package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VacancyPage {

    SelenideElement citiesLine = $("p.careers_place");
    SelenideElement requirementsLine = $x("//p[contains(text(),'Требования')]");
    SelenideElement responsibilitiesLine = $x("//p[contains(text(),'Обязанности')]");
    SelenideElement conditionsLine = $x("//p[contains(text(),'Условия')]");


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
