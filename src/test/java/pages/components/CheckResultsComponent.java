package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckResultsComponent {
   private SelenideElement tableResult = $(".table-responsive");

        public void checkResult(String field, String value) {

            tableResult.$(byText(field)).parent()
                    .shouldHave(text(value));
        }
}
