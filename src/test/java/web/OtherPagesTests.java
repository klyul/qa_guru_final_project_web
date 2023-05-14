package web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ContactPage;
import pages.TrainingPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OtherPagesTests extends TestBaseBint {
    TrainingPage trainingPage = new TrainingPage();
    ContactPage contactPage = new ContactPage();

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
        assertTrue(cityDescription.text().contains(value));

    }
}
