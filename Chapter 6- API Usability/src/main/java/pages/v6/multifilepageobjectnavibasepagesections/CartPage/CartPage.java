package pages.v6.multifilepageobjectnavibasepagesections.CartPage;

import core.Driver;
import pages.v6.multifilepageobjectnavibasepagesections.NavigatableEShopPage;
import pages.v7.multifilepageobjectsectionsdriverinterfaces.Sections.BreadcrumbSection;

public class CartPage extends NavigatableEShopPage {
    public CartPage(Driver driver) {
        super(driver);
    }

    @Override
    protected String getUrl() {
        return "http://demos.bellatrix.solutions/cart/";
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
