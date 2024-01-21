package tests;

import data.RandomData;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomData randomData = new RandomData();

    @Test
    void fillPracticeFormTest() {

        registrationPage.openPage()
                .setFirstName(randomData.firstName)
                .setLastName(randomData.lastName)
                .setEmail(randomData.email)
                .setGender(randomData.gender)
                .setUserNumber(randomData.phone)
                .setDateOfBirth(randomData.birthDay, randomData.birthMonth, randomData.birthYear)
                .setSubjects(randomData.subjects)
                .setHobbies(randomData.hobbies)
                .setPicture("screen.jpg")
                .setCurrentAddress(randomData.address)
                .setState(randomData.state)
                .setCity(randomData.city)
                .submit();

        registrationPage.checkResult("Student Name", randomData.firstName + " " + randomData.lastName)
                .checkResult("Student Email", randomData.email)
                .checkResult("Gender", randomData.gender)
                .checkResult("Mobile", randomData.phone)
                .checkResult("Date of Birth", randomData.birthDay + " " + randomData.birthMonth + "," + randomData.birthYear)
                .checkResult("Subjects", randomData.subjects)
                .checkResult("Hobbies", randomData.hobbies)
                .checkResult("Picture","screen.jpg")
                .checkResult("Address", randomData.address)
                .checkResult("State and City", randomData.state + " " + randomData.city);

    }

    @Test
    void fillRequiredPracticeFormTest() {
        registrationPage.openPage()
                .setFirstName(randomData.firstName)
                .setLastName(randomData.lastName)
                .setEmail(randomData.email)
                .setGender(randomData.gender)
                .setUserNumber(randomData.phone)
                .setDateOfBirth(randomData.birthDay, randomData.birthMonth, randomData.birthYear)
                .submit();

        registrationPage.checkResult("Student Name", randomData.firstName + " " + randomData.lastName)
                .checkResult("Student Email", randomData.email)
                .checkResult("Gender", randomData.gender)
                .checkResult("Mobile", randomData.phone)
                .checkResult("Date of Birth", randomData.birthDay + " " + randomData.birthMonth + "," + randomData.birthYear)
                .registrationSuccessCheck();
    }

    @Test
    void allFieldsAreEmptyTest() {
        registrationPage.openPage()
                .submit();

        registrationPage.registrationFailCheck();
    }
}

