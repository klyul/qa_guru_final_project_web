package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static helpers.GeneralMethods.setBannerCookie;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VacanciesPage {

    private final SelenideElement  searchInput = $("input#search_vacancy");
    private final SelenideElement specialisationField = $("[data-id='select_group_id']");
    private final SelenideElement specializationDropdown = $("ul[aria-expanded=\"true\"]");
    private final SelenideElement cityField = $("[data-id='select_city_id']");
    private final SelenideElement searchButton = $("button#search_vacancy");
    private final SelenideElement checkboxOnlyHotVacancies = $("input#filter_only_hot_");
    private final SelenideElement сheckboxRemoteVacancies = $("input#filter_only_remote_");
    private final SelenideElement locationField = $("[data-id='select_city_id']");
    private final SelenideElement locationDropdown = $("ul[aria-expanded=\"true\"]");
    private final SelenideElement detailedLink = $x("//a[contains(text(),'Подробнее')]");


    @Step("Проверяем открытие страницы с вакансиями")
    public void openPage(){
        setBannerCookie();
        open("/index.php?route=information/vacancies#select_form");
    }

    @Step("Проверяем главные элементы страницы с вакансиями")
    public void mainElementsShouldBePresent() {
        searchInput.shouldBe(interactable);
        specialisationField.shouldBe(interactable);
        cityField.shouldBe(interactable);
        searchButton.shouldBe(interactable);
        checkboxOnlyHotVacancies.shouldBe(interactable);
        сheckboxRemoteVacancies.shouldBe(interactable);

    }

    @Step("Проверяем открытие вакансий по специализации Аналитики")
    public void searchAnalyticVacancies(String value) {
        specialisationField.click();
        specializationDropdown.$(byText(value)).click();
        searchButton.click();
    }

    @Step("Проверка, что вакансии имеют типу {0}")
    public void checkFoundVacanciesTypeByText(String value) {
        $$("tbody#vacancy_table tr td:nth-child(2)").shouldHave(CollectionCondition.sizeGreaterThan(0));
        List<String> tableTexts = $$("tbody#vacancy_table tr td:nth-child(2)").texts();
        assertTrue(tableTexts.stream().allMatch(e -> e.equals(value)));
    }

    @Step("Проверяем открытие вакансий по локации Москва")
    public void searchVacanciesByCity(String value) {
        locationField.click();
        locationDropdown.$(byText(value)).click();
        searchButton.click();
    }

    @Step("Открываем первую из вакансий по ссылке Подробнее")
    public void openFirstVacancy() {
        detailedLink.click();
    }
}
