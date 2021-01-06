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

package reusebrowsercleansession;

import org.openqa.selenium.By;

import java.util.List;

public class DriverDecorator extends reusebrowsercleansession.Driver {
    protected final reusebrowsercleansession.Driver Driver;

    public DriverDecorator(reusebrowsercleansession.Driver driver) {
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
    public Element findElement(By locator) {
        return Driver.findElement(locator);
    }

    @Override
    public List<Element> findElements(By locator) {
        return Driver.findElements(locator);
    }

    @Override
    public void waitForAjax() {
        Driver.waitForAjax();
    }

    @Override
    public void waitUntilPageLoadsCompletely() {
        Driver.waitUntilPageLoadsCompletely();
    }

    @Override
    public void deleteAllCookies() {
        Driver.deleteAllCookies();
    }
}