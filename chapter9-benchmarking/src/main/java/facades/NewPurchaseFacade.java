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

package facades;

import facades.CartPage.CartPage;
import facades.CheckoutPage.CheckoutPage;
import facades.MainPage.MainPage;

public class NewPurchaseFacade extends PurchaseFacade {
    private final MainPage mainPage;
    private final CartPage cartPage;
    private final CheckoutPage checkoutPage;

    public NewPurchaseFacade(MainPage mainPage, CartPage cartPage, CheckoutPage checkoutPage) {
        this.mainPage = mainPage;
        this.cartPage = cartPage;
        this.checkoutPage = checkoutPage;
    }

    @Override
    protected void addItemToShoppingCart(String itemName) {
        mainPage.open();
        mainPage.addRocketToShoppingCart(itemName);
    }

    @Override
    protected void applyCoupon(String couponName) throws InterruptedException {
        cartPage.applyCoupon(couponName);
    }

    @Override
    protected void assertCouponAppliedSuccessfully() {
        cartPage.assertions().assertCouponAppliedSuccessfully();
    }

    @Override
    protected void increaseProductQuantity(int quantity) throws InterruptedException {
        cartPage.increaseProductQuantity(quantity);
    }

    @Override
    protected void assertTotalPrice(String expectedPrice) {
        cartPage.assertions().assertTotalPrice(expectedPrice);
    }

    @Override
    protected void proceedToCheckout() {
        cartPage.clickProceedToCheckout();
    }

    @Override
    protected void fillBillingInfo(PurchaseInfo purchaseInfo) throws InterruptedException {
        checkoutPage.fillBillingInfo(purchaseInfo);
    }

    @Override
    protected void assertOrderReceived() {
        checkoutPage.assertions().assertOrderReceived();
    }
}
