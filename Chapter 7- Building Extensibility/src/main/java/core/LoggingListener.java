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

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class LoggingListener implements WebDriverEventListener {
    @Override
    public void beforeAlertAccept(WebDriver driver) {
        System.out.print("before alert accepted");
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
        System.out.print("after alert accepted");
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
        System.out.print("after alert dismiss");
    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
        System.out.print("before alert dismiss");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.print("before navigate to");
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.print("after navigate to");
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        System.out.print("before navigate back");
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        System.out.print("after navigate back");
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        System.out.print("before navigate forward");
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        System.out.print("after navigate forward");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        System.out.print("before navigate refresh");
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        System.out.print("after navigate refresh");
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.print("before find by");
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.print("after find by");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.print("before click on");
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.print("after click on");
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.print("before change value of");
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.print("after change value of");
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        System.out.print("before script");
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        System.out.print("after script");
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        System.out.print("before switch to window");
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        System.out.print("after switch to window");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        System.out.print("on exception");
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        System.out.print("before get text");
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        System.out.print("after get text");
    }
}
