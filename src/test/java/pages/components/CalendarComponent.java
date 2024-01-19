package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private String dayIn = "1";
    private SelenideElement monthInput = $(".react-datepicker__month-select"),
            yearInput = $(".react-datepicker__year-select"),
            dayInput = $(".react-datepicker__day--0" + dayIn + ":not(.react-datepicker__day--outside-month)");

    public void setDate(String day, String month, String year) {
        dayIn = day;
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        dayInput.click();

    }
}