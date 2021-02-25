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

package pages.v8.multifilepageobjectsectionssingleton.Sections;

import core.Element;
import core.ElementFindService;
import org.openqa.selenium.By;

public class CartInfoSection {
    private final ElementFindService elementFindService;

    public CartInfoSection(ElementFindService elementFindService) {
        this.elementFindService = elementFindService;
    }

    private Element cartIcon() {
        return elementFindService.findElement(By.className("cart-contents"));
    }

    private Element cartAmount() {
        return elementFindService.findElement(By.className("amount"));
    }

    public String getCurrentAmount() {
        return cartAmount().getText();
    }

    public void openCart() {
        cartIcon().click();
    }
}
