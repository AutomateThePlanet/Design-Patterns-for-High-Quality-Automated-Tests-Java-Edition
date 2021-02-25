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

package pages.v8.multifilepageobjectsectionssingleton.CartPage;

import core.BrowserService;
import pages.v8.multifilepageobjectsectionssingleton.LoggingSingletonDriver;
import pages.v8.multifilepageobjectsectionssingleton.NavigatableEShopPage;
import pages.v8.multifilepageobjectsectionssingleton.Sections.BreadcrumbSection;
import pages.v8.multifilepageobjectsectionssingleton.SingletonFactory;

import java.lang.reflect.InvocationTargetException;

public class CartPage extends NavigatableEShopPage {
    private static CartPage instance;
    private final BrowserService browserService = LoggingSingletonDriver.getInstance();

    public static CartPage getInstance() {
        if (instance == null) {
            instance = new CartPage();
        }

        return instance;
    }

    public static CartPage getInstanceFactory() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return SingletonFactory.getInstance(CartPage.class);
    }

    @Override
    protected String getUrl() {
        return "http://demos.bellatrix.solutions/cart/";
    }

    @Override
    protected void waitForPageLoad() {
        elements().couponCodeTextField().waitToExists();
    }

    public CartPageElements elements() {
        return new CartPageElements(elementFindService);
    }

    public BreadcrumbSection breadcrumbSection() {
        return new BreadcrumbSection(elementFindService);
    }

    public void applyCoupon(String coupon) throws InterruptedException {
        elements().couponCodeTextField().typeText(coupon);
        elements().applyCouponButton().click();
        browserService.waitForAjax();
    }

    public void increaseProductQuantity(int newQuantity) throws InterruptedException {
        elements().quantityBox().typeText(String.valueOf(newQuantity));
        elements().updateCart().click();
        browserService.waitForAjax();
    }

    public void clickProceedToCheckout() {
        elements().proceedToCheckout().click();
        browserService.waitUntilPageLoadsCompletely();
    }

    public String getTotal() {
        return elements().totalSpan().getText();
    }

    public String getMessageNotification() {
        return elements().messageAlert().getText();
    }
}
