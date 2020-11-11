package facadedesignpattern.templatemethods.CartPage;

import configuration.UrlDeterminer;
import core.Driver;
import facadedesignpattern.templatemethods.NavigatableEShopPage;
import facadedesignpattern.templatemethods.Sections.BreadcrumbSection;

import java.io.IOException;
import java.net.URISyntaxException;

public class CartPage extends NavigatableEShopPage {
    public CartPage(Driver driver) {
        super(driver);
    }

    @Override
    protected String getUrl() throws IOException, URISyntaxException {
        return UrlDeterminer.getShopUrl("cart");
    }

    public CartPageAssertions assertions() {
        return new CartPageAssertions(elements());
    }

    public CartPageElements elements() {
        return new CartPageElements(driver);
    }

    public BreadcrumbSection breadcrumbSection() {
        return new BreadcrumbSection(driver);
    }

    public void applyCoupon(String coupon) throws InterruptedException {
        elements().couponCodeTextField().typeText(coupon);
        elements().applyCouponButton().click();
        driver.waitForAjax();
    }

    public void increaseProductQuantity(int newQuantity) throws InterruptedException {
        elements().quantityBox().typeText(String.valueOf(newQuantity));
        elements().updateCart().click();
        driver.waitForAjax();
    }

    public void clickProceedToCheckout()
    {
        elements().proceedToCheckout().click();
        driver.waitUntilPageLoadsCompletely();
    }

    public String getTotal()
    {
        return elements().totalSpan().getText();
    }

    public String getMessageNotification()
    {
        return elements().messageAlert().getText();
    }
}
