package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private  SelenideElement monthInput = $(".react-datepicker__month-select");
    private  SelenideElement yearInput = $(".react-datepicker__year-select");

    public  void setDate(String day, String month, String year) {
        String dayIn = (Integer.parseInt(day) < 10) ? ("0"+day): day;
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        $(".react-datepicker__day--0" + dayIn+ ":not(.react-datepicker__day--outside-month)").click();
    }

}
