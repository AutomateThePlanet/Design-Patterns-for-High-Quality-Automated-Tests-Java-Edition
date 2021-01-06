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

package core.browserinfrastructure;

import core.Browser;

public class BrowserConfiguration {
    private Browser _browser;
    private BrowserBehavior _browserBehavior;

    public BrowserConfiguration(Browser browser, BrowserBehavior browserBehavior) {
        _browser = browser;
        _browserBehavior = browserBehavior;
    }

    public BrowserBehavior getBrowserBehavior() {
        return _browserBehavior;
    }

    public void setBrowserBehavior(BrowserBehavior _browserBehavior) {
        this._browserBehavior = _browserBehavior;
    }

    public Browser getBrowser() {
        return _browser;
    }

    public void setBrowser(Browser _browser) {
        this._browser = _browser;
    }
}
