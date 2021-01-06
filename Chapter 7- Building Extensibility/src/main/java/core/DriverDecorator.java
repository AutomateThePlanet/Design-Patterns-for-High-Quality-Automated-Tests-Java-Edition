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
import org.openqa.selenium.By;

import java.util.List;

public class DriverDecorator extends Driver {
    protected final Driver Driver;

    public DriverDecorator(Driver driver) {
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
    public String getUrl() {
        return Driver.getUrl();
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
        Driver.waitForAjax();
    }

    @Override
    public void waitUntilPageLoadsCompletely() {
        Driver.waitUntilPageLoadsCompletely();
    }

    @Override
    public Element findById(String id) {
        return Driver.findById(id);
    }

    @Override
    public Element findByXPath(String xpath) {
        return Driver.findByXPath(xpath);
    }

    @Override
    public Element findByTag(String tag) {
        return Driver.findByTag(tag);
    }

    @Override
    public Element findByClass(String cssClass) {
        return Driver.findByClass(cssClass);
    }

    @Override
    public Element findByCss(String css) {
        return Driver.findByCss(css);
    }

    @Override
    public Element findByLinkText(String linkText) {
        return Driver.findByLinkText(linkText);
    }

    @Override
    public List<Element> findAllById(String id) {
        return Driver.findAllById(id);
    }

    @Override
    public List<Element> findAllByXPath(String xpath) {
        return Driver.findAllByXPath(xpath);
    }

    @Override
    public List<Element> findAllByTag(String tag) {
        return Driver.findAllByTag(tag);
    }

    @Override
    public List<Element> findAllByClass(String cssClass) {
        return Driver.findAllByClass(cssClass);
    }

    @Override
    public List<Element> findAllByCss(String css) {
        return Driver.findAllByCss(css);
    }

    @Override
    public List<Element> findAllByLinkText(String linkText) {
        return Driver.findAllByLinkText(linkText);
    }

    @Override
    public List<Element> findAll(FindStrategy findStrategy) {
        return Driver.findAll(findStrategy);
    }

    @Override
    public Element find(FindStrategy findStrategy) {
        return Driver.find(findStrategy);
    }
}