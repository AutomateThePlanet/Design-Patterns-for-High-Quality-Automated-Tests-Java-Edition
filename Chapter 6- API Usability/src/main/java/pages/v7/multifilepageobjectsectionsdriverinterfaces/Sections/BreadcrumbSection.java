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

package pages.v7.multifilepageobjectsectionsdriverinterfaces.Sections;

import core.Element;
import core.ElementFindService;
import org.openqa.selenium.By;

public class BreadcrumbSection {
    private final ElementFindService _elementFindService;

    public BreadcrumbSection(ElementFindService elementFindService) {
        _elementFindService = elementFindService;
    }

    private Element breadcrumb() {
        return _elementFindService.findElement(By.className("woocommerce-breadcrumb"));
    }

    public void openBreadcrumbItem(String itemToOpen)
    {
        breadcrumb().findElement(By.linkText(itemToOpen)).click();
    }
}
