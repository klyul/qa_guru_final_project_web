package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class VacanciesPage {

SelenideElement  searchInput = $("input#search_vacancy");
SelenideElement specialisationField = $("[data-id='select_group_id']");
SelenideElement cityField = $("[data-id='select_city_id']");
SelenideElement searchButton = $("button#search_vacancy");
SelenideElement checkboxOnlyHotVacancies = $("input#filter_only_hot_");
SelenideElement сheckboxRemoteVacancies = $("input#filter_only_remote_");


    @Step("Проверяем открытие страницы с вакансиями")
    public void openPage(){
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

    @Step("Проверяем открытие страницы с вакансиями")

}
