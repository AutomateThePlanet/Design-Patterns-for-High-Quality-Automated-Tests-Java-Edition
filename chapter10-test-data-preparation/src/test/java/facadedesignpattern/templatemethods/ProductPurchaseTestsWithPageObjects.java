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

package facadedesignpattern.templatemethods;

import core.Browser;
import core.Driver;
import core.LoggingDriver;
import core.WebCoreDriver;
import facadedesignpattern.templatemethods.CartPage.CartPage;
import facadedesignpattern.templatemethods.CheckoutPage.CheckoutPage;
import facadedesignpattern.templatemethods.MainPage.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class ProductPurchaseTestsWithPageObjects {
    private Driver driver;
    private static MainPage mainPage;
    private static CartPage cartPage;
    private static CheckoutPage checkoutPage;
    private static NewPurchaseFacade purchaseFacade;

    @BeforeMethod
    public void testInit() throws IOException {
        driver = new LoggingDriver(new WebCoreDriver());
        driver.start(Browser.CHROME);
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        purchaseFacade = new NewPurchaseFacade(mainPage, cartPage, checkoutPage);
    }

    @AfterMethod
    public void testCleanup() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void purchaseFalcon9WithoutFacade() throws InterruptedException, IOException, URISyntaxException {
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
    public void purchaseSaturnVWithoutFacade() throws InterruptedException, IOException, URISyntaxException {
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
    public void purchaseFalcon9WithFacade() throws InterruptedException, IOException, URISyntaxException {
        var purchaseInfo = new PurchaseInfo();
        purchaseFacade.purchaseItem("Falcon 9", "happybirthday", 2, "114.00€", purchaseInfo);
    }

    @Test
    public void purchaseSaturnVWithFacade() throws InterruptedException, IOException, URISyntaxException {
        var purchaseInfo = new PurchaseInfo();
        purchaseFacade.purchaseItem("Saturn V", "happybirthday", 3, "355.00€", purchaseInfo);
    }

    @Test(dataProvider = "getPurchaseInfoData")
    public void purchaseSaturnDataDrivenFacade(String product, String coupon, int quantity, String expectedPrice) throws InterruptedException, IOException, URISyntaxException {
        var purchaseInfo = new PurchaseInfo();
        purchaseFacade.purchaseItem(product, coupon, quantity, expectedPrice, purchaseInfo);
    }

    @DataProvider
    public Object[][] getPurchaseInfoData(){
        Object[][] data = new Object[2][4];
        data[0][0] = "Falcon 9";
        data[0][1] = "happybirthday";
        data[0][2] = 2;
        data[0][3] = "114.00€";

        data[1][0] = "Saturn V";
        data[1][1] = "happybirthday";
        data[1][2] = 3;
        data[1][3] = "355.00€";

        return data;
    }
}