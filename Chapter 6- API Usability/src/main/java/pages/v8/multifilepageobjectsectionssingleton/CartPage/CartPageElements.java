package pages.v8.multifilepageobjectsectionssingleton.CartPage;

import core.Element;
import core.ElementFindService;
import org.openqa.selenium.By;

public class CartPageElements {
    private final ElementFindService _elementFindService;

    public CartPageElements(ElementFindService elementFindService) {
        _elementFindService = elementFindService;
    }

    public Element couponCodeTextField() {
        return _elementFindService.findElement(By.id("coupon_code"));
    }

    public Element applyCouponButton() {
        return _elementFindService.findElement(By.cssSelector("[value*='Apply coupon']"));
    }

    public Element quantityBox() {
        return _elementFindService.findElement(By.cssSelector("[class*='input-text qty text']"));
    }

    public Element updateCart() {
        return _elementFindService.findElement(By.cssSelector("[value*='Update cart']"));
    }

    public Element messageAlert() {
        return _elementFindService.findElement(By.cssSelector("[class*='woocommerce-message']"));
    }

    public Element totalSpan() {
        return _elementFindService.findElement(By.xpath("//*[@class='order-total']//span"));
    }

    public Element proceedToCheckout() {
        return _elementFindService.findElement(By.cssSelector("[class*='checkout-button button alt wc-forward']"));
    }
}
