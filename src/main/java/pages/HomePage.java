package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {

	private final Page page;
	private final String panelView;
	private final Locator myAccount;
	private final Locator editAddressLink;
	private final Locator firstName;
	private final Locator lastName;
	private final Locator phoneNumber;
	private final Locator state;
	private final Locator saveAddress;

	public HomePage(Page page) {
		this.page = page;
		this.panelView = "//div[@class='panel header']//button[@type='button']";
		this.myAccount = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("My Account"));
		this.editAddressLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Edit Address"));
		this.firstName = page.getByLabel("First Name");
		this.lastName = page.getByLabel("Last Name");
		this.phoneNumber = page.getByLabel("Phone Number");
		this.state = page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("State/Province\n*"));
		this.saveAddress = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Save Address"));
	}

	public String getHomePageTitle() {
		String title =  page.title();
		System.out.println("page title: " + title);
		return title;
	}

	public String getHomePageURL() {
		String url =  page.url();
		System.out.println("page url : " + url);
		return url;
	}

	public void editAddress() {
		page.locator(panelView).waitFor();
		page.hover(panelView);
		page.click(panelView);
		this.myAccount.click();
		this.editAddressLink.first().click();
		this.firstName.fill("testsss123");
		this.lastName.fill("Test4");
		this.phoneNumber.fill("12345678904");
		this.state.selectOption("553");
		this.saveAddress.click();
	}

	public void addressSavedMessage(){
		page.getByText("You saved the address.").click();
	}
	
//	public LoginPage navigateToLoginPage() {
//		page.click(myAccountLink);
//		page.click(loginLink);
//		return new LoginPage(page);
//	}

}
