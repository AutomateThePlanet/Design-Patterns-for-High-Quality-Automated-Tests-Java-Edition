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
