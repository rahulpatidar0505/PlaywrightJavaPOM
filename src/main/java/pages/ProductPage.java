package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ProductPage {
    private final Page page;
    private final Locator lc_men;
    private final Locator lc_tops;
    private final Locator lc_jackets;
    private final Locator lc_bottoms;
    private final Locator lc_pants;
    private final Locator lc_productAddedMsg;
    private final Locator lc_addToCartButton;
    private final Locator lc_cartLink;
    private final Locator lc_checkout;
    private final Locator lc_myOrder;
    private final Locator lc_productName;
    private final Locator lc_productPrice;

    public ProductPage(Page page) {
        this.page = page;
        this.lc_men = page.locator("//span[normalize-space()='Men']");
        this.lc_tops = page.locator("//a[contains(@href,'tops-men.html')]//span[contains(text(),'Tops')]");
        this.lc_jackets = page.locator("//a[contains(@href,'jackets-men.html')]//span[contains(text(),'Jackets')]");
        this.lc_bottoms = page.locator("//a[contains(@href,'bottoms-men.html')]//span[contains(text(),'Bottoms')]");
        this.lc_pants = page.locator("//a[contains(@href,'pants-men.html')]//span[contains(text(),'Pants')]");
        this.lc_productAddedMsg = page.locator("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
        this.lc_addToCartButton = page.locator("//span[normalize-space()='Add to Cart']");
        this.lc_cartLink = page.locator("//a[@class='action showcart']");
        this.lc_checkout = page.locator("//button[@id='top-cart-btn-checkout']");
        this.lc_myOrder = page.locator("//a[normalize-space()='My Orders']");
        this.lc_productName = page.locator("//h1[@class = 'page-title']//span[@itemprop=\"name\"]");
        this.lc_productPrice = page.locator("//div[contains(@class,'product-info-price')]//span[contains(@id,'product-price')]//span[@class='price']");
    }

    public String getProductName() {
        return this.lc_productName.textContent();
    }

    public String getProductPrice() {
        return this.lc_productPrice.textContent();
    }

    public void selectJacket() {
        this.lc_men.hover();
        this.lc_tops.hover();
        this.lc_jackets.click();
//        this.page.getByText("Men").first().hover();
//        this.page.getByLabel("Men").nth(2).focus();
//        page.getByRole(AriaRole.LISTITEM).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName("Men")).last().hover();
//        this.lc_jackets.click(new Locator.ClickOptions().setForce(true));
    }

    public void selectPant() {
        this.lc_men.waitFor();
        this.lc_men.hover();
        this.lc_bottoms.hover();
        this.lc_pants.click();
    }

    public Locator getProductAddedMsgLocator() {
        return this.lc_productAddedMsg;
    }

    public void selectSpecificProduct(String productName, String productSize, String productColor) {
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(productName)).first().click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(productSize)).first().click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName(productColor)).click();
        this.lc_addToCartButton.click();
    }

    public void goToCartAndCheckout() {
        this.lc_cartLink.click();
        this.lc_checkout.click();
    }

    public void goToMyOrders() {
        this.lc_myOrder.click();
    }
}
