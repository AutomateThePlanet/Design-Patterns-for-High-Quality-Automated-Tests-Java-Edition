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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void waitToExists() {
        var webDriverWait = new WebDriverWait(_webDriver, 30);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(getBy()));
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
        List<WebElement> nativeWebElements = _webElement.findElements(findStrategy.convert());
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
        var nativeWebElement = _webElement.findElement(findStrategy.convert());
        Element element = new WebCoreElement(_webDriver, nativeWebElement, findStrategy.convert());
        Element logElement = new LogElement(element);

        return logElement;
    }

    private void waitToBeClickable(By by)
    {
        var webDriverWait = new WebDriverWait(_webDriver, 30);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
