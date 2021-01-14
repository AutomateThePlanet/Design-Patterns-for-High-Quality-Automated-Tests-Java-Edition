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

import core.locators.FindStrategy;
import core.wait.WaitStrategy;

import java.util.List;

public class DriverDecorator extends Driver {
    protected final Driver driver;

    public DriverDecorator(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void start(Browser browser) {
        driver.start(browser);
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public void goToUrl(String url) {
        driver.goToUrl(url);
    }

    @Override
    public String getUrl() {
        return driver.getUrl();
    }

//    @Override
//    public Element findElement(By locator) {
//        return Driver.findElement(locator);
//    }
//
//    @Override
//    public List<Element> findElements(By locator) {
//        return Driver.findElements(locator);
//    }

    @Override
    public void waitForAjax() {
        driver.waitForAjax();
    }

    @Override
    public void waitUntilPageLoadsCompletely() {
        driver.waitUntilPageLoadsCompletely();
    }

    @Override
    public Element findById(String id) {
        return driver.findById(id);
    }

    @Override
    public Element findByXPath(String xpath) {
        return driver.findByXPath(xpath);
    }

    @Override
    public Element findByTag(String tag) {
        return driver.findByTag(tag);
    }

    @Override
    public Element findByClass(String cssClass) {
        return driver.findByClass(cssClass);
    }

    @Override
    public Element findByCss(String css) {
        return driver.findByCss(css);
    }

    @Override
    public Element findByLinkText(String linkText) {
        return driver.findByLinkText(linkText);
    }

    @Override
    public List<Element> findAllById(String id) {
        return driver.findAllById(id);
    }

    @Override
    public List<Element> findAllByXPath(String xpath) {
        return driver.findAllByXPath(xpath);
    }

    @Override
    public List<Element> findAllByTag(String tag) {
        return driver.findAllByTag(tag);
    }

    @Override
    public List<Element> findAllByClass(String cssClass) {
        return driver.findAllByClass(cssClass);
    }

    @Override
    public List<Element> findAllByCss(String css) {
        return driver.findAllByCss(css);
    }

    @Override
    public List<Element> findAllByLinkText(String linkText) {
        return driver.findAllByLinkText(linkText);
    }

    @Override
    public List<Element> findAll(FindStrategy findStrategy) {
        return driver.findAll(findStrategy);
    }

    @Override
    public Element find(FindStrategy findStrategy) {
        return driver.find(findStrategy);
    }

    @Override
    public void wait(Element element, WaitStrategy waitStrategy) {
        driver.wait(element, waitStrategy);
    }
}