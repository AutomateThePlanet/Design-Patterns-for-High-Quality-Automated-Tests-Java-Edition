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

package pages.v10.multifilepageobjectpagesectionsappfluent.MainPage;

import core.Driver;
import core.interfaces.ElementFindService;
import core.interfaces.NavigationService;
import org.testng.Assert;
import pages.v10.multifilepageobjectpagesectionsappfluent.NavigatableEShopPage;

public class MainPage extends NavigatableEShopPage {
    public MainPage(Driver driver) {
        super(driver, driver);
    }

    @Override
    protected String getUrl() {
        return "http://demos.bellatrix.solutions/";
    }

    public MainPage addRocketToShoppingCart()
    {
        open();
        elements().addToCartFalcon9().click();
        elements().viewCartButton().click();
        return this;
    }

    public MainPage assertProductBoxLink(String name, String expectedLink)
    {
        var actualLink = elements().getProductBoxByName(name).getAttribute("href");
        Assert.assertEquals(actualLink, expectedLink);
        return this;
    }

    @Override
    protected void waitForPageLoad() {
        elements().addToCartFalcon9().waitToExists();
    }

    private MainPageElements elements() {
        return new MainPageElements(elementFindService);
    }
}
