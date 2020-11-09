package core.wait;

import org.openqa.selenium.*;

public class ToBeClickableWaitStrategy extends WaitStrategy{
    public ToBeClickableWaitStrategy(int timeoutIntervalSeconds, int sleepIntervalSeconds) {
       super(timeoutIntervalSeconds, sleepIntervalSeconds);
    }

    @Override
    public void waitUntil(SearchContext searchContext, WebDriver driver, By by) {
        waitUntil((x) -> elementIsClickable(searchContext, by), driver);
    }

    private Boolean elementIsClickable(SearchContext searchContext, By by)
    {
        var element = findElement(searchContext, by);
        try
        {
            return element != null && element.isEnabled();
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
