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

package pages.v9.multifilepageobjectpagesectionsapp.MainPage;

import core.Driver;
import pages.v9.multifilepageobjectpagesectionsapp.LoggingSingletonDriver;
import pages.v9.multifilepageobjectpagesectionsapp.NavigatableEShopPage;
import pages.v9.multifilepageobjectpagesectionsapp.SingletonFactory;

public class MainPage extends NavigatableEShopPage {
    private static MainPage instance;

    public MainPage(Driver driver) {
        super(driver, driver);
    }

    public static MainPage getInstance() {
        if (instance == null) {
            instance = new MainPage(LoggingSingletonDriver.getInstance());
        }

        return instance;
    }

    public static MainPage getInstanceFactory() {
        MainPage mainPage = null;
        try {
            return SingletonFactory.getInstance(MainPage.class);
        } catch (Exception e) {
            // not the best practice to return null. But probably we will never end here so it is OK.
            return mainPage;
        }
    }

    public MainPageElements elements() {
        return new MainPageElements(elementFindService);
    }

    public MainPageAssertions assertions() {
        return new MainPageAssertions(elements());
    }

    @Override
    protected String getUrl() {
        return "http://demos.bellatrix.solutions/";
    }

    @Override
    protected void waitForPageLoad() {
        elements().addToCartFalcon9().waitToExists();
    }


    public void addRocketToShoppingCart() {
        open();
        elements().addToCartFalcon9().click();
        elements().viewCartButton().click();
    }
}
