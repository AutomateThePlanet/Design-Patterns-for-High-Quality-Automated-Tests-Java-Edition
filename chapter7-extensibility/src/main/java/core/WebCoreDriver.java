/*
 * Copyright 2021 Automate The Planet Ltd.
 * Author: Anton Angelov
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package core;

import core.locators.*;
import core.wait.WaitStrategy;
import io.github.bonigarcia.wdm.WebDriverManager;
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
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private EventFiringWebDriver eventFiringWebDriver;

    @Override
    public void start(Browser browser) {
        switch (browser)
        {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case EDGE:
                //_webDriver = new EdgeDriver();
                break;
            case OPERA:
                //_webDriver = new OperaDriver();
                break;
            case SAFARI:
                //_webDriver = new SafariDriver();
                break;
            case INTERNET_EXPLORER:
                //_webDriver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalArgumentException(browser.name());
        }

        webDriverWait = new WebDriverWait(webDriver, 30);
        eventFiringWebDriver = new EventFiringWebDriver(webDriver);
        eventFiringWebDriver.register(new LoggingListener());
    }

    @Override
    public void quit() {
        webDriver.quit();
    }

    @Override
    public void goToUrl(String url) {
        webDriver.navigate().to(url);
    }

    @Override
    public String getUrl() {
        return webDriver.getCurrentUrl();
    }

    @Override
    public void waitForAjax() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        webDriverWait.until(d -> (Boolean)javascriptExecutor.executeScript("return window.jQuery != undefined && jQuery.active == 0"));
    }

    @Override
    public void waitUntilPageLoadsCompletely() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        webDriverWait.until(d -> javascriptExecutor.executeScript("return document.readyState").toString().equals("complete"));
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
                webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(findStrategy.convert()));
        var elements = new ArrayList<Element>();
        for (WebElement nativeWebElement:nativeWebElements) {
            Element element = new WebCoreElement(webDriver, nativeWebElement, findStrategy.convert());
            Element logElement = new LogElement(element);
            elements.add(logElement);
        }

        return elements;
    }

    @Override
    public Element find(FindStrategy findStrategy) {
        var nativeWebElement =
                webDriverWait.until(ExpectedConditions.presenceOfElementLocated(findStrategy.convert()));
        Element element = new WebCoreElement(webDriver, nativeWebElement, findStrategy.convert());

        // If we use log decorator.
        Element logElement = new LogElement(element);

        return logElement;
    }

    @Override
    public void wait(Element element, WaitStrategy waitStrategy) {
        waitStrategy.waitUntil(webDriver, webDriver, element.getBy());
    }
}
