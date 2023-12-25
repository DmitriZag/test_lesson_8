package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;

import java.io.File;

public class practiceForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
        Configuration.browserVersion = "120";
    }


    @Test
    void fillPracticeForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov88@mail.ru");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("9119991919");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(7);
        $(".react-datepicker__year-select").selectOption(88);
        $(".react-datepicker__day--023").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbies-checkbox-2").parent().click();
        $("#uploadPicture").uploadFromClasspath("screen.jpg");
        $("#currentAddress").setValue("Test");
        $("#state").click();
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Karnal").pressEnter();
        $("#submit").click();

//check
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Ivan Ivanov"));
        $(".table-responsive").shouldHave(text("ivanov88@mail.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9119991919"));
        $(".table-responsive").shouldHave(text("23 August,1988"));
        $(".table-responsive").shouldHave(text("Test"));
        $(".table-responsive").shouldHave(text("screen.jpg"));
        $(".table-responsive").shouldHave(text("Test"));
        $(".table-responsive").shouldHave(text("Haryana Karnal"));
    }

}

