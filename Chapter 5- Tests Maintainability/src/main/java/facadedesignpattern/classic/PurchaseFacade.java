package facadedesignpattern.classic;

import facadedesignpattern.classic.CartPage.CartPage;
import facadedesignpattern.classic.CheckoutPage.CheckoutPage;
import facadedesignpattern.classic.MainPage.MainPage;

public class PurchaseFacade {
    private final MainPage _mainPage;
    private final CartPage _cartPage;
    private final CheckoutPage _checkoutPage;

    public PurchaseFacade(MainPage mainPage, CartPage cartPage, CheckoutPage checkoutPage)
    {
        _mainPage = mainPage;
        _cartPage = cartPage;
        _checkoutPage = checkoutPage;
    }

    public void purchaseItem(String rocketName, String couponName, int quantity, String expectedPrice, PurchaseInfo purchaseInfo) throws InterruptedException {
        _mainPage.open();
        _mainPage.addRocketToShoppingCart(rocketName);
        _cartPage.applyCoupon(couponName);
        _cartPage.assertions().assertCouponAppliedSuccessfully();
        _cartPage.increaseProductQuantity(quantity);
        _cartPage.assertions().assertTotalPrice(expectedPrice);
        _cartPage.clickProceedToCheckout();
        _checkoutPage.fillBillingInfo(purchaseInfo);
        _checkoutPage.assertions().assertOrderReceived();
    }
}
