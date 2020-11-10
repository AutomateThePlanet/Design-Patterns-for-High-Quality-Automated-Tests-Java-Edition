package core.wait;

public class WaitStrategyFactory {
    public ToExistsWaitStrategy exists(int timeoutInterval, int sleepInterval)
    {
        return new ToExistsWaitStrategy(timeoutInterval, sleepInterval);
    }

    public ToBeVisibleWaitStrategy beVisible(int timeoutInterval, int sleepInterval)
    {
        return new ToBeVisibleWaitStrategy(timeoutInterval, sleepInterval);
    }

    public ToBeClickableWaitStrategy beClickable(int timeoutInterval, int sleepInterval)
    {
        return new ToBeClickableWaitStrategy(timeoutInterval, sleepInterval);
    }
}
