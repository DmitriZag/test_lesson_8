package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;

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
        File test = new File("src/test/resources/Screenshot at Aug 28 13-08-24.png");
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov88@mail.ru");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("9119991919");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(7);
        $(".react-datepicker__year-select").selectOption(1988);
        $(".react-datepicker__day react-datepicker__day--023").click();
        $("#subjectsInput").setValue("Test");
        $("#hobbies-checkbox-2").click();
        $("#uploadPicture").uploadFile(test);


    }

}

