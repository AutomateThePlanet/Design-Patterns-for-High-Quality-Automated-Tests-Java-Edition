package core.locators;

import org.openqa.selenium.By;

public class InnerTextContainsFindStrategy extends FindStrategy {
    public InnerTextContainsFindStrategy(String value)
    {
        super(value);
    }

    @Override
    public By convert() {
        return By.xpath(String.format("//*[contains(text(), '%s')]", getValue()));
    }
}
