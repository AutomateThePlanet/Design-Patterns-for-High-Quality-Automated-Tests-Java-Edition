package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebCoreElement extends Element {
    private final WebDriver _webDriver;
    private final WebElement _webElement;
    private final By _by;

    public WebCoreElement(WebDriver webDriver, WebElement webElement, By by)
    {
        _webDriver = webDriver;
        _webElement = webElement;
        _by = by;
    }

    @Override
    public By getBy() {
        return _by;
    }

    @Override
    public String getText() {
        return _webElement.getText();
    }

    @Override
    public Boolean isEnabled() {
        return _webElement.isEnabled();
    }

    @Override
    public Boolean isDisplayed() {
        return _webElement.isDisplayed();
    }

    @Override
    public void typeText(String text) throws InterruptedException {
        Thread.sleep(500);
        _webElement.clear();
        _webElement.sendKeys(text);
    }

    @Override
    public void click() {
        waitToBeClickable(_by);
        _webElement.click();
    }

    @Override
    public String getAttribute(String attributeName) {
        return _webElement.getAttribute(attributeName);
    }

    private void waitToBeClickable(By by)
    {
        var webDriverWait = new WebDriverWait(_webDriver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
