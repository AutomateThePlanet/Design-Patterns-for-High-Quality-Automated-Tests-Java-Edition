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

package pages.v0.singlefilepageobject;

import core.Browser;
import core.Driver;
import core.LoggingDriver;
import core.WebCoreDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPurchaseTestsWithPageObjects {
    private Driver _driver;
    private static String _purchaseEmail;
    private static String _purchaseOrderNumber;
    private static MainPage _mainPage;
    private static CartPage _cartPage;

    @BeforeMethod
    public void testInit() {
        _driver = new LoggingDriver(new WebCoreDriver());
        _driver.start(Browser.Chrome);
        _mainPage = new MainPage(_driver);
        _cartPage = new CartPage(_driver);
    }

    @AfterMethod
    public void testCleanup() throws InterruptedException {
        _driver.quit();
    }

    @Test(priority=1)
    public void completePurchaseSuccessfully_whenNewClient() throws InterruptedException {
        _mainPage.addRocketToShoppingCart();
        _cartPage.applyCoupon("happybirthday");

        Assert.assertEquals(_cartPage.getMessageNotification(), "Coupon code applied successfully.");

        _cartPage.increaseProductQuantity(2);

        Assert.assertEquals("114.00€", _cartPage.getTotal());

        _cartPage.clickProceedToCheckout();

        var receivedMessage = _driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(receivedMessage.getText(), "Checkout");
    }

    @Test(priority=2)
    public void completePurchaseSuccessfully_whenExistingClient() throws InterruptedException {
        _driver.goToUrl("http://demos.bellatrix.solutions/");

        var addToCartFalcon9 = _driver.findElement(By.cssSelector("[data-product_id*='28']"));
        addToCartFalcon9.click();
        var viewCartButton = _driver.findElement(By.cssSelector("[class*='added_to_cart wc-forward']"));
        viewCartButton.click();

        var couponCodeTextField = _driver.findElement(By.id("coupon_code"));
        couponCodeTextField.typeText("happybirthday");
        var applyCouponButton = _driver.findElement(By.cssSelector("[value*='Apply coupon']"));
        applyCouponButton.click();
        var messageAlert = _driver.findElement(By.cssSelector("[class*='woocommerce-message']"));
        _driver.waitForAjax();
        Assert.assertEquals(messageAlert.getText(), "Coupon code applied successfully.");

        var quantityBox = _driver.findElement(By.cssSelector("[class*='input-text qty text']"));
        quantityBox.typeText("2");
        _driver.waitForAjax();
        var updateCart = _driver.findElement(By.cssSelector("[value*='Update cart']"));
        updateCart.click();
        _driver.waitForAjax();
        var totalSpan = _driver.findElement(By.xpath("//*[@class='order-total']//span"));
        Assert.assertEquals(totalSpan.getText(), "114.00€");

        var proceedToCheckout = _driver.findElement(By.cssSelector("[class*='checkout-button button alt wc-forward']"));
        proceedToCheckout.click();
        _driver.waitUntilPageLoadsCompletely();

        var loginHereLink = _driver.findElement(By.linkText("Click here to login"));
        loginHereLink.click();
        var userName = _driver.findElement(By.id("username"));
        _driver.waitForAjax();
        userName.typeText(_purchaseEmail);
        var password = _driver.findElement(By.id("password"));
        password.typeText(GetUserPasswordFromDb(_purchaseEmail));
        var loginButton = _driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        _driver.waitForAjax();
        var placeOrderButton = _driver.findElement(By.id("place_order"));
        placeOrderButton.click();

        var receivedMessage = _driver.findElement(By.xpath("//h1[text() = 'Order received']"));
        Assert.assertEquals(receivedMessage.getText(), "Order received");

        var orderNumber = _driver.findElement(By.xpath("//*[@id='post-7']/div/div/div/ul/li[1]/strong"));
        _purchaseOrderNumber = orderNumber.getText();
    }

    private String GetUserPasswordFromDb(String userName)
    {
        return "@purISQzt%%DYBnLCIhaoG6$";
    }
}