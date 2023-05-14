package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class VacanciesResultPage {
    SelenideElement searchInput = $("input#search_vacancy");
    SelenideElement locationField = $("[data-id='select_city_id']");
    SelenideElement locationDropdown = $("ul[aria-expanded=\"true\"]");
    SelenideElement cityField = $("[data-id='select_city_id']");
}
