package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VacanciesResultPage {
    SelenideElement locationField = $("[data-id='select_city_id']");
    SelenideElement locationDropdown = $("ul[aria-expanded=\"true\"]");
    SelenideElement cityField = $("[data-id='select_city_id']");
    SelenideElement searchButton = $("button#search_vacancy");


    @Step("Проверяем открытие вакансий по локации Москва")
    public void searchMoscowVacancies(String value) {
        locationField.click();
        locationDropdown.$(byText(value)).click();
        List<String> tableTexts = $$("tbody#vacancy_table tr td:nth-child(2)").texts();
        assertFalse(tableTexts.stream().allMatch(e -> e.equals(value)));
        searchButton.click();
    }
}
