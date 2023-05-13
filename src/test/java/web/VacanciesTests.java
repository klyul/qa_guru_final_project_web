package web;

import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.VacanciesPage;

public class VacanciesTests extends TestBaseBint {
    VacanciesPage vacanciesPage = new VacanciesPage();

    @Test
    @DisplayName("Проверяем открытие страницы и присутствие её элементов")
    void vacanciesPageOpeningTests() {
        vacanciesPage.openPage();
        vacanciesPage.mainElementsShouldBePresent();
    }
}
