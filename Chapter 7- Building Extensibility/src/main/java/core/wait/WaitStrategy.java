package core.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public abstract class WaitStrategy {
    private int _timeoutIntervalSeconds;
    private int _sleepIntervalSeconds;

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
