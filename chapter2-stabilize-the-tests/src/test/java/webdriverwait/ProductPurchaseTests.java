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

package webdriverwait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 * The order of test execution is important. The tests should be executed in the following order:
 * completePurchaseSuccessfully_whenNewClient
 * completePurchaseSuccessfully_whenExistingClient
 * correctOrderDataDisplayed_WhenNavigateToMyAccountOrderSection
 *
 * The tests may fail because the hard-coded pauses were not enough.
 * This is the expected behavior showing that this is not the best practice.
 */
public class ProductPurchaseTests {
    private WebDriver driver;
    private static String purchaseEmail;
    private static String purchaseOrderNumber;

    @BeforeMethod
    public void testInit() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void testCleanup() throws InterruptedException {
        driver.quit();
    }

    @Test(priority=1)
    public void completePurchaseSuccessfully_whenNewClient() throws InterruptedException {
        driver.navigate().to("http://demos.bellatrix.solutions/");
        var addToCartFalcon9 = waitAndFindElement(By.cssSelector("[data-product_id*='28']"));
        addToCartFalcon9.click();
        var viewCartButton = waitAndFindElement(By.cssSelector("[class*='added_to_cart wc-forward']"));
        viewCartButton.click();

        var couponCodeTextField = waitAndFindElement(By.id("coupon_code"));
        couponCodeTextField.clear();
        couponCodeTextField.sendKeys("happybirthday");
        var applyCouponButton = waitAndFindElement(By.cssSelector("[value*='Apply coupon']"));
        applyCouponButton.click();
        Thread.sleep(4000);
        var messageAlert = waitAndFindElement(By.cssSelector("[class*='woocommerce-message']"));
        Assert.assertEquals(messageAlert.getText(), "Coupon code applied successfully.");

        var quantityBox = waitAndFindElement(By.cssSelector("[class*='input-text qty text']"));
        quantityBox.clear();
        quantityBox.sendKeys("2");

        var updateCart = waitAndFindElement(By.cssSelector("[value*='Update cart']"));
        updateCart.click();
        Thread.sleep(4000);
        var totalSpan = waitAndFindElement(By.xpath("//*[@class='order-total']//span"));
        Assert.assertEquals("114.00€", totalSpan.getText());

        var proceedToCheckout = waitAndFindElement(By.cssSelector("[class*='checkout-button button alt wc-forward']"));
        proceedToCheckout.click();

        var billingFirstName = waitAndFindElement(By.id("billing_first_name"));
        billingFirstName.sendKeys("Anton");
        var billingLastName = waitAndFindElement(By.id("billing_last_name"));
        billingLastName.sendKeys("Angelov");
        var billingCompany = waitAndFindElement(By.id("billing_company"));
        billingCompany.sendKeys("Space Flowers");
        var billingCountryWrapper = waitAndFindElement(By.id("select2-billing_country-container"));
        billingCountryWrapper.click();
        var billingCountryFilter = waitAndFindElement(By.className("select2-search__field"));
        billingCountryFilter.sendKeys("Germany");
        var germanyOption = waitAndFindElement(By.xpath("//*[contains(text(),'Germany')]"));
        germanyOption.click();
        var billingAddress1 = waitAndFindElement(By.id("billing_address_1"));
        billingAddress1.sendKeys("1 Willi Brandt Avenue Tiergarten");
        var billingAddress2 = waitAndFindElement(By.id("billing_address_2"));
        billingAddress2.sendKeys("Lьtzowplatz 17");
        var billingCity = waitAndFindElement(By.id("billing_city"));
        billingCity.sendKeys("Berlin");
        var billingZip = waitAndFindElement(By.id("billing_postcode"));
        billingZip.clear();
        billingZip.sendKeys("10115");
        var billingPhone = waitAndFindElement(By.id("billing_phone"));
        billingPhone.sendKeys("+00498888999281");
        var billingEmail = waitAndFindElement(By.id("billing_email"));
        billingEmail.sendKeys("info@berlinspaceflowers.com");
        purchaseEmail = "info@berlinspaceflowers.com";

        // This pause will be removed when we introduce a logic for waiting for AJAX requests.
        Thread.sleep(5000);
        var placeOrderButton = waitAndFindElement(By.id("place_order"));
        placeOrderButton.click();

        Thread.sleep(10000);
        var receivedMessage = waitAndFindElement(By.xpath("/html/body/div[1]/div/div/div/main/div/header/h1"));
        Assert.assertEquals(receivedMessage.getText(), "Order received");
    }

