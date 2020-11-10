package core;

import org.openqa.selenium.By;

public class LogElement extends ElementDecorator {

    protected LogElement(Element element) {
        super(element);
    }

    @Override
    public By getBy() {
        return Element.getBy();
    }

    @Override
    public String getText() {
        System.out.printf("Element Text = %s", Element.getText());
        return Element.getText();
    }

    @Override
    public Boolean isEnabled() {
        System.out.printf("Element Enabled = %b", Element.isEnabled());
        return Element.isEnabled();
    }

    @Override
    public Boolean isDisplayed() {
        System.out.printf("Element Displayed = %b", Element.isDisplayed());
        return Element.isDisplayed();
    }

    @Override
    public void typeText(String text) throws InterruptedException {
        System.out.printf("Type Text = = %s", text);
        Element.typeText(text);
    }

    @Override
    public void click() {
        System.out.print("Element Clicked");
        Element.click();
    }

    @Override
    public String getAttribute(String attributeName) {
        System.out.print("Element Clicked");
        return Element.getAttribute(attributeName);
    }
}
