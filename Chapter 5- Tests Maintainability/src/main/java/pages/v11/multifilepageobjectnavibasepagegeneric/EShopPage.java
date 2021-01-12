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

package pages.v11.multifilepageobjectnavibasepagegeneric;

import core.Driver;
import pages.v3.singlefilepageobjectssections.Sections.CartInfoSection;
import pages.v3.singlefilepageobjectssections.Sections.MainMenuSection;
import pages.v3.singlefilepageobjectssections.Sections.SearchSection;

import java.lang.reflect.ParameterizedType;

public abstract class EShopPage<ElementsT extends BaseElements> {
    protected final Driver driver;

    public EShopPage(Driver driver) {
        this.driver = driver;
    }

    protected ElementsT elements() {
        try {
            var elementsClass = (Class<ElementsT>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            return elementsClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
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