    @Test(priority=2)
    public void completePurchaseSuccessfully_whenExistingClient() throws InterruptedException {
        driver.navigate().to("http://demos.bellatrix.solutions/");

        var addToCartFalcon9 = waitAndFindElement(By.cssSelector("[data-product_id*='28']"));
        addToCartFalcon9.click();
        var viewCartButton = waitAndFindElement(By.cssSelector("[class*='added_to_cart wc-forward']"));
        viewCartButton.click();

        var couponCodeTextField = waitAndFindElement(By.id("coupon_code"));
        couponCodeTextField.clear();
        couponCodeTextField.sendKeys("happybirthday");
        var applyCouponButton = waitAndFindElement(By.cssSelector("[value*='Apply coupon']"));
        applyCouponButton.click();
        var messageAlert = waitAndFindElement(By.cssSelector("[class*='woocommerce-message']"));
        Thread.sleep(4000);
        Assert.assertEquals(messageAlert.getText(), "Coupon code applied successfully.");

        var quantityBox = waitAndFindElement(By.cssSelector("[class*='input-text qty text']"));
        quantityBox.clear();
        quantityBox.sendKeys("2");
        var updateCart = waitAndFindElement(By.cssSelector("[value*='Update cart']"));
        updateCart.click();
        Thread.sleep(4000);
        var totalSpan = waitAndFindElement(By.xpath("//*[@class='order-total']//span"));
        Assert.assertEquals(totalSpan.getText(), "114.00€");

        var proceedToCheckout = waitAndFindElement(By.cssSelector("[class*='checkout-button button alt wc-forward']"));
        proceedToCheckout.click();

        var loginHereLink = waitAndFindElement(By.linkText("Click here to login"));
        loginHereLink.click();
        var userName = waitAndFindElement(By.id("username"));
        userName.sendKeys(purchaseEmail);
        var password = waitAndFindElement(By.id("password"));
        password.sendKeys(GetUserPasswordFromDb(purchaseEmail));
        var loginButton = waitAndFindElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        // This pause will be removed when we introduce a logic for waiting for AJAX requests.
        Thread.sleep(5000);
        var placeOrderButton = waitAndFindElement(By.id("place_order"));
        placeOrderButton.click();

        var receivedMessage = waitAndFindElement(By.xpath("//h1[text() = 'Order received']"));
        Assert.assertEquals(receivedMessage.getText(), "Order received");

        var orderNumber = waitAndFindElement(By.xpath("//*[@id='post-7']/div/div/div/ul/li[1]/strong"));
        purchaseOrderNumber = orderNumber.getText();
    }

    @Test(priority=3)
    public void correctOrderDataDisplayed_whenNavigateToMyAccountOrderSection() throws InterruptedException {
        driver.navigate().to("http://demos.bellatrix.solutions/");

        var myAccountLink = waitAndFindElement(By.linkText("My account"));
        myAccountLink.click();
        var userName = waitAndFindElement(By.id("username"));
        Thread.sleep(4000);
        userName.sendKeys(purchaseEmail);
        var password = waitAndFindElement(By.id("password"));
        password.sendKeys(GetUserPasswordFromDb(GetUserPasswordFromDb(purchaseEmail)));
        var loginButton = waitAndFindElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        var orders = waitAndFindElement(By.linkText("Orders"));
        orders.click();

        var viewButtons = waitAndFindElements(By.linkText("View"));
        viewButtons.get(0).click();

        var orderName = waitAndFindElement(By.xpath("//h1"));
        String expectedMessage = String.format("Order #%s", purchaseOrderNumber);
        Assert.assertEquals(expectedMessage, orderName.getText());
    }

    private String GetUserPasswordFromDb(String userName)
    {
        return "@purISQzt%%DYBnLCIhaoG6$";
    }

    private void waitToBeClickable(By by)
    {
        var webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    private WebElement waitAndFindElement(By by)
    {
        var webDriverWait = new WebDriverWait(driver, 30);
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private List<WebElement> waitAndFindElements(By by)
    {
        var webDriverWait = new WebDriverWait(driver, 30);
        return webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}