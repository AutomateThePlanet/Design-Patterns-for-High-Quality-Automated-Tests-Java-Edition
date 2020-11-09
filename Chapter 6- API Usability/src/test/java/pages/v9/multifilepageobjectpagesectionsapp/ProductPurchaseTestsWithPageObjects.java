package pages.v9.multifilepageobjectpagesectionsapp;

import core.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.v9.multifilepageobjectpagesectionsapp.MainPage.MainPage;

public class ProductPurchaseTestsWithPageObjects {
    private static App _app;

    @BeforeMethod
    public void testInit() {
        _app = new App(Browser.Chrome);
    }

    @AfterMethod
    public void testCleanup() throws Exception {
        _app.close();
    }

    @Test
    public void falcon9LinkAddsCorrectProduct() {
        var mainPage = _app.goTo(MainPage.class);

        mainPage.assertions().assertProductBoxLink("Falcon 9", "http://demos.bellatrix.solutions/product/falcon-9/");
    }

    @Test
    public void saturnVLinkAddsCorrectProduct() {
        var mainPage = _app.goTo(MainPage.class);

        _app.create(MainPage.class).assertions().assertProductBoxLink("Saturn V", "http://demos.bellatrix.solutions/product/saturn-v/");
    }
}