package pages.v8.multifilepageobjectsectionssingleton.CartPage;

import core.BrowserService;
import core.ElementFindService;
import core.NavigationService;
import pages.v8.multifilepageobjectsectionssingleton.LoggingSingletonDriver;
import pages.v8.multifilepageobjectsectionssingleton.NavigatableEShopPage;
import pages.v8.multifilepageobjectsectionssingleton.Sections.BreadcrumbSection;

public class CartPage extends NavigatableEShopPage {
    private static CartPage _instance;
    private final BrowserService _browserService;

    private CartPage(ElementFindService elementFindService, NavigationService navigationService, BrowserService browserService) {
        super(elementFindService, navigationService);
        _browserService = browserService;
    }

    public static CartPage getInstance()
    {
        if (_instance == null)
        {
            _instance = new CartPage(LoggingSingletonDriver.getInstance(), LoggingSingletonDriver.getInstance(), LoggingSingletonDriver.getInstance());
        }

        return _instance;
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
