package multifilepageobjectpagesectionsappfluent;

import configuration.*;
import core.Browser;
import multifilepageobjectpagesectionsappfluent.CartPage.CartPage;
import multifilepageobjectpagesectionsappfluent.MainPage.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class ProductPurchaseTestsWithPageObjects {
    private App _app;

    @BeforeMethod
    public void testInit() {
        _app = new App(Browser.Chrome);
    }

    @AfterMethod
    public void testCleanup() throws Exception {
        _app.close();
    }

    @Test
    public void testConfig() throws IOException, URISyntaxException {
        var appap = _app;
        var webSettings = ConfigurationService.get(WebSettings.class);
        var urlSettings = ConfigurationService.get(UrlSettings.class);
        var billingInfoDefaultValues = ConfigurationService.get(BillingInfoDefaultValues.class);
        System.out.print(webSettings);
        System.out.print(urlSettings);
        System.out.print(billingInfoDefaultValues);
        var part = UrlDeterminer.getAccountUrl("part1");
    }

    @Test
    public void completePurchaseSuccessfully_WhenNewClient() throws InterruptedException {
        var mainPage = _app.goTo(MainPage.class);

        mainPage.addRocketToShoppingCart();
        var cartPage = _app.goTo(CartPage.class);
        cartPage.applyCoupon("happybirthday")
                .assertCouponAppliedSuccessfully()
                .increaseProductQuantity(2)
                .assertTotalPrice("114.00€")
                .clickProceedToCheckout();

    }
}