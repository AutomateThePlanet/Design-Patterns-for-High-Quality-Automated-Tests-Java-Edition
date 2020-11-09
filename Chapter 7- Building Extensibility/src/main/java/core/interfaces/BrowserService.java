package core.interfaces;

import core.Browser;

public interface BrowserService {
    void start(Browser browser);
    void quit();
    void waitForAjax();
    void waitUntilPageLoadsCompletely();
}
