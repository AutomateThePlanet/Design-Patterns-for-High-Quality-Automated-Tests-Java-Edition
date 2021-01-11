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

import core.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPurchaseWithoutPagesObjectsTests {
    private Driver driver;
    private static String purchaseEmail;
    private static String purchaseOrderNumber;

    @BeforeMethod
    public void testInit() {
        driver = new LoggingDriver(new WebCoreDriver());
        driver.start(Browser.CHROME);
    }

    @AfterMethod
    public void testCleanup() throws InterruptedException {
        driver.quit();
    }

    @Test(priority = 1)
    public void completePurchaseSuccessfully_whenNewClient() throws InterruptedException {
        driver.goToUrl("http://demos.bellatrix.solutions/");
        var addToCartFalcon9 = driver.findElement(By.cssSelector("[data-product_id*='28']"));
        addToCartFalcon9.click();
        var viewCartButton = driver.findElement(By.cssSelector("[class*='added_to_cart wc-forward']"));
        viewCartButton.click();

        var couponCodeTextField = driver.findElement(By.id("coupon_code"));
        couponCodeTextField.typeText("happybirthday");
        var applyCouponButton = driver.findElement(By.cssSelector("[value*='Apply coupon']"));
        applyCouponButton.click();
        driver.waitForAjax();
        var messageAlert = driver.findElement(By.cssSelector("[class*='woocommerce-message']"));
        Assert.assertEquals(messageAlert.getText(), "Coupon code applied successfully.");

        var quantityBox = driver.findElement(By.cssSelector("[class*='input-text qty text']"));
        quantityBox.typeText("2");
        driver.waitForAjax();

        var updateCart = driver.findElement(By.cssSelector("[value*='Update cart']"));
        updateCart.click();
        driver.waitForAjax();
        var totalSpan = driver.findElement(By.xpath("//*[@class='order-total']//span"));
        Assert.assertEquals("114.00€", totalSpan.getText());

        var proceedToCheckout = driver.findElement(By.cssSelector("[class*='checkout-button button alt wc-forward']"));
        proceedToCheckout.click();
        driver.waitUntilPageLoadsCompletely();

        var billingFirstName = driver.findElement(By.id("billing_first_name"));
        billingFirstName.typeText("Anton");
        var billingLastName = driver.findElement(By.id("billing_last_name"));
        billingLastName.typeText("Angelov");
        var billingCompany = driver.findElement(By.id("billing_company"));
        billingCompany.typeText("Space Flowers");
        var billingCountryWrapper = driver.findElement(By.id("select2-billing_country-container"));
        billingCountryWrapper.click();
        var billingCountryFilter = driver.findElement(By.className("select2-search__field"));
        billingCountryFilter.typeText("Germany");
        var germanyOption = driver.findElement(By.xpath("//*[contains(text(),'Germany')]"));
        germanyOption.click();
        var billingAddress1 = driver.findElement(By.id("billing_address_1"));
        billingAddress1.typeText("1 Willi Brandt Avenue Tiergarten");
        var billingAddress2 = driver.findElement(By.id("billing_address_2"));
        billingAddress2.typeText("Lьtzowplatz 17");
        var billingCity = driver.findElement(By.id("billing_city"));
        billingCity.typeText("Berlin");
        var billingZip = driver.findElement(By.id("billing_postcode"));
        billingZip.typeText("10115");
        var billingPhone = driver.findElement(By.id("billing_phone"));
        billingPhone.typeText("+00498888999281");
        var billingEmail = driver.findElement(By.id("billing_email"));
        billingEmail.typeText("info@berlinspaceflowers.com");
        purchaseEmail = "info@berlinspaceflowers.com";

        // This pause will be removed when we introduce a logic for waiting for AJAX requests.
        driver.waitForAjax();
        var placeOrderButton = driver.findElement(By.id("place_order"));
        placeOrderButton.click();

        driver.waitForAjax();
        var receivedMessage = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div/header/h1"));
        Assert.assertEquals(receivedMessage.getText(), "Order received");
    }

    @Test(priority = 2)
    public void completePurchaseSuccessfully_whenExistingClient() throws InterruptedException {
        driver.goToUrl("http://demos.bellatrix.solutions/");

        var addToCartFalcon9 = driver.findElement(By.cssSelector("[data-product_id*='28']"));
        addToCartFalcon9.click();
        var viewCartButton = driver.findElement(By.cssSelector("[class*='added_to_cart wc-forward']"));
        viewCartButton.click();

        var couponCodeTextField = driver.findElement(By.id("coupon_code"));
        couponCodeTextField.typeText("happybirthday");
        var applyCouponButton = driver.findElement(By.cssSelector("[value*='Apply coupon']"));
        applyCouponButton.click();
        var messageAlert = driver.findElement(By.cssSelector("[class*='woocommerce-message']"));
        driver.waitForAjax();
        Assert.assertEquals(messageAlert.getText(), "Coupon code applied successfully.");

        var quantityBox = driver.findElement(By.cssSelector("[class*='input-text qty text']"));
        quantityBox.typeText("2");
        driver.waitForAjax();
        var updateCart = driver.findElement(By.cssSelector("[value*='Update cart']"));
        updateCart.click();
        driver.waitForAjax();
        var totalSpan = driver.findElement(By.xpath("//*[@class='order-total']//span"));
        Assert.assertEquals(totalSpan.getText(), "114.00€");

        var proceedToCheckout = driver.findElement(By.cssSelector("[class*='checkout-button button alt wc-forward']"));
        proceedToCheckout.click();
        driver.waitUntilPageLoadsCompletely();

        var loginHereLink = driver.findElement(By.linkText("Click here to login"));
        loginHereLink.click();
        var userName = driver.findElement(By.id("username"));
        driver.waitForAjax();
        userName.typeText(purchaseEmail);
        var password = driver.findElement(By.id("password"));
        password.typeText(GetUserPasswordFromDb(purchaseEmail));
        var loginButton = driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        driver.waitForAjax();
        var placeOrderButton = driver.findElement(By.id("place_order"));
        placeOrderButton.click();

        var receivedMessage = driver.findElement(By.xpath("//h1[text() = 'Order received']"));
        Assert.assertEquals(receivedMessage.getText(), "Order received");

        var orderNumber = driver.findElement(By.xpath("//*[@id='post-7']/div/div/div/ul/li[1]/strong"));
        purchaseOrderNumber = orderNumber.getText();
    }

    private String GetUserPasswordFromDb(String userName) {
        return "@purISQzt%%DYBnLCIhaoG6$";
    }
}