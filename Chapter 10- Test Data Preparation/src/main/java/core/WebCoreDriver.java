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

import configuration.ConfigurationService;
import configuration.WebSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebCoreDriver extends Driver {
    private WebDriver _webDriver;
    private WebDriverWait _webDriverWait;

    @Override
    public void start(Browser browser) throws IOException {
        var webSettings = ConfigurationService.get(WebSettings.class);
        switch (browser)
        {
            case Chrome:
                WebDriverManager.chromedriver().setup();
                _webDriver = new ChromeDriver();
                _webDriver.manage().timeouts().pageLoadTimeout(webSettings.getChrome().getPageLoadTimeout(), TimeUnit.SECONDS);
                _webDriver.manage().timeouts().setScriptTimeout(webSettings.getChrome().getScriptTimeout(), TimeUnit.SECONDS);
                break;
            case Firefox:
                WebDriverManager.firefoxdriver().setup();
                _webDriver = new FirefoxDriver();
                _webDriver.manage().timeouts().pageLoadTimeout(webSettings.getFirefox().getPageLoadTimeout(), TimeUnit.SECONDS);
                _webDriver.manage().timeouts().setScriptTimeout(webSettings.getFirefox().getScriptTimeout(), TimeUnit.SECONDS);
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

        _webDriverWait = new WebDriverWait(_webDriver, webSettings.getElementWaitTimeout());
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
