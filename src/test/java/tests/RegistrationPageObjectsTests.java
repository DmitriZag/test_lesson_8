package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillPracticeFormTest() {

        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("ivanov88@mail.ru")
                .setGender("Male")
                .setUserNumber("9119991919")
                .setDateOfBirth("23", "August", "1988")
                .setSubjects("Arts")
                .setHobbies("Music")
                .setPicture("screen.jpg")
                .setCurrentAddress("Test")
                .setState("Haryana")
                .setCity("Karnal")
                .submit();

        registrationPage.checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "ivanov88@mail.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9119991919")
                .checkResult("Date of Birth", "23 August,1988")
                .checkResult("Subjects", "Arts")
                .checkResult("Hobbies", "Music")
                .checkResult("Picture", "screen.jpg")
                .checkResult("Address", "Test")
                .checkResult("State and City", "Haryana Karnal");

    }

    @Test
    void fillRequiredPracticeFormTest() {
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setGender("Male")
                .setUserNumber("9119991919")
                .setDateOfBirth("23", "August", "1988")
                .submit();

        registrationPage.checkResult("Student Name", "Ivan Ivanov")
                .checkResult("Student Email", "\t")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9119991919")
                .checkResult("Date of Birth", "23 August,1988")
                .checkResult("Subjects", "\t")
                .checkResult("Hobbies", "\t")
                .checkResult("Picture", "\t")
                .checkResult("Address", "\t")
                .checkResult("State and City", "\t")
                .registrationSuccessCheck();
    }

    @Test
    void allFieldsAreEmptyTest() {
        registrationPage.openPage()
                .submit();

        registrationPage.registrationFailCheck();
    }
}

