package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import factory.PlaywrightFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;

import java.util.Properties;

public class BaseTest {
    protected Browser browser;
    protected Page page;
    protected Properties prop;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected ProductPage productPage;
    PlaywrightFactory pf;

    //	@Parameters({ "browser" })
//	@BeforeTest
//	public void setup(String browserName) {
//		pf = new PlaywrightFactory();
//
//		prop = pf.init_prop();
//
//		if (browserName != null) {
//			prop.setProperty("browser", browserName);
//		}
//
//		page = pf.initBrowser(prop);
//		loginPage = new LoginPage(page);
//		homePage = new HomePage(page);
//
//	}

    @BeforeSuite
    public void setBrowser() {
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        browser = pf.initBrowser(prop);
    }

    /**
     Playwright has the concept of a BrowserContext which is an in-memory isolated browser profile.
     It's recommended to create a new BrowserContext for each test to ensure they don't interfere with each other.
     Browser context won't share anything, not store cahes/cookies and always open in in-cognito.
     Playwright and Browser instances can be reused between tests for better performance.
     We recommend running each test case in a new BrowserContext, this way browser state will be isolated between the tests.
     */
    @BeforeTest
    public void setPage() {
        page = pf.initPage(prop);
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
        productPage = new ProductPage(page);
    }

    @AfterTest
    public void closePage() {
        page.context().close();
    }

    @AfterSuite
    public void closeBrowser() {
        browser.close();
    }

}
