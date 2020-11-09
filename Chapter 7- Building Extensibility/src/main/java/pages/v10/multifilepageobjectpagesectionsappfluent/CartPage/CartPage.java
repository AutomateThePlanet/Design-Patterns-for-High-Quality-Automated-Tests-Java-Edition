package pages.v10.multifilepageobjectpagesectionsappfluent.CartPage;

import core.interfaces.BrowserService;
import org.testng.Assert;
import core.LoggingSingletonDriver;
import pages.v10.multifilepageobjectpagesectionsappfluent.NavigatableEShopPage;
import pages.v10.multifilepageobjectpagesectionsappfluent.Sections.BreadcrumbSection;

public class CartPage extends NavigatableEShopPage {
    private final BrowserService _browserService = LoggingSingletonDriver.getInstance();

    @Override
    protected String getUrl() {
        return "http://demos.bellatrix.solutions/cart/";
    }

    public BreadcrumbSection breadcrumbSection() {
        return new BreadcrumbSection(elementFindService);
    }

    public CartPage applyCoupon(String coupon) throws InterruptedException {
        elements().couponCodeTextField().typeText(coupon);
        elements().applyCouponButton().click();
        _browserService.waitForAjax();
        return this;
    }

    public CartPage increaseProductQuantity(int newQuantity) throws InterruptedException {
        elements().quantityBox().typeText(String.valueOf(newQuantity));
        elements().updateCart().click();
        _browserService.waitForAjax();
        return this;
    }

    public CartPage clickProceedToCheckout()
    {
        elements().proceedToCheckout().click();
        _browserService.waitUntilPageLoadsCompletely();
        return this;
    }

    public String getTotal()
    {
        return elements().totalSpan().getText();
    }

    public String getMessageNotification()
    {
        return elements().messageAlert().getText();
    }


    public CartPage assertCouponAppliedSuccessfully()
    {
        Assert.assertEquals(getMessageNotification(), "Coupon code applied successfully.");
        return this;
    }

    public CartPage assertTotalPrice(String expectedPrice)
    {
        Assert.assertEquals(elements().totalSpan().getText(), expectedPrice);
        return this;
    }

    private CartPageElements elements() {
        return new CartPageElements(elementFindService);
    }
}
