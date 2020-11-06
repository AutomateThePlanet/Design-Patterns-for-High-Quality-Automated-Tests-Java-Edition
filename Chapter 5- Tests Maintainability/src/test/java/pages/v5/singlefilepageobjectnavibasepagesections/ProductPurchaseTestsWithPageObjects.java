package pages.v5.singlefilepageobjectnavibasepagesections;

import core.Browser;
import core.Driver;
import core.LoggingDriver;
import core.WebCoreDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPurchaseTestsWithPageObjects {
    private Driver _driver;
    private static MainPage _mainPage;
    private static CartPage _cartPage;

    @BeforeMethod
    public void testInit() {
        _driver = new LoggingDriver(new WebCoreDriver());
        _driver.start(Browser.Chrome);
        _mainPage = new MainPage(_driver);
        _cartPage = new CartPage(_driver);

        _mainPage.open();
    }

    @AfterMethod
    public void testCleanup() throws InterruptedException {
        _driver.quit();
    }

    @Test
    public void openBlogPage() {
        _mainPage.mainMenuSection().openBlogPage();
        // verify page title
    }

    @Test
    public void searchForItem() throws InterruptedException {
        _mainPage.searchSection().searchForItem("Falcon 9");
        // add the item to cart
    }

    @Test
    public void openCart() {
        _mainPage.cartInfoSection().openCart();
        // verify items in the cart
    }
}