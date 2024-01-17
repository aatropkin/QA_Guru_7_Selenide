package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setUserName("Anton")
                .setEmail("anton.test@gmail.com")
                .setCurrentAddress("Address test current")
                .setPermanentAddress("Address test permanent")
                .submitForm()
                .checkOutput("name", "Anton")
                .checkOutput("email", "anton.test@gmail.com")
                .checkOutput("currentAddress", "Address test current")
                .checkOutput("permanentAddress", "Address test permanent");

    }

}