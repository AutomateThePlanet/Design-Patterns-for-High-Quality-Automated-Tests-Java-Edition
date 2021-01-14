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

import core.Driver;
import core.interfaces.BrowserService;
import core.interfaces.ElementFindService;
import core.interfaces.ElementWaitService;
import core.interfaces.NavigationService;
import core.wait.Wait;
import org.testng.Assert;
import core.LoggingSingletonDriver;
import pages.v10.multifilepageobjectpagesectionsappfluent.NavigatableEShopPage;
import pages.v10.multifilepageobjectpagesectionsappfluent.Sections.BreadcrumbSection;

public class CartPage extends NavigatableEShopPage {
    private final BrowserService browserService;
    private final ElementWaitService elementWaitService;

    public CartPage(Driver driver) {
        super(driver, driver);
        this.browserService = driver;
        this.elementWaitService = driver;
    }

    @Override
    protected String getUrl() {
        return "http://demos.bellatrix.solutions/cart/";
    }

    public BreadcrumbSection breadcrumbSection() {
        return new BreadcrumbSection(elementFindService);
    }

    @Override
    protected void waitForPageLoad() {
        elements().couponCodeTextField().waitToExists();
    }

    public CartPage applyCoupon(String coupon) throws InterruptedException {
        elementWaitService.wait(elements().couponCodeTextField(), Wait.to().exists());
        elements().couponCodeTextField().typeText(coupon);
        elements().applyCouponButton().click();
        browserService.waitForAjax();
        return this;
    }

    public CartPage increaseProductQuantity(int newQuantity) throws InterruptedException {
        elements().quantityBox().typeText(String.valueOf(newQuantity));
        elements().updateCart().click();
        browserService.waitForAjax();
        return this;
    }

    public CartPage clickProceedToCheckout()
    {
        elements().proceedToCheckout().click();
        browserService.waitUntilPageLoadsCompletely();
        return this;
    }

    public String getTotal()
    {
        return elements().totalSpan().getText();
    }

    public String getMessageNotification()
    {
        return elements().messageAlert().getText();
    }


    public CartPage assertCouponAppliedSuccessfully()
    {
        Assert.assertEquals(getMessageNotification(), "Coupon code applied successfully.");
        return this;
    }

    public CartPage assertTotalPrice(String expectedPrice)
    {
        Assert.assertEquals(elements().totalSpan().getText(), expectedPrice);
        return this;
    }

    private CartPageElements elements() {
        return new CartPageElements(elementFindService);
    }
}
