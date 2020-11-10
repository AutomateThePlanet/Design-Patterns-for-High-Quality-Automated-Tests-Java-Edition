package facadedesignpattern.classic.CartPage;

import org.testng.Assert;

public class CartPageAssertions {
    private final CartPageElements _elements;

    public CartPageAssertions(CartPageElements elements) {
        _elements = elements;
    }

    public void assertCouponAppliedSuccessfully()
    {
        Assert.assertEquals(_elements.messageAlert().getText(), "Coupon code applied successfully.");
    }

    public void assertTotalPrice(String expectedPrice)
    {
        Assert.assertEquals(_elements.totalSpan().getText(), expectedPrice);
    }
}
