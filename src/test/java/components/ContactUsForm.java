package components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$;

public class ContactUsForm {
    private final SelenideElement formTitle = $(".stay-form_title");
    private final SelenideElement firstNameInput = $("input[name=first_name]");
    private final SelenideElement lastNameInput = $("input[name=last_name]");
    private final SelenideElement emailInput = $("input[name=email]");
    private final SelenideElement sendFormButton = $("input#button_stay_connected");

    @Step("Проверяем главные элементы формы")
    public void checkRequiredFormElements() {
        formTitle.shouldBe(Condition.visible);
        firstNameInput.shouldBe(interactable);
        lastNameInput.shouldBe(interactable);
        emailInput.shouldBe(interactable);
        sendFormButton.shouldBe(interactable);

    }
}
