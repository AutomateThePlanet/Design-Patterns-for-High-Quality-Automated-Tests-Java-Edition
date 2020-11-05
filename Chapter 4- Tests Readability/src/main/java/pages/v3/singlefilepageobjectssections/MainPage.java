package pages.v3.singlefilepageobjectssections;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;
import pages.v3.singlefilepageobjectssections.sections.CartInfoSection;
import pages.v3.singlefilepageobjectssections.sections.MainMenuSection;
import pages.v3.singlefilepageobjectssections.sections.SearchSection;

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

    public MainMenuSection mainMenuSection() {
        return new MainMenuSection(_driver);
    }

    public CartInfoSection cartInfoSection() {
        return new CartInfoSection(_driver);
    }

    public SearchSection searchSection() {
        return new SearchSection(_driver);
    }

    public void addRocketToShoppingCart()
    {
        _driver.goToUrl(_url);
        addToCartFalcon9().click();
        viewCartButton().click();
    }
}
