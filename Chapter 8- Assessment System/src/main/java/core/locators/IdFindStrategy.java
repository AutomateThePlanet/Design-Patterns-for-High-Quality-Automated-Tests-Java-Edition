package core.locators;

import org.openqa.selenium.By;

public class IdFindStrategy extends FindStrategy {
    public IdFindStrategy(String value)
    {
        super(value);
    }

    @Override
    public By convert() {
        return By.id(getValue());
    }
}
