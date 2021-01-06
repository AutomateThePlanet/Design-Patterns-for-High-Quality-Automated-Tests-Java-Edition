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
    protected final Element Element;

    protected ElementDecorator(Element element) {
        Element = element;
    }

    @Override
    public By getBy() {
        return Element.getBy();
    }

    @Override
    public String getText() {
        return Element.getText();
    }

    @Override
    public Boolean isEnabled() {
        return Element.isEnabled();
    }

    @Override
    public Boolean isDisplayed() {
        return Element.isDisplayed();
    }

    @Override
    public void typeText(String text) throws InterruptedException {
        Element.typeText(text);
    }

    @Override
    public void click() {
        Element.click();
    }

    @Override
    public String getAttribute(String attributeName) {
        return Element.getAttribute(attributeName);
    }

    @Override
    public void waitToExists() {
        Element.waitToExists();
    }

    @Override
    public core.Element findById(String id) {
        return Element.findById(id);
    }

    @Override
    public core.Element findByXPath(String xpath) {
        return Element.findByXPath(xpath);
    }

    @Override
    public core.Element findByTag(String tag) {
        return Element.findByTag(tag);
    }

    @Override
    public core.Element findByClass(String cssClass) {
        return Element.findByClass(cssClass);
    }

    @Override
    public core.Element findByCss(String css) {
        return Element.findByCss(css);
    }

    @Override
    public core.Element findByLinkText(String linkText) {
        return Element.findByLinkText(linkText);
    }

    @Override
    public List<core.Element> findAllById(String id) {
        return Element.findAllById(id);
    }

    @Override
    public List<core.Element> findAllByXPath(String xpath) {
        return Element.findAllByXPath(xpath);
    }

    @Override
    public List<core.Element> findAllByTag(String tag) {
        return Element.findAllByTag(tag);
    }

    @Override
    public List<core.Element> findAllByClass(String cssClass) {
        return Element.findAllByClass(cssClass);
    }

    @Override
    public List<core.Element> findAllByCss(String css) {
        return Element.findAllByCss(css);
    }

    @Override
    public List<core.Element> findAllByLinkText(String linkText) {
        return Element.findAllByLinkText(linkText);
    }

    @Override
    public List<core.Element> findAll(FindStrategy findStrategy) {
        return Element.findAll(findStrategy);
    }

    @Override
    public core.Element find(FindStrategy findStrategy) {
        return Element.find(findStrategy);
    }
}
