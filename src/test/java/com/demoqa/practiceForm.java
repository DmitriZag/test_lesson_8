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
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Дмитрий\\.cache\\selenium\\chromedriver\\win64\\120.0.6099.109\\chromedriver");
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov88@mail.ru");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("9119991919");
        $("#dateOfBirthInput").click();

    }

}

