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

package pages.v6.multifilepageobjectnavibasepagesections;

import core.Driver;
import pages.v7.multifilepageobjectsectionsdriverinterfaces.Sections.CartInfoSection;
import pages.v7.multifilepageobjectsectionsdriverinterfaces.Sections.MainMenuSection;
import pages.v7.multifilepageobjectsectionsdriverinterfaces.Sections.SearchSection;

public abstract class EShopPage {
    protected final Driver driver;

    public EShopPage(Driver driver) {
        this.driver = driver;
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
}
