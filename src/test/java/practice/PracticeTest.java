package practice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PracticeTest {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    @BeforeTest
    public void launchApplication() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://rahulshettyacademy.com/AutomationPractice/");
    }

    /*
     * find all the rows, then using row locator, provide scope and with respect to your need, find some unique value/text and
     * write locator of your target element and perform operation(textContent() or click())
     */
    @Test
    public void handleWebTable() {
        Locator rowLocator = page.locator("//table[@id='product' and @name='courses']//tr");
        String text = rowLocator.locator(":scope", new Locator.LocatorOptions()
                        .setHasText("WebSecurity Testing for Beginners-QA knowledge to next level"))
                .locator("(//td[contains(text(),'20')])[1]").textContent();
        System.out.println(text);
    }

    @Test
    public void handleAutoSuggetion() {
        page.getByPlaceholder("Type to Select Countries").click();
        page.getByPlaceholder("Type to Select Countries").fill("ind");
        page.locator("//div[text()='India']").click();
    }

    @Test
    public void handleMouseOver() {
        this.page.getByText("Mouse Hover").last().hover();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Top")).click();
    }
    @Test
    public void Test() {

        page.locator("#dropdown-class-example").selectOption("option2");
        page.locator("#checkBoxOption3").check();
        page.getByPlaceholder("Enter Your Name").click();
        page.getByPlaceholder("Enter Your Name").fill("rahul");
        page.onceDialog(dialog -> {
            System.out.printf("Dialog message: %s%n", dialog.message());
            dialog.dismiss();
        });
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Alert")).click();
        page.onceDialog(dialog -> {
            System.out.printf("Dialog message: %s%n", dialog.message());
            dialog.dismiss();
        });
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Confirm")).click();

    }
}
