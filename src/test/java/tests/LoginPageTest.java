package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import java.util.regex.Pattern;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void loginPageTitleTest() {
        assertThat(page).hasTitle(Pattern.compile("Home Page - Magento eCommerce - website to practice selenium"));
    }

    @Test(priority = 2)
    public void loginPageUrlTest() {
        assertThat(page).hasURL(Pattern.compile(".*magento"));
    }

    @Test(priority = 3)
    public void loginToApplication() {
        loginPage.loginToApplication(prop.getProperty("username"), prop.getProperty("password"));
    }

}
