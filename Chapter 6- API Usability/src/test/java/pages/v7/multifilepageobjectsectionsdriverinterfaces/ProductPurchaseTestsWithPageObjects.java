package pages.v7.multifilepageobjectsectionsdriverinterfaces;

import core.Browser;
import core.Driver;
import core.LoggingDriver;
import core.WebCoreDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.v7.multifilepageobjectsectionsdriverinterfaces.CartPage.CartPage;
import pages.v7.multifilepageobjectsectionsdriverinterfaces.MainPage.MainPage;

public class ProductPurchaseTestsWithPageObjects {
    private Driver _driver;
    private static MainPage _mainPage;
    private static CartPage _cartPage;

    @BeforeMethod
    public void testInit() {
        _driver = new LoggingDriver(new WebCoreDriver());
        _driver.start(Browser.Chrome);
        _mainPage = new MainPage(_driver, _driver);
        _cartPage = new CartPage(_driver, _driver, _driver);

        _mainPage.open();
    }

    @AfterMethod
    public void testCleanup() throws InterruptedException {
        _driver.quit();
    }

    @Test
    public void falcon9LinkAddsCorrectProduct() {
        _mainPage.open();

        _mainPage.assertions().assertProductBoxLink("Falcon 9", "http://demos.bellatrix.solutions/product/falcon-9/");
    }

    @Test
    public void saturnVLinkAddsCorrectProduct() {
        _mainPage.open();

        _mainPage.assertions().assertProductBoxLink("Saturn V", "http://demos.bellatrix.solutions/product/saturn-v/");
    }
}