package pages.v0.singlefilepageobject;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;

public class CartPage {
    private final Driver _driver;

    public CartPage(Driver driver) {
        _driver = driver;
    }

    public void applyCoupon(String coupon) throws InterruptedException {
        couponCodeTextField().typeText(coupon);
        applyCouponButton().click();
        _driver.waitForAjax();
    }

    public void IncreaseProductQuantity(int newQuantity) throws InterruptedException {
        quantityBox().typeText(String.valueOf(newQuantity));
        updateCart().click();
        _driver.waitForAjax();
    }

    public void ClickProceedToCheckout()
    {
        proceedToCheckout().click();
        _driver.waitUntilPageLoadsCompletely();
    }

    public String GetTotal()
    {
        return totalSpan().getText();
    }


    public String GetMessageNotification()
    {
        return messageAlert().getText();
    }

    private Element couponCodeTextField() {
        return _driver.findElement(By.id("coupon_code"));
    }

    private Element applyCouponButton() {
        return _driver.findElement(By.cssSelector("[value*='Apply coupon']"));
    }

    private Element quantityBox() {
        return _driver.findElement(By.cssSelector("[class*='input-text qty text']"));
    }

    private Element updateCart() {
        return _driver.findElement(By.cssSelector("[value*='Update cart']"));
    }

    private Element messageAlert() {
        return _driver.findElement(By.cssSelector("[class*='woocommerce-message']"));
    }

    private Element totalSpan() {
        return _driver.findElement(By.xpath("//*[@class='order-total']//span"));
    }

    private Element proceedToCheckout() {
        return _driver.findElement(By.cssSelector("[class*='checkout-button button alt wc-forward']"));
    }
}
