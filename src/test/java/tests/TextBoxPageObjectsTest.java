package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Selenide.open;

public class TextBoxPageObjectsTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        textBoxPage.openPage()
                .setName("Alex")
                .setEmail("alex@egorov.com")
                .setAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .submit()

                .checkOutput("name", "Alex")
                .checkOutput("email", "alex@egorov.com")
                .checkOutput("currentAddress", "Some street 1")
                .checkOutput("permanentAddress", "Another street 1");
    }
}
