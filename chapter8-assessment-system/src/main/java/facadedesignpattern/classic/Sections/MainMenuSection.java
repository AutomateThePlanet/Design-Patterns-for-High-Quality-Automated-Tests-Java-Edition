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

package facadedesignpattern.classic.Sections;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;

public class MainMenuSection {
    private final Driver driver;

    public MainMenuSection(Driver driver) {
        this.driver = driver;
    }

    private Element homeLink() {
        return driver.findElement(By.linkText("Home"));
    }

    private Element blogLink() {
        return driver.findElement(By.linkText("Blog"));
    }

    private Element cartLink() {
        return driver.findElement(By.linkText("Cart"));
    }

    private Element checkoutLink() {
        return driver.findElement(By.linkText("Checkout"));
    }

    private Element myAccountLink() {
        return driver.findElement(By.linkText("My Account"));
    }

    private Element promotionsLink() {
        return driver.findElement(By.linkText("Promotions"));
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
