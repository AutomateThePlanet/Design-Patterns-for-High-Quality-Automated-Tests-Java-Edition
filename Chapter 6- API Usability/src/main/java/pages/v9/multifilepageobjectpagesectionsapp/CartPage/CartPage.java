package pages.v9.multifilepageobjectpagesectionsapp.CartPage;

import core.BrowserService;
import pages.v9.multifilepageobjectpagesectionsapp.LoggingSingletonDriver;
import pages.v9.multifilepageobjectpagesectionsapp.NavigatableEShopPage;
import pages.v9.multifilepageobjectpagesectionsapp.Sections.BreadcrumbSection;

public class CartPage extends NavigatableEShopPage {
    private final BrowserService _browserService = LoggingSingletonDriver.getInstance();

    @Override
    protected String getUrl() {
        return "http://demos.bellatrix.solutions/cart/";
    }

    public CartPageElements elements() {
        return new CartPageElements(elementFindService);
    }

    public BreadcrumbSection breadcrumbSection() {
        return new BreadcrumbSection(elementFindService);
    }

    public void applyCoupon(String coupon) throws InterruptedException {
        elements().couponCodeTextField().typeText(coupon);
        elements().applyCouponButton().click();
        _browserService.waitForAjax();
    }

    public void increaseProductQuantity(int newQuantity) throws InterruptedException {
        elements().quantityBox().typeText(String.valueOf(newQuantity));
        elements().updateCart().click();
        _browserService.waitForAjax();
    }

    public void clickProceedToCheckout()
    {
        elements().proceedToCheckout().click();
        _browserService.waitUntilPageLoadsCompletely();
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
