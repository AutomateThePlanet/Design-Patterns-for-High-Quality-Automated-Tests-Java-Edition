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

package pages.v10.multifilepageobjectpagesectionsappfluent;

import core.LoggingSingletonDriver;
import core.interfaces.ElementFindService;
import pages.v10.multifilepageobjectpagesectionsappfluent.Sections.CartInfoSection;
import pages.v10.multifilepageobjectpagesectionsappfluent.Sections.MainMenuSection;
import pages.v10.multifilepageobjectpagesectionsappfluent.Sections.SearchSection;

public abstract class EShopPage {
    protected final ElementFindService elementFindService;

    public EShopPage() {
        this.elementFindService = LoggingSingletonDriver.getInstance();
    }

    public MainMenuSection mainMenuSection() {
        return new MainMenuSection(elementFindService);
    }

    public CartInfoSection cartInfoSection() {
        return new CartInfoSection(elementFindService);
    }

    public SearchSection searchSection() {
        return new SearchSection(elementFindService);
    }
}
