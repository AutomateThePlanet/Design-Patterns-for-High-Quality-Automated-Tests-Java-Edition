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

package core.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public abstract class WaitStrategy {
    private final int _timeoutIntervalSeconds;
    private final int _sleepIntervalSeconds;

    public WaitStrategy(int timeoutIntervalSeconds, int sleepIntervalSeconds) {
        this._timeoutIntervalSeconds = timeoutIntervalSeconds;
        this._sleepIntervalSeconds = sleepIntervalSeconds;
    }

    public int getTimeoutIntervalSeconds() {
        return _timeoutIntervalSeconds;
    }

    public int getSleepIntervalSeconds() {
        return _sleepIntervalSeconds;
    }

    public abstract void waitUntil(SearchContext searchContext, WebDriver driver, By by);

    protected void waitUntil(Function<SearchContext, Boolean> waitCondition, WebDriver driver)
    {
        var webDriverWait = new WebDriverWait(driver, _timeoutIntervalSeconds, _sleepIntervalSeconds);
        webDriverWait.until(waitCondition);
    }

    protected WebElement findElement(SearchContext searchContext, By by)
    {
        var element = searchContext.findElement(by);
        return element;
    }
}
