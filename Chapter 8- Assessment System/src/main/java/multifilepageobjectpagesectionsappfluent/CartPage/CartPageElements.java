package multifilepageobjectpagesectionsappfluent.CartPage;

import core.Element;
import core.interfaces.ElementFindService;

public class CartPageElements {
    private final ElementFindService _elementFindService;

    public CartPageElements(ElementFindService elementFindService) {
        _elementFindService = elementFindService;
    }

    public Element couponCodeTextField() {
        return _elementFindService.findById("coupon_code");
    }

    public Element applyCouponButton() {
        return _elementFindService.findByCss("[value*='Apply coupon']");
    }

    public Element quantityBox() {
        return _elementFindService.findByCss("[class*='input-text qty text']");
    }

    public Element updateCart() {
        return _elementFindService.findByCss("[value*='Update cart']");
    }

    public Element messageAlert() {
        return _elementFindService.findByCss("[class*='woocommerce-message']");
    }

    public Element totalSpan() {
        return _elementFindService.findByXPath("//*[@class='order-total']//span");
    }

    public Element proceedToCheckout() {
        return _elementFindService.findByCss("[class*='checkout-button button alt wc-forward']");
    }
}
