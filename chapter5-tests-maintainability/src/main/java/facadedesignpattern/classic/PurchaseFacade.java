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

package facadedesignpattern.classic;

import facadedesignpattern.classic.CartPage.CartPage;
import facadedesignpattern.classic.CheckoutPage.CheckoutPage;
import facadedesignpattern.classic.MainPage.MainPage;

public class PurchaseFacade {
    private final MainPage mainPage;
    private final CartPage cartPage;
    private final CheckoutPage checkoutPage;

    public PurchaseFacade(MainPage mainPage, CartPage cartPage, CheckoutPage checkoutPage) {
        this.mainPage = mainPage;
        this.cartPage = cartPage;
        this.checkoutPage = checkoutPage;
    }

    public void verifyItemPurchase(String rocketName, String couponName, int quantity, String expectedPrice, PurchaseInfo purchaseInfo) throws InterruptedException {
        mainPage.open();
        mainPage.addRocketToShoppingCart(rocketName);
        cartPage.applyCoupon(couponName);
        cartPage.assertions().assertCouponAppliedSuccessfully();
        cartPage.increaseProductQuantity(quantity);
        cartPage.assertions().assertTotalPrice(expectedPrice);
        cartPage.clickProceedToCheckout();
        checkoutPage.fillBillingInfo(purchaseInfo);
        checkoutPage.assertions().assertOrderReceived();
    }
}
