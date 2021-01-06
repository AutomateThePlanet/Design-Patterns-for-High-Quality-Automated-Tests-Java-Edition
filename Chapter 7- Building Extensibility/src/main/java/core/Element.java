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

public abstract class Element {
    public abstract By getBy();
    public abstract String getText();
    public abstract Boolean isEnabled();
    public abstract Boolean isDisplayed();
    public abstract void typeText(String text) throws InterruptedException;
    public abstract void click();
    public abstract String getAttribute(String attributeName);
    public abstract void waitToExists();
    public abstract Element findById(String id);
    public abstract Element findByXPath(String xpath);
    public abstract Element findByTag(String tag);
    public abstract Element findByClass(String cssClass);
    public abstract Element findByCss(String css);
    public abstract Element findByLinkText(String linkText);
    public abstract List<Element> findAllById(String id);
    public abstract List<Element> findAllByXPath(String xpath);
    public abstract List<Element> findAllByTag(String tag);
    public abstract List<Element> findAllByClass(String cssClass);
    public abstract List<Element> findAllByCss(String css);
    public abstract List<Element> findAllByLinkText(String linkText);

    public abstract List<Element> findAll(FindStrategy findStrategy);
    public abstract Element find(FindStrategy findStrategy);
}
