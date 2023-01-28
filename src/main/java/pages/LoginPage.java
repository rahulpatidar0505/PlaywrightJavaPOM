package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {

	private final Page page;
	private final Locator signInLink ;
	private final Locator email ;
	private final Locator password;
	private final Locator signInButton;


	public LoginPage(Page page) {
		this.page = page;
		this.signInLink =  page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign In"));
		this.email = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email*"));
		this.password = page.getByLabel("Password");
		this.signInButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In"));

	}

	public void loginToApplication(String appUserName, String appPassword) {
		this.signInLink.click();
		this.email.fill(appUserName);
		this.password.fill(appPassword);
		this.signInButton.waitFor();
		this.signInButton.click();
	}

}
