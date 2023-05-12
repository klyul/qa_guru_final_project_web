package components;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class TopMenu {
    SelenideElement careerHeaeder = $x("//span[@class='top-menu_item_title']/span[contains(text(),'Карьера')]");
    SelenideElement menuItemJobs = $x("//li/a[contains(text(),'Вакансии')]"),
            menuItemRecruiters = $x("//li/a[contains(text(),'Обучение')]"),
            menuItemTeaching = $x("//li/a[contains(text(),'Рекрутерам')]"),
            menuItemBringAFriend = $x("//li/a[contains(text(),'Акция \"Приведи друга\"')]");


    @Step("Проверяем что присутствуют элементы меню Карьера, Вакансии, Обучение, Рекрутерам, Акция Приведи Друга")
    public void menuItemsShouldBePresent() {
        menuItemJobs.shouldBe(visible);
        menuItemJobs.shouldBe(interactable);
        menuItemRecruiters.shouldBe(interactable);
        menuItemTeaching.shouldBe(interactable);
        menuItemBringAFriend.shouldBe(interactable);
    }
}
