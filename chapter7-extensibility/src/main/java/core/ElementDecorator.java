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

public class ElementDecorator extends Element {
    protected final Element element;

    protected ElementDecorator(Element element) {
        this.element = element;
    }

    @Override
    public By getBy() {
        return element.getBy();
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public Boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public Boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public void typeText(String text) throws InterruptedException {
        element.typeText(text);
    }

    @Override
    public void click() {
        element.click();
    }

    @Override
    public String getAttribute(String attributeName) {
        return element.getAttribute(attributeName);
    }

    @Override
    public void waitToExists() {
        element.waitToExists();
    }

    @Override
    public core.Element findById(String id) {
        return element.findById(id);
    }

    @Override
    public core.Element findByXPath(String xpath) {
        return element.findByXPath(xpath);
    }

    @Override
    public core.Element findByTag(String tag) {
        return element.findByTag(tag);
    }

    @Override
    public core.Element findByClass(String cssClass) {
        return element.findByClass(cssClass);
    }

    @Override
    public core.Element findByCss(String css) {
        return element.findByCss(css);
    }

    @Override
    public core.Element findByLinkText(String linkText) {
        return element.findByLinkText(linkText);
    }

    @Override
    public List<core.Element> findAllById(String id) {
        return element.findAllById(id);
    }

    @Override
    public List<core.Element> findAllByXPath(String xpath) {
        return element.findAllByXPath(xpath);
    }

    @Override
    public List<core.Element> findAllByTag(String tag) {
        return element.findAllByTag(tag);
    }

    @Override
    public List<core.Element> findAllByClass(String cssClass) {
        return element.findAllByClass(cssClass);
    }

    @Override
    public List<core.Element> findAllByCss(String css) {
        return element.findAllByCss(css);
    }

    @Override
    public List<core.Element> findAllByLinkText(String linkText) {
        return element.findAllByLinkText(linkText);
    }

    @Override
    public List<core.Element> findAll(FindStrategy findStrategy) {
        return element.findAll(findStrategy);
    }

    @Override
    public core.Element find(FindStrategy findStrategy) {
        return element.find(findStrategy);
    }
}
