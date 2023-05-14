package web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TrainingPage;

public class OtherPagesTests extends TestBaseBint {
    TrainingPage trainingPage = new TrainingPage();

    @Test
    @DisplayName("Проверяем открытие страницы с обучением и присутствие её элементов")
    void checkOpeningTrainingPage() {
        trainingPage.openPage();
        trainingPage.mainElementsShouldBePresent();
    }
}
