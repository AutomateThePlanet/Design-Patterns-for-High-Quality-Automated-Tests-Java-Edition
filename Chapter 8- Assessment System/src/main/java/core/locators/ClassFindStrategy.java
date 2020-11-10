package core.locators;

import org.openqa.selenium.By;

public class ClassFindStrategy extends FindStrategy {
    public ClassFindStrategy(String value)
    {
        super(value);
    }

    @Override
    public By convert() {
        return By.xpath(String.format("//*[@class='%s']", getValue()));
    }
}
