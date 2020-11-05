package pages.v2.singlefilepageobjectbasepage;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;

public class MainPage extends BaseEShopPage {

    public MainPage(Driver driver)
    {
        super(driver);
    }

    private Element addToCartFalcon9() {
        return driver.findElement(By.cssSelector("[data-product_id*='28']"));
    }

    private Element viewCartButton() {
        return driver.findElement(By.cssSelector("[class*='added_to_cart wc-forward']"));
    }

    @Override
    protected String getUrl() {
        return "http://demos.bellatrix.solutions/";
    }

    public void addRocketToShoppingCart()
    {
        open();
        addToCartFalcon9().click();
        viewCartButton().click();
    }
}
