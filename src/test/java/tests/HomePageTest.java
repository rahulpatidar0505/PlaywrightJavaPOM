package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void editAddress() {
        loginPage.loginToApplication(prop.getProperty("username"), prop.getProperty("password"));
        homePage.editAddress();
    }
}
