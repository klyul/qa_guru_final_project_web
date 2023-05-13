package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

public class SearchResultsPage {

    @Step("Проверяем заголовки тэгов результатов поиска")
    public void shouldHaveSearchTitles(String value) {
        $$("h2").first().shouldHave(Condition.text("Поиск - " + value));
        $$("h2").get(1).shouldHave(Condition.text("Результаты поиска"));

    }

    @Step("Проверяем, что страница не содержит PHP warnings ")
    public int numberOfPhpWarnings() {
        return $$x("//b[contains(text(),'Warning')]").size();
    }
}
