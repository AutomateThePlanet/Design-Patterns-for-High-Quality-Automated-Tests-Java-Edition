package reusebrowser;

import org.openqa.selenium.By;

import java.util.List;

public class DriverDecorator extends reusebrowser.Driver {
    protected final reusebrowser.Driver Driver;

    public DriverDecorator(reusebrowser.Driver driver) {
        Driver = driver;
    }

    @Override
    public void start(Browser browser) {
        Driver.start(browser);
    }

    @Override
    public void quit() {
        Driver.quit();
    }

    @Override
    public void goToUrl(String url) {
        Driver.goToUrl(url);
    }

    @Override
    public Element findElement(By locator) {
        return Driver.findElement(locator);
    }

    @Override
    public List<Element> findElements(By locator) {
        return Driver.findElements(locator);
    }

    @Override
    public void waitForAjax() {
        Driver.waitForAjax();
    }

    @Override
    public void waitUntilPageLoadsCompletely() {
        Driver.waitUntilPageLoadsCompletely();
    }
}