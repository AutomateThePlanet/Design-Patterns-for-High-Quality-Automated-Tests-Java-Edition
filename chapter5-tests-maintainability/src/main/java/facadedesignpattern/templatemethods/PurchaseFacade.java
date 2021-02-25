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

public abstract class PurchaseFacade {
    public void purchaseItem(String rocketName, String couponName, int quantity, String expectedPrice, PurchaseInfo purchaseInfo) throws InterruptedException {
        addItemToShoppingCart(rocketName);
        applyCoupon(couponName);
        assertCouponAppliedSuccessfully();
        increaseProductQuantity(quantity);
        assertTotalPrice(expectedPrice);
        proceedToCheckout();
        fillBillingInfo(purchaseInfo);
        assertOrderReceived();
    }

    protected abstract void addItemToShoppingCart(String itemName);

    protected abstract void applyCoupon(String couponName) throws InterruptedException;

    protected abstract void assertCouponAppliedSuccessfully();

    protected abstract void increaseProductQuantity(int quantity) throws InterruptedException;

    protected abstract void assertTotalPrice(String expectedPrice);

    protected abstract void proceedToCheckout();

    protected abstract void fillBillingInfo(PurchaseInfo purchaseInfo) throws InterruptedException;

    protected abstract void assertOrderReceived();
}
