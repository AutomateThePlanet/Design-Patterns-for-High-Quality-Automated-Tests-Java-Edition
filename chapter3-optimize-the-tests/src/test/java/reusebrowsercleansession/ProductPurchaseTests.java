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

package reusebrowsercleansession;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import reusebrowser.Browser;
import reusebrowser.browserinfrastructure.BaseTest;
import reusebrowser.browserinfrastructure.BrowserBehavior;
import reusebrowser.browserinfrastructure.ExecutionBrowser;

/*
 * The order of test execution is important. The tests should be executed in the following order:
 * completePurchaseSuccessfully_whenNewClient
 * completePurchaseSuccessfully_whenExistingClient
 * correctOrderDataDisplayed_WhenNavigateToMyAccountOrderSection
 *
 * The tests may fail because the hard-coded pauses were not enough.
 * This is the expected behavior showing that this is not the best practice.
 */
@ExecutionBrowser(browser = Browser.CHROME, browserBehavior = BrowserBehavior.RESTART_EVERY_TIME)
public class ProductPurchaseTests extends BaseTest {
    private static String purchaseEmail;
    private static String purchaseOrderNumber;

    @Test(priority=1)
    public void completePurchaseSuccessfully_whenNewClient() throws InterruptedException {
        getDriver().goToUrl("http://demos.bellatrix.solutions/");
        var addToCartFalcon9 = getDriver().findElement(By.cssSelector("[data-product_id*='28']"));
        addToCartFalcon9.click();
        var viewCartButton = getDriver().findElement(By.cssSelector("[class*='added_to_cart wc-forward']"));
        viewCartButton.click();

        var couponCodeTextField = getDriver().findElement(By.id("coupon_code"));
        couponCodeTextField.typeText("happybirthday");
        var applyCouponButton = getDriver().findElement(By.cssSelector("[value*='Apply coupon']"));
        applyCouponButton.click();
        getDriver().waitForAjax();
        var messageAlert = getDriver().findElement(By.cssSelector("[class*='woocommerce-message']"));
        Assert.assertEquals(messageAlert.getText(), "Coupon code applied successfully.");

        var quantityBox = getDriver().findElement(By.cssSelector("[class*='input-text qty text']"));
        quantityBox.typeText("2");
        getDriver().waitForAjax();

        var updateCart = getDriver().findElement(By.cssSelector("[value*='Update cart']"));
        updateCart.click();
        getDriver().waitForAjax();
        var totalSpan = getDriver().findElement(By.xpath("//*[@class='order-total']//span"));
        Assert.assertEquals("114.00€", totalSpan.getText());

        var proceedToCheckout = getDriver().findElement(By.cssSelector("[class*='checkout-button button alt wc-forward']"));
        proceedToCheckout.click();
        getDriver().waitUntilPageLoadsCompletely();

        var billingFirstName = getDriver().findElement(By.id("billing_first_name"));
        billingFirstName.typeText("Anton");
        var billingLastName = getDriver().findElement(By.id("billing_last_name"));
        billingLastName.typeText("Angelov");
        var billingCompany = getDriver().findElement(By.id("billing_company"));
        billingCompany.typeText("Space Flowers");
        var billingCountryWrapper = getDriver().findElement(By.id("select2-billing_country-container"));
        billingCountryWrapper.click();
        var billingCountryFilter = getDriver().findElement(By.className("select2-search__field"));
        billingCountryFilter.typeText("Germany");
        var germanyOption = getDriver().findElement(By.xpath("//*[contains(text(),'Germany')]"));
        germanyOption.click();
        var billingAddress1 = getDriver().findElement(By.id("billing_address_1"));
        billingAddress1.typeText("1 Willi Brandt Avenue Tiergarten");
        var billingAddress2 = getDriver().findElement(By.id("billing_address_2"));
        billingAddress2.typeText("Lьtzowplatz 17");
        var billingCity = getDriver().findElement(By.id("billing_city"));
        billingCity.typeText("Berlin");
        var billingZip = getDriver().findElement(By.id("billing_postcode"));
        billingZip.typeText("10115");
        var billingPhone = getDriver().findElement(By.id("billing_phone"));
        billingPhone.typeText("+00498888999281");
        var billingEmail = getDriver().findElement(By.id("billing_email"));
        billingEmail.typeText("info@berlinspaceflowers.com");
        purchaseEmail = "info@berlinspaceflowers.com";

        // This pause will be removed when we introduce a logic for waiting for AJAX requests.
        getDriver().waitForAjax();
        var placeOrderButton = getDriver().findElement(By.id("place_order"));
        placeOrderButton.click();

        getDriver().waitForAjax();
        var receivedMessage = getDriver().findElement(By.xpath("/html/body/div[1]/div/div/div/main/div/header/h1"));
        Assert.assertEquals(receivedMessage.getText(), "Order received");
    }

