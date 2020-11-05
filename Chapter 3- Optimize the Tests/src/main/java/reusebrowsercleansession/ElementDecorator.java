package reusebrowsercleansession;

import org.openqa.selenium.By;

public class ElementDecorator extends reusebrowsercleansession.Element {
    protected final reusebrowsercleansession.Element Element;

    protected ElementDecorator(reusebrowsercleansession.Element element) {
        Element = element;
    }

    @Override
    public By getBy() {
        return Element.getBy();
    }

    @Override
    public String getText() {
        return Element.getText();
    }

    @Override
    public Boolean isEnabled() {
        return Element.isEnabled();
    }

    @Override
    public Boolean isDisplayed() {
        return Element.isDisplayed();
    }

    @Override
    public void typeText(String text) throws InterruptedException {
        Element.typeText(text);
    }

    @Override
    public void click() {
        Element.click();
    }

    @Override
    public String getAttribute(String attributeName) {
        return Element.getAttribute(attributeName);
    }
}
