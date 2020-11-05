package instrumentedcode;

import org.openqa.selenium.By;

import java.util.List;

public class LoggingDriver extends DriverDecorator {
    public LoggingDriver(Driver driver) {
        super(driver);
    }

    @Override
    public void start(Browser browser) {
        System.out.print(String.format("start browser = %s", browser.name()));
        Driver.start(browser);
    }

    @Override
    public void quit() {
        System.out.print("close browser");
        Driver.quit();
    }

    @Override
    public void goToUrl(String url) {
        System.out.print(String.format("go to url = %s", url));
        Driver.goToUrl(url);
    }

    @Override
    public Element findElement(By locator) {
        System.out.print("find element");
        return Driver.findElement(locator);
    }

    @Override
    public List<Element> findElements(By locator) {
        System.out.print("find elements");
        return Driver.findElements(locator);
    }
}
