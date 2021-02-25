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

package pages.v7.multifilepageobjectsectionsdriverinterfaces;

import core.Browser;
import core.Driver;
import core.LoggingDriver;
import core.WebCoreDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.v7.multifilepageobjectsectionsdriverinterfaces.CartPage.CartPage;
import pages.v7.multifilepageobjectsectionsdriverinterfaces.MainPage.MainPage;

public class ProductPurchaseTestsWithPageObjects {
    private Driver driver;
    private static MainPage mainPage;
    private static CartPage cartPage;

    @BeforeMethod
    public void testInit() {
        driver = new LoggingDriver(new WebCoreDriver());
        driver.start(Browser.CHROME);
        mainPage = new MainPage(driver, driver);
        cartPage = new CartPage(driver, driver, driver);

        mainPage.open();
    }

    @AfterMethod
    public void testCleanup() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void falcon9LinkAddsCorrectProduct() {
        mainPage.open();

        mainPage.assertions().assertProductBoxLink("Falcon 9", "http://demos.bellatrix.solutions/product/falcon-9/");
    }

    @Test
    public void saturnVLinkAddsCorrectProduct() {
        mainPage.open();

        mainPage.assertions().assertProductBoxLink("Saturn V", "http://demos.bellatrix.solutions/product/saturn-v/");
    }
}