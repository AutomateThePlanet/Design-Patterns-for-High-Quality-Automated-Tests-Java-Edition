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

package multifilepageobjectpagesectionsappfluent;

import configuration.*;
import core.Browser;
import multifilepageobjectpagesectionsappfluent.CartPage.CartPage;
import multifilepageobjectpagesectionsappfluent.MainPage.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class ProductPurchaseTestsWithPageObjects {
    private App app;

    @BeforeMethod
    public void testInit() throws IOException {
        app = new App(Browser.CHROME);
    }

    @AfterMethod
    public void testCleanup() throws Exception {
        app.close();
    }

    @Test
    public void testConfig() throws IOException, URISyntaxException {
        var appap = app;
        var webSettings = ConfigurationService.get(WebSettings.class);
        var urlSettings = ConfigurationService.get(UrlSettings.class);
        var billingInfoDefaultValues = ConfigurationService.get(BillingInfoDefaultValues.class);
        System.out.print(webSettings);
        System.out.print(urlSettings);
        System.out.print(billingInfoDefaultValues);
        var part = UrlDeterminer.getAccountUrl("part1");
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