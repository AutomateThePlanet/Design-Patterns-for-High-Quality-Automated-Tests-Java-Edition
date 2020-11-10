package core.locators;

import org.openqa.selenium.By;

public abstract class FindStrategy {
    private final String _value;

    protected FindStrategy(String value)
    {
        _value = value;
    }

    public String getValue()
    {
        return _value;
    }

    public abstract By convert();
}
