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

package pages.v11.multifilepageobjectnavibasepagegeneric.CartPage;

import core.Driver;
import pages.v11.multifilepageobjectnavibasepagegeneric.NavigatableAssertableEShopPage;
import pages.v11.multifilepageobjectnavibasepagegeneric.NavigatableEShopPage;
import pages.v3.singlefilepageobjectssections.Sections.BreadcrumbSection;

//public class CartPage extends NavigatableAssertableEShopPage<CartPageElements, CartPageAssertions> {
public class CartPage extends NavigatableEShopPage<CartPageElements> {
    public CartPage(Driver driver) {
        super(driver);
    }

    @Override
    protected String getUrl() {
        return "http://demos.bellatrix.solutions/cart/";
    }

    public BreadcrumbSection breadcrumbSection() {
        return new BreadcrumbSection(driver);
    }

    @Override
    protected void waitForPageLoad() {
        elements().couponCodeTextField().waitToExists();
    }

    public void applyCoupon(String coupon) throws InterruptedException {
        elements().couponCodeTextField().typeText(coupon);
        elements().applyCouponButton().click();
        driver.waitForAjax();
    }

    public void increaseProductQuantity(int newQuantity) throws InterruptedException {
        elements().quantityBox().typeText(String.valueOf(newQuantity));
        elements().updateCart().click();
        driver.waitForAjax();
    }

    public void clickProceedToCheckout() {
        elements().proceedToCheckout().click();
        driver.waitUntilPageLoadsCompletely();
    }

    public String getTotal() {
        return elements().totalSpan().getText();
    }

    public String getMessageNotification() {
        return elements().messageAlert().getText();
    }
}
