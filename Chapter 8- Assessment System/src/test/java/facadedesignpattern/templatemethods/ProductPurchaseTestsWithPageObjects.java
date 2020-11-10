package facadedesignpattern.templatemethods;

import core.Browser;
import core.Driver;
import core.LoggingDriver;
import core.WebCoreDriver;
import facadedesignpattern.templatemethods.CartPage.CartPage;
import facadedesignpattern.templatemethods.CheckoutPage.CheckoutPage;
import facadedesignpattern.templatemethods.MainPage.MainPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPurchaseTestsWithPageObjects {
    private Driver _driver;
    private static MainPage _mainPage;
    private static CartPage _cartPage;
    private static CheckoutPage _checkoutPage;
    private static NewPurchaseFacade _purchaseFacade;

    @BeforeMethod
    public void testInit() {
        _driver = new LoggingDriver(new WebCoreDriver());
        _driver.start(Browser.Chrome);
        _mainPage = new MainPage(_driver);
        _cartPage = new CartPage(_driver);
        _checkoutPage = new CheckoutPage(_driver);
        _purchaseFacade = new NewPurchaseFacade(_mainPage, _cartPage, _checkoutPage);
    }

    @AfterMethod
    public void testCleanup() throws InterruptedException {
        _driver.quit();
    }

    @Test
    public void purchaseFalcon9WithoutFacade() throws InterruptedException {
        _mainPage.open();
        _mainPage.addRocketToShoppingCart("Falcon 9");
        _cartPage.applyCoupon("happybirthday");
        _cartPage.assertions().assertCouponAppliedSuccessfully();
        _cartPage.increaseProductQuantity(2);
        _cartPage.assertions().assertTotalPrice("114.00€");
        _cartPage.clickProceedToCheckout();

        var purchaseInfo = new PurchaseInfo();
        purchaseInfo.setEmail("info@berlinspaceflowers.com");
        purchaseInfo.setFirstName("Anton");
        purchaseInfo.setLastName("Angelov");
        purchaseInfo.setCompany("Space Flowers");
        purchaseInfo.setCountry("Germany");
        purchaseInfo.setAddress1("1 Willi Brandt Avenue Tiergarten");
        purchaseInfo.setAddress2("Lьtzowplatz 17");
        purchaseInfo.setCity("Berlin");
        purchaseInfo.setZip("10115");
        purchaseInfo.setPhone("+00498888999281");

        _checkoutPage.fillBillingInfo(purchaseInfo);
        _checkoutPage.assertions().assertOrderReceived();
    }

    @Test
    public void purchaseSaturnVWithoutFacade() throws InterruptedException {
        _mainPage.open();
        _mainPage.addRocketToShoppingCart("Saturn V");
        _cartPage.applyCoupon("happybirthday");
        _cartPage.assertions().assertCouponAppliedSuccessfully();
        _cartPage.increaseProductQuantity(3);
        _cartPage.assertions().assertTotalPrice("355.00€");
        _cartPage.clickProceedToCheckout();

        var purchaseInfo = new PurchaseInfo();
        purchaseInfo.setEmail("info@berlinspaceflowers.com");
        purchaseInfo.setFirstName("Anton");
        purchaseInfo.setLastName("Angelov");
        purchaseInfo.setCompany("Space Flowers");
        purchaseInfo.setCountry("Germany");
        purchaseInfo.setAddress1("1 Willi Brandt Avenue Tiergarten");
        purchaseInfo.setAddress2("Lьtzowplatz 17");
        purchaseInfo.setCity("Berlin");
        purchaseInfo.setZip("10115");
        purchaseInfo.setPhone("+00498888999281");

        _checkoutPage.fillBillingInfo(purchaseInfo);
        _checkoutPage.assertions().assertOrderReceived();
    }

    @Test
    public void purchaseFalcon9WithFacade() throws InterruptedException {
        var purchaseInfo = new PurchaseInfo();
        purchaseInfo.setEmail("info@berlinspaceflowers.com");
        purchaseInfo.setFirstName("Anton");
        purchaseInfo.setLastName("Angelov");
        purchaseInfo.setCompany("Space Flowers");
        purchaseInfo.setCountry("Germany");
        purchaseInfo.setAddress1("1 Willi Brandt Avenue Tiergarten");
        purchaseInfo.setAddress2("Lьtzowplatz 17");
        purchaseInfo.setCity("Berlin");
        purchaseInfo.setZip("10115");
        purchaseInfo.setPhone("+00498888999281");

        _purchaseFacade.purchaseItem("Falcon 9", "happybirthday", 2, "114.00€", purchaseInfo);
    }

    @Test
    public void purchaseSaturnVWithFacade() throws InterruptedException {
        var purchaseInfo = new PurchaseInfo();
        purchaseInfo.setEmail("info@berlinspaceflowers.com");
        purchaseInfo.setFirstName("Anton");
        purchaseInfo.setLastName("Angelov");
        purchaseInfo.setCompany("Space Flowers");
        purchaseInfo.setCountry("Germany");
        purchaseInfo.setAddress1("1 Willi Brandt Avenue Tiergarten");
        purchaseInfo.setAddress2("Lьtzowplatz 17");
        purchaseInfo.setCity("Berlin");
        purchaseInfo.setZip("10115");
        purchaseInfo.setPhone("+00498888999281");

        _purchaseFacade.purchaseItem("Saturn V", "happybirthday", 3, "355.00€", purchaseInfo);
    }
}