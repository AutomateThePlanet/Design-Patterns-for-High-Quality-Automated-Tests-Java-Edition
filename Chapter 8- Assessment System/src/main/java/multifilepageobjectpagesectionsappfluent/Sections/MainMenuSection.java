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

package multifilepageobjectpagesectionsappfluent.Sections;

import core.Element;
import core.ElementFindService;
import org.openqa.selenium.By;

public class MainMenuSection {
    private final ElementFindService _elementFindService;

    public MainMenuSection(ElementFindService elementFindService) {
        _elementFindService = elementFindService;
    }

    private Element homeLink() {
        return _elementFindService.findElement(By.linkText("Home"));
    }

    private Element blogLink() {
        return _elementFindService.findElement(By.linkText("Blog"));
    }

    private Element cartLink() {
        return _elementFindService.findElement(By.linkText("Cart"));
    }

    private Element checkoutLink() {
        return _elementFindService.findElement(By.linkText("Checkout"));
    }

    private Element myAccountLink() {
        return _elementFindService.findElement(By.linkText("My Account"));
    }

    private Element promotionsLink() {
        return _elementFindService.findElement(By.linkText("Promotions"));
    }

    public void openHomePage()
    {
        homeLink().click();
    }

    public void openBlogPage()
    {
        blogLink().click();
    }

    public void openMyAccountPage()
    {
        myAccountLink().click();
    }

    public void openPromotionsPage()
    {
        promotionsLink().click();
    }
}
