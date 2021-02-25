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

package pages.v9.multifilepageobjectpagesectionsapp;

import core.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.v9.multifilepageobjectpagesectionsapp.MainPage.MainPage;

public class ProductPurchaseTestsWithPageObjects {
    private static App app;

    @BeforeClass
    public void beforeClass() {
        app = new App(Browser.CHROME);
    }

    @AfterClass
    public void afterClass() {
        app.close();
    }

    @Test
    public void falcon9LinkAddsCorrectProduct() {
        var mainPage = app.goTo(MainPage.class);

        mainPage.assertions().assertProductBoxLink("Falcon 9", "http://demos.bellatrix.solutions/product/falcon-9/");
    }

    @Test
    public void saturnVLinkAddsCorrectProduct() {
        var mainPage = app.goTo(MainPage.class);

        app.create(MainPage.class).assertions().assertProductBoxLink("Saturn V", "http://demos.bellatrix.solutions/product/saturn-v/");
    }
}