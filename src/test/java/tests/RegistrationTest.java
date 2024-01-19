package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideWait;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.sleep;


public class RegistrationTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fullFormRegistrationTest() {

        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Petrov")
                .setEmail("test@mail.ru")
                .setGender("Other")
                .setUserNumber("1234567890")
                .setDateOfBirth("9", "July", "1998")
                .setSubject("Maths")
                .setHobbies("Sports")
                .uploadPicture("1.jpg")
                .setAddress("1523 Stellar Dr, Kenai, Alaska 99611, USA")
                .setStateAndCity("NCR", "Gurgaon")
                .submitForm()
                .checkResult("Student Name", "Alex Petrov")
                .checkResult("Student Email", "test@mail.ru")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "9 July,1998")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "1.jpg")
                .checkResult("Address", "1523 Stellar Dr, Kenai, Alaska 99611, USA")
                .checkResult("State and City", "NCR Gurgaon");
  }

    @Test
    void minimalFormRegistrationTest() {

        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Petrov")
                .setGender("Other")
                .setUserNumber("1234567890")
                .setDateOfBirth("30", "July", "2008")
                .submitForm()
                .checkResult("Student Name", "Alex Petrov")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "30 July,2008");
    }

    @Test
    void emptyFromRegistrationTest() {
        registrationPage.openPage()
                .submitForm()
                .checkValidation();
    }


}