package core.locators;

import org.openqa.selenium.By;

public class CssFindStrategy extends FindStrategy {
    public CssFindStrategy(String value)
    {
        super(value);
    }

    @Override
    public By convert() {
        return By.cssSelector(getValue());
    }
}
