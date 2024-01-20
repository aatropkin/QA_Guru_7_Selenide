package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import testdata.TestData;


public class RegistrationTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();


    @Test
    void fullFormRegistrationTest() {

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.birthDay, testData.birthMonth, testData.birthYear)
                .setSubject(testData.subject)
                .setHobbies(testData.hobby)
                .uploadPicture(testData.picture)
                .setAddress(testData.address)
                .setStateAndCity(testData.state, testData.city)
                .submitForm()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.birthDay + " " + testData.birthMonth + "," + testData.birthYear)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobby)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state + " " + testData.city);
    }

    @Test
    void minimalFormRegistrationTest() {

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.birthDay, testData.birthMonth, testData.birthYear)
                .submitForm()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.birthDay + " " + testData.birthMonth + "," + testData.birthYear);
    }

    @Test
    void emptyFromRegistrationTest() {
        registrationPage.openPage()
                .submitForm()
                .checkValidation();
    }


}