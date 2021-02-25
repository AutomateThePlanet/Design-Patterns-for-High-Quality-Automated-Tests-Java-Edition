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

package pages.v8.multifilepageobjectsectionssingleton;

import core.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.v8.multifilepageobjectsectionssingleton.MainPage.MainPage;

public class ProductPurchaseTestsWithPageObjects {

    @BeforeMethod
    public void testInit() {
        LoggingSingletonDriver.getInstance().start(Browser.CHROME);

        MainPage.getInstance().open();
    }

    @AfterMethod
    public void testCleanup() {
        LoggingSingletonDriver.getInstance().quit();
    }

    @Test
    public void falcon9LinkAddsCorrectProduct() {
        MainPage.getInstance().open();

        MainPage.getInstance().assertions().assertProductBoxLink("Falcon 9", "http://demos.bellatrix.solutions/product/falcon-9/");
    }

    @Test
    public void saturnVLinkAddsCorrectProduct() {
        MainPage.getInstance().open();

        MainPage.getInstance().assertions().assertProductBoxLink("Saturn V", "http://demos.bellatrix.solutions/product/saturn-v/");
    }
}