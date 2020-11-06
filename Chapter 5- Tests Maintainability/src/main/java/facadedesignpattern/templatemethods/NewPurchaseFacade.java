package facadedesignpattern.templatemethods;

import facadedesignpattern.templatemethods.CartPage.CartPage;
import facadedesignpattern.templatemethods.CheckoutPage.CheckoutPage;
import facadedesignpattern.templatemethods.MainPage.MainPage;

public class NewPurchaseFacade extends PurchaseFacade {
    private final MainPage _mainPage;
    private final CartPage _cartPage;
    private final CheckoutPage _checkoutPage;

    public NewPurchaseFacade(MainPage mainPage, CartPage cartPage, CheckoutPage checkoutPage)
    {
        _mainPage = mainPage;
        _cartPage = cartPage;
        _checkoutPage = checkoutPage;
    }

    @Override
    protected void addItemToShoppingCart(String itemName) {
        _mainPage.open();
        _mainPage.addRocketToShoppingCart(itemName);
    }

    @Override
    protected void applyCoupon(String couponName) throws InterruptedException {
        _cartPage.applyCoupon(couponName);
    }

    @Override
    protected void assertCouponAppliedSuccessfully() {
        _cartPage.assertions().assertCouponAppliedSuccessfully();
    }

    @Override
    protected void increaseProductQuantity(int quantity) throws InterruptedException {
        _cartPage.increaseProductQuantity(quantity);
    }

    @Override
    protected void assertTotalPrice(String expectedPrice) {
        _cartPage.assertions().assertTotalPrice(expectedPrice);
    }

    @Override
    protected void proceedToCheckout() {
        _cartPage.clickProceedToCheckout();
    }

    @Override
    protected void fillBillingInfo(PurchaseInfo purchaseInfo) throws InterruptedException {
        _checkoutPage.fillBillingInfo(purchaseInfo);
    }

    @Override
    protected void assertOrderReceived() {
        _checkoutPage.assertions().assertOrderReceived();
    }
}
