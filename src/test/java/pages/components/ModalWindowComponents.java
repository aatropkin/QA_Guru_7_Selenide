package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalWindowComponents {

    private SelenideElement modalWindow = $(".modal-dialog"),
    tableResponsive = $(".table-responsive");
    public void checkResult(String key, String value) {
        modalWindow.should(appear);
        tableResponsive.$(byText(key)).parent()
                .shouldHave(text(value));
    }

}