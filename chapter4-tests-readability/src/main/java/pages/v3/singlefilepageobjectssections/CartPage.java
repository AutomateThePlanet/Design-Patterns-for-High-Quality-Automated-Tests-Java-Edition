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

package pages.v3.singlefilepageobjectssections;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;
import pages.v3.singlefilepageobjectssections.Sections.BreadcrumbSection;
import pages.v3.singlefilepageobjectssections.Sections.CartInfoSection;
import pages.v3.singlefilepageobjectssections.Sections.MainMenuSection;
import pages.v3.singlefilepageobjectssections.Sections.SearchSection;

public class CartPage {
    private final Driver driver;

    public CartPage(Driver driver) {
        this.driver = driver;
    }

    private Element couponCodeTextField() {
        return driver.findElement(By.id("coupon_code"));
    }

    private Element applyCouponButton() {
        return driver.findElement(By.cssSelector("[value*='Apply coupon']"));
    }

    private Element quantityBox() {
        return driver.findElement(By.cssSelector("[class*='input-text qty text']"));
    }

    private Element updateCart() {
        return driver.findElement(By.cssSelector("[value*='Update cart']"));
    }

    private Element messageAlert() {
        return driver.findElement(By.cssSelector("[class*='woocommerce-message']"));
    }

    private Element totalSpan() {
        return driver.findElement(By.xpath("//*[@class='order-total']//span"));
    }

    public BreadcrumbSection breadcrumbSection() {
        return new BreadcrumbSection(driver);
    }

    public MainMenuSection mainMenuSection() {
        return new MainMenuSection(driver);
    }

    public CartInfoSection cartInfoSection() {
        return new CartInfoSection(driver);
    }

    public SearchSection searchSection() {
        return new SearchSection(driver);
    }

    public Element proceedToCheckout() {
        return driver.findElement(By.cssSelector("[class*='checkout-button button alt wc-forward']"));
    }

    public void applyCoupon(String coupon) throws InterruptedException {
        couponCodeTextField().typeText(coupon);
        applyCouponButton().click();
        driver.waitForAjax();
    }

    public void increaseProductQuantity(int newQuantity) throws InterruptedException {
        quantityBox().typeText(String.valueOf(newQuantity));
        updateCart().click();
        driver.waitForAjax();
    }

    public void clickProceedToCheckout() {
        proceedToCheckout().click();
        driver.waitUntilPageLoadsCompletely();
    }

    public String getTotal() {
        return totalSpan().getText();
    }

    public String getMessageNotification() {
        return messageAlert().getText();
    }
}
