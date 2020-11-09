package core;

public interface BrowserService {
    void start(Browser browser);
    void quit();
    void waitForAjax();
    void waitUntilPageLoadsCompletely();
}
