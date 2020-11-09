package pages.v7.multifilepageobjectsectionsdriverinterfaces.CartPage;

import core.BrowserService;
import core.ElementFindService;
import core.NavigationService;
import pages.v7.multifilepageobjectsectionsdriverinterfaces.NavigatableEShopPage;
import pages.v7.multifilepageobjectsectionsdriverinterfaces.Sections.BreadcrumbSection;

public class CartPage extends NavigatableEShopPage {
    private final BrowserService _browserService;

    public CartPage(ElementFindService elementFindService, NavigationService navigationService, BrowserService browserService) {
        super(elementFindService, navigationService);
        _browserService = browserService;
    }

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
