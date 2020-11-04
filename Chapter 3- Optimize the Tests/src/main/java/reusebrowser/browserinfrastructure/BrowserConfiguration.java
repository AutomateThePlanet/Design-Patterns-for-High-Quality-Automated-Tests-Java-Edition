package reusebrowser.browserinfrastructure;

import reusebrowser.Browser;

public class BrowserConfiguration {
    private Browser _browser;
    private BrowserBehavior _browserBehavior;

    public BrowserConfiguration(Browser _browser, BrowserBehavior _browserBehavior) {
        _browser = _browser;
        _browserBehavior = _browserBehavior;
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
