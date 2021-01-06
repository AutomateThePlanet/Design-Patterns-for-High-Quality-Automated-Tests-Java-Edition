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
