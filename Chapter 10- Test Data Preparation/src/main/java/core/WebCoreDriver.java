package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class WebCoreDriver extends Driver {
    private WebDriver _webDriver;
    private WebDriverWait _webDriverWait;

    @Override
    public void start(Browser browser) {
        switch (browser)
        {
            case Chrome:
                WebDriverManager.chromedriver().setup();
                _webDriver = new ChromeDriver();
                break;
            case Firefox:
                WebDriverManager.firefoxdriver().setup();
                _webDriver = new FirefoxDriver();
                break;
            case Edge:
                //_webDriver = new EdgeDriver();
                break;
            case Opera:
                //_webDriver = new OperaDriver();
                break;
            case Safari:
                //_webDriver = new SafariDriver();
                break;
            case InternetExplorer:
                //_webDriver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalArgumentException(browser.name());
        }

        _webDriverWait = new WebDriverWait(_webDriver, 30);
    }

    @Override
    public void quit() {
        _webDriver.quit();
    }

    @Override
    public void goToUrl(String url) {
        _webDriver.navigate().to(url);
    }

    @Override
    public String getUrl() {
        return _webDriver.getCurrentUrl();
    }

    @Override
    public Element findElement(By locator) {
        var nativeWebElement =
                _webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Element element = new WebCoreElement(_webDriver, nativeWebElement, locator);

        // If we use log decorator.
        Element logElement = new LogElement(element);

        return logElement;
    }

    @Override
    public List<Element> findElements(By locator) {
        List<WebElement> nativeWebElements =
                _webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        var elements = new ArrayList<Element>();
        for (WebElement nativeWebElement:nativeWebElements) {
            Element element = new WebCoreElement(_webDriver, nativeWebElement, locator);
            Element logElement = new LogElement(element);
            elements.add(logElement);
        }

        return elements;
    }

    @Override
    public void waitForAjax() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)_webDriver;
        _webDriverWait.until(d -> (Boolean)javascriptExecutor.executeScript("return window.jQuery != undefined && jQuery.active == 0"));
    }

    @Override
    public void waitUntilPageLoadsCompletely() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)_webDriver;
        _webDriverWait.until(d -> javascriptExecutor.executeScript("return document.readyState").toString().equals("complete"));
    }
}
