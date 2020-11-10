package core;

import core.locators.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class WebCoreDriver extends Driver {
    private WebDriver _webDriver;
    private WebDriverWait _webDriverWait;
    private EventFiringWebDriver _eventFiringWebDriver;

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
        _eventFiringWebDriver = new EventFiringWebDriver(_webDriver);
        _eventFiringWebDriver.register(new LoggingListener());
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
    public void waitForAjax() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)_webDriver;
        _webDriverWait.until(d -> (Boolean)javascriptExecutor.executeScript("return window.jQuery != undefined && jQuery.active == 0"));
    }

    @Override
    public void waitUntilPageLoadsCompletely() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)_webDriver;
        _webDriverWait.until(d -> javascriptExecutor.executeScript("return document.readyState").toString().equals("complete"));
    }

    @Override
    public Element findById(String id) {
        return find(new IdFindStrategy(id));
    }

    @Override
    public Element findByXPath(String xpath) {
        return find(new XPathFindStrategy(xpath));
    }

    @Override
    public Element findByTag(String tag) {
        return find(new TagFindStrategy(tag));
    }

    @Override
    public Element findByClass(String cssClass) {
        return find(new ClassFindStrategy(cssClass));
    }

    @Override
    public Element findByCss(String css) {
        return find(new CssFindStrategy(css));
    }

    @Override
    public Element findByLinkText(String linkText) {
        return find(new LinkTextFindStrategy(linkText));
    }

    @Override
    public List<Element> findAllById(String id) {
        return findAll(new IdFindStrategy(id));
    }

    @Override
    public List<Element> findAllByXPath(String xpath) {
        return findAll(new XPathFindStrategy(xpath));
    }

    @Override
    public List<Element> findAllByTag(String tag) {
        return findAll(new TagFindStrategy(tag));
    }

    @Override
    public List<Element> findAllByClass(String cssClass) {
        return findAll(new ClassFindStrategy(cssClass));
    }

    @Override
    public List<Element> findAllByCss(String css) {
        return findAll(new CssFindStrategy(css));
    }

    @Override
    public List<Element> findAllByLinkText(String linkText) {
        return findAll(new LinkTextFindStrategy(linkText));
    }

    @Override
    public List<Element> findAll(FindStrategy findStrategy) {
        List<WebElement> nativeWebElements =
                _webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(findStrategy.convert()));
        var elements = new ArrayList<Element>();
        for (WebElement nativeWebElement:nativeWebElements) {
            Element element = new WebCoreElement(_webDriver, nativeWebElement, findStrategy.convert());
            Element logElement = new LogElement(element);
            elements.add(logElement);
        }

        return elements;
    }

    @Override
    public Element find(FindStrategy findStrategy) {
        var nativeWebElement =
                _webDriverWait.until(ExpectedConditions.presenceOfElementLocated(findStrategy.convert()));
        Element element = new WebCoreElement(_webDriver, nativeWebElement, findStrategy.convert());

        // If we use log decorator.
        Element logElement = new LogElement(element);

        return logElement;
    }
}
