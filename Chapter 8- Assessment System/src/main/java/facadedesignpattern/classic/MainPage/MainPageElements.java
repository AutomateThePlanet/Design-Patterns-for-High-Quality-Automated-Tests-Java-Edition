package facadedesignpattern.classic.MainPage;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;

public class MainPageElements {
    private final Driver _driver;

    public MainPageElements(Driver driver)
    {
        _driver = driver;
    }

    public Element addToCartFalcon9() {
        return _driver.findElement(By.cssSelector("[data-product_id*='28']"));
    }

    public Element viewCartButton() {
        return _driver.findElement(By.cssSelector("[class*='added_to_cart wc-forward']"));
    }

    public Element getAddToCartByName(String name)
    {
        return _driver.findElement(By.xpath(String.format("//h2[text()='%s']/parent::a[1]", name)));
    }

    public Element getProductBoxByName(String name)
    {
        return _driver.findElement(By.xpath(String.format("//h2[text()='%s']/parent::a[1]/following-sibling::a[1]", name)));
    }
}
