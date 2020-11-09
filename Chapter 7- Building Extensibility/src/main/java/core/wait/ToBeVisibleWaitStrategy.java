package core.wait;

import org.openqa.selenium.*;

public class ToBeVisibleWaitStrategy extends WaitStrategy{
    public ToBeVisibleWaitStrategy(int timeoutIntervalSeconds, int sleepIntervalSeconds) {
       super(timeoutIntervalSeconds, sleepIntervalSeconds);
    }

    @Override
    public void waitUntil(SearchContext searchContext, WebDriver driver, By by) {
        waitUntil((x) -> elementIsVisible(searchContext, by), driver);
    }

    private Boolean elementIsVisible(SearchContext searchContext, By by)
    {
        var element = findElement(searchContext, by);
        try
        {
            return element != null && element.isDisplayed();
        }
        catch (StaleElementReferenceException e)
        {
            return false;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }
}
