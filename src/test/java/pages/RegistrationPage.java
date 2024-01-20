package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.components.CalendarComponent;
import pages.components.ModalWindowComponents;


import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbyCheckBox = $("#hobbiesWrapper"),
            uploadPic = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitForm = $("#submit");
    CalendarComponent calendarComponent = new CalendarComponent();
    ModalWindowComponents modalWindowComponents = new ModalWindowComponents();
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }


    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbyCheckBox.$(byText(value)).click();

        return this;
    }
    public RegistrationPage uploadPicture(String value) {
        uploadPic.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setStateAndCity(String State, String City) {
        stateInput.setValue(State).pressEnter();
        cityInput.setValue(City).pressEnter();

        return this;
    }

    public RegistrationPage submitForm() {
        submitForm.click();

        return this;
    }

    public RegistrationPage checkValidation() {
        String warningColor = "rgb(220, 53, 69)";
        firstNameInput.shouldHave(cssValue("border-color", warningColor));
        lastNameInput.shouldHave(cssValue("border-color", warningColor));
        genderInput.$("label[for='gender-radio-1']").shouldHave(cssValue("border-color", warningColor)); //Male
        genderInput.$("label[for='gender-radio-2']").shouldHave(cssValue("border-color", warningColor)); //Female
        genderInput.$("label[for='gender-radio-3']").shouldHave(cssValue("border-color", warningColor)); //Other
        userNumberInput.shouldHave(cssValue("border-color", warningColor));
        return this;
    }


    public RegistrationPage checkResult(String key, String value) {
        modalWindowComponents.checkResult(key, value);

        return this;
    }

}
