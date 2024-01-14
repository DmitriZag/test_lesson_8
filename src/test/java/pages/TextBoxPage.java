package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    private SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitInput = $("#submit");
    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }
    public TextBoxPage setName(String value) {
        userNameInput.setValue(value);
        return this;
    }
    public TextBoxPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public TextBoxPage setAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    public TextBoxPage setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);
        return this;
    }
    public TextBoxPage submit() {
        submitInput.click();
        return this;
    }

    public TextBoxPage checkOutput(String id, String value) {
        $("#output #" + id).shouldHave(text(value));
        return this;
    }
}