    @Test(priority=2)
    public void completePurchaseSuccessfully_whenExistingClient() throws InterruptedException {
        getDriver().goToUrl("http://demos.bellatrix.solutions/");

        var addToCartFalcon9 = getDriver().findElement(By.cssSelector("[data-product_id*='28']"));
        addToCartFalcon9.click();
        var viewCartButton = getDriver().findElement(By.cssSelector("[class*='added_to_cart wc-forward']"));
        viewCartButton.click();

        var couponCodeTextField = getDriver().findElement(By.id("coupon_code"));
        couponCodeTextField.typeText("happybirthday");
        var applyCouponButton = getDriver().findElement(By.cssSelector("[value*='Apply coupon']"));
        applyCouponButton.click();
        var messageAlert = getDriver().findElement(By.cssSelector("[class*='woocommerce-message']"));
        getDriver().waitForAjax();
        Assert.assertEquals(messageAlert.getText(), "Coupon code applied successfully.");

        var quantityBox = getDriver().findElement(By.cssSelector("[class*='input-text qty text']"));
        quantityBox.typeText("2");
        getDriver().waitForAjax();
        var updateCart = getDriver().findElement(By.cssSelector("[value*='Update cart']"));
        updateCart.click();
        getDriver().waitForAjax();
        var totalSpan = getDriver().findElement(By.xpath("//*[@class='order-total']//span"));
        Assert.assertEquals(totalSpan.getText(), "114.00€");

        var proceedToCheckout = getDriver().findElement(By.cssSelector("[class*='checkout-button button alt wc-forward']"));
        proceedToCheckout.click();
        getDriver().waitUntilPageLoadsCompletely();

        var loginHereLink = getDriver().findElement(By.linkText("Click here to login"));
        loginHereLink.click();
        var userName = getDriver().findElement(By.id("username"));
        getDriver().waitForAjax();
        userName.typeText(purchaseEmail);
        var password = getDriver().findElement(By.id("password"));
        password.typeText(GetUserPasswordFromDb(purchaseEmail));
        var loginButton = getDriver().findElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        getDriver().waitForAjax();
        var placeOrderButton = getDriver().findElement(By.id("place_order"));
        placeOrderButton.click();

        var receivedMessage = getDriver().findElement(By.xpath("//h1[text() = 'Order received']"));
        Assert.assertEquals(receivedMessage.getText(), "Order received");

        var orderNumber = getDriver().findElement(By.xpath("//*[@id='post-7']/div/div/div/ul/li[1]/strong"));
        purchaseOrderNumber = orderNumber.getText();
    }

    @Test(priority=3)
    public void correctOrderDataDisplayed_whenNavigateToMyAccountOrderSection() throws InterruptedException {
        getDriver().goToUrl("http://demos.bellatrix.solutions/");

        var myAccountLink = getDriver().findElement(By.linkText("My account"));
        myAccountLink.click();
        var userName = getDriver().findElement(By.id("username"));
        getDriver().waitForAjax();
        userName.typeText(purchaseEmail);
        var password = getDriver().findElement(By.id("password"));
        password.typeText(GetUserPasswordFromDb(GetUserPasswordFromDb(purchaseEmail)));
        var loginButton = getDriver().findElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        var orders = getDriver().findElement(By.linkText("Orders"));
        orders.click();

        var viewButtons = getDriver().findElements(By.linkText("View"));
        viewButtons.get(0).click();

        var orderName = getDriver().findElement(By.xpath("//h1"));
        String expectedMessage = String.format("Order #%s", purchaseOrderNumber);
        Assert.assertEquals(expectedMessage, orderName.getText());
    }

    private String GetUserPasswordFromDb(String userName)
    {
        return "@purISQzt%%DYBnLCIhaoG6$";
    }
}