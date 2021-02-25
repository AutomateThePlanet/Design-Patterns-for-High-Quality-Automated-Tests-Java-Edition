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

public class CartPageElements {
    private final ElementFindService elementFindService;

    public CartPageElements(ElementFindService elementFindService) {
        this.elementFindService = elementFindService;
    }

    public Element couponCodeTextField() {
        return elementFindService.findById("coupon_code");
    }

    public Element applyCouponButton() {
        return elementFindService.findByCss("[value*='Apply coupon']");
    }

    public Element quantityBox() {
        return elementFindService.findByCss("[class*='input-text qty text']");
    }

    public Element updateCart() {
        return elementFindService.findByCss("[value*='Update cart']");
    }

    public Element messageAlert() {
        return elementFindService.findByCss("[class*='woocommerce-message']");
    }

    public Element totalSpan() {
        return elementFindService.findByXPath("//*[@class='order-total']//span");
    }

    public Element proceedToCheckout() {
        return elementFindService.findByCss("[class*='checkout-button button alt wc-forward']");
    }
}
