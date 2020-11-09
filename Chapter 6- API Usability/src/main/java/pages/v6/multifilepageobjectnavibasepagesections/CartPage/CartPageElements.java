package pages.v6.multifilepageobjectnavibasepagesections.CartPage;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;

public class CartPageElements {
    private final Driver _driver;

    public CartPageElements(Driver driver) {
        _driver = driver;
    }

    public Element couponCodeTextField() {
        return _driver.findElement(By.id("coupon_code"));
    }

    public Element applyCouponButton() {
        return _driver.findElement(By.cssSelector("[value*='Apply coupon']"));
    }

    public Element quantityBox() {
        return _driver.findElement(By.cssSelector("[class*='input-text qty text']"));
    }

    public Element updateCart() {
        return _driver.findElement(By.cssSelector("[value*='Update cart']"));
    }

    public Element messageAlert() {
        return _driver.findElement(By.cssSelector("[class*='woocommerce-message']"));
    }

    public Element totalSpan() {
        return _driver.findElement(By.xpath("//*[@class='order-total']//span"));
    }

    public Element proceedToCheckout() {
        return _driver.findElement(By.cssSelector("[class*='checkout-button button alt wc-forward']"));
    }
}
