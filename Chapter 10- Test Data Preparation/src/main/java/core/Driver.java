package core;

import org.openqa.selenium.By;

import java.io.IOException;
import java.util.List;

public abstract class Driver implements NavigationService, BrowserService, CookiesService, ElementFindService, DialogService {
    public abstract void start(Browser browser) throws IOException;
    public abstract void quit();
    public abstract void goToUrl(String url);
    public abstract Element findElement(By locator);
    public abstract List<Element> findElements(By locator);
    public abstract void waitForAjax();
    public abstract void waitUntilPageLoadsCompletely();
}
