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

package pages.v8.multifilepageobjectsectionssingleton.MainPage;

import core.ElementFindService;
import core.NavigationService;
import pages.v8.multifilepageobjectsectionssingleton.CartPage.CartPage;
import pages.v8.multifilepageobjectsectionssingleton.LoggingSingletonDriver;
import pages.v8.multifilepageobjectsectionssingleton.NavigatableEShopPage;
import pages.v8.multifilepageobjectsectionssingleton.SingletonFactory;

import java.lang.reflect.InvocationTargetException;

public class MainPage extends NavigatableEShopPage {
    private static MainPage _instance;

    public static MainPage getInstance()
    {
        if (_instance == null)
        {
            _instance = new MainPage();
        }

        return _instance;
    }

    public static MainPage getInstanceFactory() {
        MainPage mainPage = null;
        try
        {
            return SingletonFactory.getInstance(MainPage.class);
        }
        catch (Exception e)
        {
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

    public void addRocketToShoppingCart()
    {
        open();
        elements().addToCartFalcon9().click();
        elements().viewCartButton().click();
    }
}
