package web;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.VacanciesPage;
import pages.VacanciesResultPage;

public class VacanciesTests extends TestBaseBint {


    VacanciesPage vacanciesPage = new VacanciesPage();
    VacanciesResultPage vacanciesResultPage = new VacanciesResultPage();

    @BeforeEach
    void openVacanciesPage() {
        vacanciesPage.openPage();
    }

    @Test
    @DisplayName("Проверяем открытие страницы и присутствие её элементов")
    void vacanciesPageOpeningTests() {
        vacanciesPage.mainElementsShouldBePresent();
    }

    @Test
    @DisplayName("Проверяем работу фильтра со специализацией Аналитик")
    void checkSearchByVacationType() {
        vacanciesPage.searchAnalyticVacancies("Аналитики");
        vacanciesPage.checkFoundVacanciesTypeByText("Аналитики");



    }

    @Test
    @DisplayName("Проверяем работу фильтра с локацией Москва")
    void checkSearchByLocationMoscowType() {
        vacanciesResultPage.searchMoscowVacancies("Москва");

    }
}
