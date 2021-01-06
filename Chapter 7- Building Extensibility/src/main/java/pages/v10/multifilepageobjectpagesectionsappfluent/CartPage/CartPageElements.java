/*
 * Copyright 2021 Automate The Planet Ltd.
 * Author: Anton Angelov
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pages.v10.multifilepageobjectpagesectionsappfluent.CartPage;

import core.Element;
import core.interfaces.ElementFindService;
import org.openqa.selenium.By;

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
