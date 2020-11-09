package core.locators;

import org.openqa.selenium.By;

public class IdContainingFindStrategy extends FindStrategy {
    public IdContainingFindStrategy(String value)
    {
        super(value);
    }

    @Override
    public By convert() {
        return By.cssSelector(String.format("[id*='%s']", getValue()));
    }
}