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

package facadedesignpattern.classic;

import core.Browser;
import core.Driver;
import core.LoggingDriver;
import core.WebCoreDriver;
import facadedesignpattern.classic.CartPage.CartPage;
import facadedesignpattern.classic.CheckoutPage.CheckoutPage;
import facadedesignpattern.classic.MainPage.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProductPurchaseTestsWithPageObjects {
    private Driver driver;
    private static MainPage mainPage;
    private static CartPage cartPage;
    private static CheckoutPage checkoutPage;
    private static PurchaseFacade purchaseFacade;

    @BeforeMethod
    public void testInit() throws IOException {
        driver = new LoggingDriver(new WebCoreDriver());
        driver.start(Browser.CHROME);
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        purchaseFacade = new PurchaseFacade(mainPage, cartPage, checkoutPage);
    }

    @AfterMethod
    public void testCleanup() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void purchaseFalcon9WithoutFacade() throws InterruptedException {
        mainPage.open();
        mainPage.addRocketToShoppingCart("Falcon 9");
        cartPage.applyCoupon("happybirthday");
        cartPage.assertions().assertCouponAppliedSuccessfully();
        cartPage.increaseProductQuantity(2);
        cartPage.assertions().assertTotalPrice("114.00€");
        cartPage.clickProceedToCheckout();

        var purchaseInfo = new PurchaseInfo();
        purchaseInfo.setEmail("info@berlinspaceflowers.com");
        purchaseInfo.setFirstName("Anton");
        purchaseInfo.setLastName("Angelov");
        purchaseInfo.setCompany("Space Flowers");
        purchaseInfo.setCountry("Germany");
        purchaseInfo.setAddress1("1 Willi Brandt Avenue Tiergarten");
        purchaseInfo.setAddress2("Lotzowplatz 17");
        purchaseInfo.setCity("Berlin");
        purchaseInfo.setZip("10115");
        purchaseInfo.setPhone("+00498888999281");

        checkoutPage.fillBillingInfo(purchaseInfo);
        checkoutPage.assertions().assertOrderReceived();
    }

    @Test
    public void purchaseSaturnVWithoutFacade() throws InterruptedException {
        mainPage.open();
        mainPage.addRocketToShoppingCart("Saturn V");
        cartPage.applyCoupon("happybirthday");
        cartPage.assertions().assertCouponAppliedSuccessfully();
        cartPage.increaseProductQuantity(3);
        cartPage.assertions().assertTotalPrice("355.00€");
        cartPage.clickProceedToCheckout();

        var purchaseInfo = new PurchaseInfo();
        purchaseInfo.setEmail("info@berlinspaceflowers.com");
        purchaseInfo.setFirstName("Anton");
        purchaseInfo.setLastName("Angelov");
        purchaseInfo.setCompany("Space Flowers");
        purchaseInfo.setCountry("Germany");
        purchaseInfo.setAddress1("1 Willi Brandt Avenue Tiergarten");
        purchaseInfo.setAddress2("Lotzowplatz 17");
        purchaseInfo.setCity("Berlin");
        purchaseInfo.setZip("10115");
        purchaseInfo.setPhone("+00498888999281");

        checkoutPage.fillBillingInfo(purchaseInfo);
        checkoutPage.assertions().assertOrderReceived();
    }

    @Test
    public void purchaseFalcon9WithFacade() throws InterruptedException {
        var purchaseInfo = new PurchaseInfo();
        purchaseInfo.setEmail("info@berlinspaceflowers.com");
        purchaseInfo.setFirstName("Anton");
        purchaseInfo.setLastName("Angelov");
        purchaseInfo.setCompany("Space Flowers");
        purchaseInfo.setCountry("Germany");
        purchaseInfo.setAddress1("1 Willi Brandt Avenue Tiergarten");
        purchaseInfo.setAddress2("Lotzowplatz 17");
        purchaseInfo.setCity("Berlin");
        purchaseInfo.setZip("10115");
        purchaseInfo.setPhone("+00498888999281");

        purchaseFacade.verifyItemPurchase("Falcon 9", "happybirthday", 2, "114.00€", purchaseInfo);
    }

    @Test
    public void purchaseSaturnVWithFacade() throws InterruptedException {
        var purchaseInfo = new PurchaseInfo();
        purchaseInfo.setEmail("info@berlinspaceflowers.com");
        purchaseInfo.setFirstName("Anton");
        purchaseInfo.setLastName("Angelov");
        purchaseInfo.setCompany("Space Flowers");
        purchaseInfo.setCountry("Germany");
        purchaseInfo.setAddress1("1 Willi Brandt Avenue Tiergarten");
        purchaseInfo.setAddress2("Lotzowplatz 17");
        purchaseInfo.setCity("Berlin");
        purchaseInfo.setZip("10115");
        purchaseInfo.setPhone("+00498888999281");

        purchaseFacade.verifyItemPurchase("Saturn V", "happybirthday", 3, "355.00€", purchaseInfo);
    }
}