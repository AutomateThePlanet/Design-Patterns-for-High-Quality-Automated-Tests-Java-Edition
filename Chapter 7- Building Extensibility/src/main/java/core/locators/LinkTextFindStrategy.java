package core.locators;

import org.openqa.selenium.By;

public class LinkTextFindStrategy extends FindStrategy {
    public LinkTextFindStrategy(String value)
    {
        super(value);
    }

    @Override
    public By convert() {
        return By.linkText(getValue());
    }
}
