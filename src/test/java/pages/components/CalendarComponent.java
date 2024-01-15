package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;



public class CalendarComponent {
    private SelenideElement yearSelector = $(".react-datepicker__year-select"),
            monthSelector = $(".react-datepicker__month-select"),
            daySelector = $(".react-datepicker__month:not(.datepicker__day--outside-month");

    public void setDate(String day, String month, String year) {
        yearSelector.selectOption(year);
        monthSelector.selectOption(month);
        daySelector.$(byText(day)).click();
    }
}
