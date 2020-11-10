package multifilepageobjectpagesectionsappfluent;

import core.Browser;
import multifilepageobjectpagesectionsappfluent.CartPage.CartPage;
import multifilepageobjectpagesectionsappfluent.MainPage.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPurchaseTestsWithPageObjects {
    private static App _app;

    @BeforeMethod
    public void testInit() {
        _app = new App(Browser.Chrome);
    }

    @AfterMethod
    public void testCleanup() throws Exception {
        _app.close();
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