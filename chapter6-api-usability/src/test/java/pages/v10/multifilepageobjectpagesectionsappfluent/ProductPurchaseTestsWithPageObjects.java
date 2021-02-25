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

package pages.v10.multifilepageobjectpagesectionsappfluent;

import core.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.v10.multifilepageobjectpagesectionsappfluent.CartPage.CartPage;
import pages.v10.multifilepageobjectpagesectionsappfluent.MainPage.MainPage;

public class ProductPurchaseTestsWithPageObjects {
    private static App app;

    @BeforeMethod
    public void testInit() {
        app = new App(Browser.CHROME);
    }

    @AfterMethod
    public void testCleanup() {
        app.close();
    }

    @Test
    public void completePurchaseSuccessfully_WhenNewClient() throws InterruptedException {
        var mainPage = app.goTo(MainPage.class);

        mainPage.addRocketToShoppingCart();
        var cartPage = app.goTo(CartPage.class);
        cartPage.applyCoupon("happybirthday")
                .assertCouponAppliedSuccessfully()
                .increaseProductQuantity(2)
                .assertTotalPrice("114.00€")
                .clickProceedToCheckout();
    }
}