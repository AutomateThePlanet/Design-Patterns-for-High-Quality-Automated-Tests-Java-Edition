package pages.v0.singlefilepageobject;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;

public class MainPage {
    private final Driver _driver;
    private final String _url = "http://demos.bellatrix.solutions/";

    public MainPage(Driver driver)
    {
        _driver = driver;
    }

    private Element addToCartFalcon9() {
        return _driver.findElement(By.cssSelector("[data-product_id*='28']"));
    }

    private Element viewCartButton() {
        return _driver.findElement(By.cssSelector("[class*='added_to_cart wc-forward']"));
    }

    public void AddRocketToShoppingCart()
    {
        _driver.goToUrl(_url);
        addToCartFalcon9().click();
        viewCartButton().click();
    }
}
