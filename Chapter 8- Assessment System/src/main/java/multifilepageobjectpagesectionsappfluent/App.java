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

package multifilepageobjectpagesectionsappfluent;

import core.*;

public class App implements AutoCloseable {
    private Boolean _disposed = false;

    public App(Browser browserType)
    {
        LoggingSingletonDriver.getInstance().start(browserType);
    }

    public NavigationService getNavigationService() {
        return SingletonFactory.getInstance(NavigationService.class);
    }

    public BrowserService getBrowserService() {
        return SingletonFactory.getInstance(BrowserService.class);
    }

    public CookiesService getCookiesService() {
        return SingletonFactory.getInstance(CookiesService.class);
    }

    public DialogService getDialogService() {
        return SingletonFactory.getInstance(DialogService.class);
    }

    public <TPage extends NavigatableEShopPage> TPage goTo(Class<TPage> pageOf)
    {
        var page = SingletonFactory.getInstance(pageOf);
        page.open();

        return page;
    }

    public <TPage extends EShopPage> TPage create(Class<TPage> pageOf)
    {
        return SingletonFactory.getInstance(pageOf);
    }

    @Override
    public void close() throws Exception {
        if (_disposed)
        {
            return;
        }

        LoggingSingletonDriver.getInstance().quit();

        _disposed = true;
    }
}
