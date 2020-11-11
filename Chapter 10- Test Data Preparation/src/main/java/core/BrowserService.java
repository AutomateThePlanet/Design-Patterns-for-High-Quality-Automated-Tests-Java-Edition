package core;

import java.io.IOException;

public interface BrowserService {
    void start(Browser browser) throws IOException;
    void quit();
    void waitForAjax();
    void waitUntilPageLoadsCompletely();
}
