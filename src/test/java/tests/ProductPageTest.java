package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProductPageTest extends BaseTest {

    @Test(priority = 1)
    public void selectProductTest() {
        loginPage.loginToApplication(prop.getProperty("username"), prop.getProperty("password"));
        productPage.selectJacket();
        productPage.selectSpecificProduct("Montana Wind Jacket", "M", "Green");
        assertThat(productPage.getProductAddedMsgLocator()).hasText("You added Montana Wind Jacket to your shopping cart.");

        productPage.selectJacket();
        productPage.selectSpecificProduct("Lando Gym Jacket", "L", "Blue");
        assertThat(productPage.getProductAddedMsgLocator()).hasText("You added Lando Gym Jacket to your shopping cart.");

        productPage.selectPant();
        productPage.selectSpecificProduct("Zeppelin Yoga Pant", "32", "Red");
        assertThat(productPage.getProductAddedMsgLocator()).hasText("You added Zeppelin Yoga Pant to your shopping cart.");
    }
}
