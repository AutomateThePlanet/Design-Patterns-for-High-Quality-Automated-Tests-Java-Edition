package facadedesignpattern.classic.CheckoutPage;

import org.testng.Assert;

public class CheckoutAssertions {
    private final CheckoutElements _elements;

    public CheckoutAssertions(CheckoutElements elements) {
        _elements = elements;
    }

    public void assertOrderReceived()
    {
        Assert.assertEquals(_elements.receivedMessage().getText(), "Order received");
    }
}
