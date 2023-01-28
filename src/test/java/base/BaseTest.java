package base;

import com.microsoft.playwright.Page;
import factory.PlaywrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import pages.LoginPage;

import java.util.Properties;

public class BaseTest {

    protected Page page;
    protected Properties prop;
    protected HomePage homePage;
    protected LoginPage loginPage;
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
    @BeforeTest
    public void setup() {
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }

}
