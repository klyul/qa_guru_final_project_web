package web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.VacanciesPage;
import pages.VacancyPage;

public class VacanciesTests extends TestBaseBint {


    VacanciesPage vacanciesPage = new VacanciesPage();
    VacancyPage vacancyPage = new VacancyPage();


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
    void checkSearchByLocationMoscow() {
        vacanciesPage.searchVacanciesByCity("Москва");
        vacanciesPage.openFirstVacancy();
        vacancyPage.checkOpeningCityVacancy("Москва");
    }

    @Test
    @DisplayName("Проверяем главные элементы страницы вакансии")
    void checkMainElementOfVacancyPage() {
        vacanciesPage.openFirstVacancy();
        vacancyPage.checkMainElements();
    }
}
