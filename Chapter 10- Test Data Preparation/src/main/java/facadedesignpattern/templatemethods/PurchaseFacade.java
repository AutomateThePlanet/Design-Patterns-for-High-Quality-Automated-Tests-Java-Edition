package facadedesignpattern.templatemethods;

public abstract class PurchaseFacade {
    public void purchaseItem(String rocketName, String couponName, int quantity, String expectedPrice, PurchaseInfo purchaseInfo) throws InterruptedException {
        addItemToShoppingCart(rocketName);
        applyCoupon(couponName);
        assertCouponAppliedSuccessfully();
        increaseProductQuantity(quantity);
        assertTotalPrice(expectedPrice);
        proceedToCheckout();
        fillBillingInfo(purchaseInfo);
        assertOrderReceived();
    }

    protected abstract void addItemToShoppingCart(String itemName);
    protected abstract void applyCoupon(String couponName) throws InterruptedException;
    protected abstract void assertCouponAppliedSuccessfully();
    protected abstract void increaseProductQuantity(int quantity) throws InterruptedException;
    protected abstract void assertTotalPrice(String expectedPrice);
    protected abstract void proceedToCheckout();
    protected abstract void fillBillingInfo(PurchaseInfo purchaseInfo) throws InterruptedException;
    protected abstract void assertOrderReceived();
}
