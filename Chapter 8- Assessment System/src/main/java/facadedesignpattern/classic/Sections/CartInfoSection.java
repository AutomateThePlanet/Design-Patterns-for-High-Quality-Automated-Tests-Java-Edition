package facadedesignpattern.classic.Sections;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;

public class CartInfoSection {
    private final Driver _driver;

    public CartInfoSection(Driver driver) {
        _driver = driver;
    }

    private Element cartIcon() {
        return _driver.findElement(By.className("cart-contents"));
    }

    private Element cartAmount() {
        return _driver.findElement(By.className("amount"));
    }

    public String getCurrentAmount()
    {
        return cartAmount().getText();
    }

    public void openCart()
    {
        cartIcon().click();
    }
}
