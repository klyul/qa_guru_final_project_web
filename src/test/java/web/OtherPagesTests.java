package web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AutomatedTestingPage;
import pages.ContactPage;
import pages.TrainingPage;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OtherPagesTests extends TestBaseBint {
    TrainingPage trainingPage = new TrainingPage();
    ContactPage contactPage = new ContactPage();
    AutomatedTestingPage automatedTestingPage = new AutomatedTestingPage();


    @Test
    @DisplayName("Проверяем открытие страницы с обучением и присутствие её элементов")
    void checkOpeningTrainingPage() {
        trainingPage.openPage();
        trainingPage.mainElementsShouldBePresent();
    }

    @Test
    @DisplayName("Проверяем открытие страницы с контактами и присутствие её элементов")
    void checkOpeningContactPage() {
        contactPage.openPage();
        contactPage.mainElementsShouldBePresent();


    }

    @Test
    @DisplayName("Проверяем открытие страницы с автоматизированным тестированием и присутствие её элементов")
    void checkOpeningAutomatedTestingPage() {
        automatedTestingPage.openPage();
        automatedTestingPage.mainElementsShouldBePresent();
    }
    @Test
    @DisplayName("Проверяем что по клику на конкретный город открывается конкретный филиал")
    void checkShowingParticularOffice() {
        contactPage.openPage();
        contactPage.clickOnCityName("Пенза");
        contactPage.checkOfficeName("Пензенский офис");
    }
}
