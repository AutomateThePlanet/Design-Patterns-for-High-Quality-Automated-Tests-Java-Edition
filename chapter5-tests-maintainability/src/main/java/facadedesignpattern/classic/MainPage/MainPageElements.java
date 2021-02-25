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

package facadedesignpattern.classic.MainPage;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;

public class MainPageElements {
    private final Driver driver;

    public MainPageElements(Driver driver) {
        this.driver = driver;
    }

    public Element addToCartFalcon9() {
        return driver.findElement(By.cssSelector("[data-product_id*='28']"));
    }

    public Element viewCartButton() {
        return driver.findElement(By.cssSelector("[class*='added_to_cart wc-forward']"));
    }

    public Element getAddToCartByName(String name) {
        return driver.findElement(By.xpath(String.format("//h2[text()='%s']/parent::a[1]", name)));
    }

    public Element getProductBoxByName(String name) {
        return driver.findElement(By.xpath(String.format("//h2[text()='%s']/parent::a[1]/following-sibling::a[1]", name)));
    }
}
