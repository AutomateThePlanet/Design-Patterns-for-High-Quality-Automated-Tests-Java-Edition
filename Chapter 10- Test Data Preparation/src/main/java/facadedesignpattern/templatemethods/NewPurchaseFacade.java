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

package facadedesignpattern.templatemethods;

import facadedesignpattern.templatemethods.CartPage.CartPage;
import facadedesignpattern.templatemethods.CheckoutPage.CheckoutPage;
import facadedesignpattern.templatemethods.MainPage.MainPage;

import java.io.IOException;
import java.net.URISyntaxException;

public class NewPurchaseFacade extends PurchaseFacade {
    private final MainPage _mainPage;
    private final CartPage _cartPage;
    private final CheckoutPage _checkoutPage;

    public NewPurchaseFacade(MainPage mainPage, CartPage cartPage, CheckoutPage checkoutPage)
    {
        _mainPage = mainPage;
        _cartPage = cartPage;
        _checkoutPage = checkoutPage;
    }

    @Override
    protected void addItemToShoppingCart(String itemName) throws IOException, URISyntaxException {
        _mainPage.open();
        _mainPage.addRocketToShoppingCart(itemName);
    }

    @Override
    protected void applyCoupon(String couponName) throws InterruptedException {
        _cartPage.applyCoupon(couponName);
    }

    @Override
    protected void assertCouponAppliedSuccessfully() {
        _cartPage.assertions().assertCouponAppliedSuccessfully();
    }

    @Override
    protected void increaseProductQuantity(int quantity) throws InterruptedException {
        _cartPage.increaseProductQuantity(quantity);
    }

    @Override
    protected void assertTotalPrice(String expectedPrice) {
        _cartPage.assertions().assertTotalPrice(expectedPrice);
    }

    @Override
    protected void proceedToCheckout() {
        _cartPage.clickProceedToCheckout();
    }

    @Override
    protected void fillBillingInfo(PurchaseInfo purchaseInfo) throws InterruptedException {
        _checkoutPage.fillBillingInfo(purchaseInfo);
    }

    @Override
    protected void assertOrderReceived() {
        _checkoutPage.assertions().assertOrderReceived();
    }
}
