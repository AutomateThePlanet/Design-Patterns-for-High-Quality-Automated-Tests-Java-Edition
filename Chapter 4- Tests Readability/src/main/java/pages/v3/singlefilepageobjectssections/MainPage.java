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

package pages.v3.singlefilepageobjectssections;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;
import pages.v3.singlefilepageobjectssections.Sections.CartInfoSection;
import pages.v3.singlefilepageobjectssections.Sections.MainMenuSection;
import pages.v3.singlefilepageobjectssections.Sections.SearchSection;

public class MainPage {
    private final Driver driver;
    private final String _url = "http://demos.bellatrix.solutions/";

    public MainPage(Driver driver)
    {
        this.driver = driver;
    }

    private Element addToCartFalcon9() {
        return driver.findElement(By.cssSelector("[data-product_id*='28']"));
    }

    private Element viewCartButton() {
        return driver.findElement(By.cssSelector("[class*='added_to_cart wc-forward']"));
    }

    public MainMenuSection mainMenuSection() {
        return new MainMenuSection(driver);
    }

    public CartInfoSection cartInfoSection() {
        return new CartInfoSection(driver);
    }

    public SearchSection searchSection() {
        return new SearchSection(driver);
    }

    public void addRocketToShoppingCart()
    {
        driver.goToUrl(_url);
        addToCartFalcon9().click();
        viewCartButton().click();
    }
}
