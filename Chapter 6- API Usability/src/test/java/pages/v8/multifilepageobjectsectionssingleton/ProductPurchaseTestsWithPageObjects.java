package pages.v8.multifilepageobjectsectionssingleton;

import core.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.v8.multifilepageobjectsectionssingleton.MainPage.MainPage;

public class ProductPurchaseTestsWithPageObjects {

    @BeforeMethod
    public void testInit() {
        LoggingSingletonDriver.getInstance().start(Browser.Chrome);

        MainPage.getInstance().open();
    }

    @AfterMethod
    public void testCleanup() throws InterruptedException {
        LoggingSingletonDriver.getInstance().quit();
    }

    @Test
    public void falcon9LinkAddsCorrectProduct() {
        MainPage.getInstance().open();

        MainPage.getInstance().assertions().assertProductBoxLink("Falcon 9", "http://demos.bellatrix.solutions/product/falcon-9/");
    }

    @Test
    public void saturnVLinkAddsCorrectProduct() {
        MainPage.getInstance().open();

        MainPage.getInstance().assertions().assertProductBoxLink("Saturn V", "http://demos.bellatrix.solutions/product/saturn-v/");
    }
}