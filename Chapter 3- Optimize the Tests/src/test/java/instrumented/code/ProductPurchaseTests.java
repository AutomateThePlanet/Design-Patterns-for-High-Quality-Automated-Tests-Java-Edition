package instrumented.code;

import com.google.common.base.Stopwatch;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/*
 * The order of test execution is important. The tests should be executed in the following order:
 * completePurchaseSuccessfully_whenNewClient
 * completePurchaseSuccessfully_whenExistingClient
 * correctOrderDataDisplayed_WhenNavigateToMyAccountOrderSection
 *
 * The tests may fail because the hard-coded pauses were not enough.
 * This is the expected behavior showing that this is not the best practice.
 */
public class ProductPurchaseTests {
    private Driver _driver;
    private static String _purchaseEmail = "info@berlinspaceflowers.com";
    private static String _purchaseOrderNumber;
    private static Stopwatch _stopWatch;

    @BeforeClass
    public void beforeClass() {
        _stopWatch = Stopwatch.createStarted();
        System.setProperty("webdriver.chrome.driver", "..\\src\\main\\resources\\chromedriver.exe");
        _driver = new LoggingDriver(new WebCoreDriver());
        _driver.start(Browser.Chrome);

        System.out.print(String.format("end browser init: %d", _stopWatch.elapsed(TimeUnit.SECONDS)));
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        _driver.quit();
        System.out.print(String.format("afterClass: %d", _stopWatch.elapsed(TimeUnit.SECONDS)));
        _stopWatch.stop();
    }

    @Test
    public void completePurchaseSuccessfully_whenNewClient() throws InterruptedException {
        System.out.print(String.format("start completePurchaseSuccessfully_whenNewClient: %d", _stopWatch.elapsed(TimeUnit.SECONDS)));
        _driver.goToUrl("http://demos.bellatrix.solutions/");
        var addToCartFalcon9 = _driver.findElement(By.cssSelector("[data-product_id*='28']"));
        addToCartFalcon9.click();
        var viewCartButton = _driver.findElement(By.cssSelector("[class*='added_to_cart wc-forward']"));
        viewCartButton.click();

        var couponCodeTextField = _driver.findElement(By.id("coupon_code"));
        couponCodeTextField.typeText("happybirthday");
        var applyCouponButton = _driver.findElement(By.cssSelector("[value*='Apply coupon']"));
        applyCouponButton.click();
        Thread.sleep(4000);
        var messageAlert = _driver.findElement(By.cssSelector("[class*='woocommerce-message']"));
        Assert.assertEquals(messageAlert.getText(), "Coupon code applied successfully.");

        var quantityBox = _driver.findElement(By.cssSelector("[class*='input-text qty text']"));
        quantityBox.typeText("2");

        var updateCart = _driver.findElement(By.cssSelector("[value*='Update cart']"));
        updateCart.click();
        Thread.sleep(4000);
        var totalSpan = _driver.findElement(By.xpath("//*[@class='order-total']//span"));
        Assert.assertEquals("114.00€", totalSpan.getText());

        var proceedToCheckout = _driver.findElement(By.cssSelector("[class*='checkout-button button alt wc-forward']"));
        proceedToCheckout.click();

        var billingFirstName = _driver.findElement(By.id("billing_first_name"));
        billingFirstName.typeText("Anton");
        var billingLastName = _driver.findElement(By.id("billing_last_name"));
        billingLastName.typeText("Angelov");
        var billingCompany = _driver.findElement(By.id("billing_company"));
        billingCompany.typeText("Space Flowers");
        var billingCountryWrapper = _driver.findElement(By.id("select2-billing_country-container"));
        billingCountryWrapper.click();
        var billingCountryFilter = _driver.findElement(By.className("select2-search__field"));
        billingCountryFilter.typeText("Germany");
        var germanyOption = _driver.findElement(By.xpath("//*[contains(text(),'Germany')]"));
        germanyOption.click();
        var billingAddress1 = _driver.findElement(By.id("billing_address_1"));
        billingAddress1.typeText("1 Willi Brandt Avenue Tiergarten");
        var billingAddress2 = _driver.findElement(By.id("billing_address_2"));
        billingAddress2.typeText("Lьtzowplatz 17");
        var billingCity = _driver.findElement(By.id("billing_city"));
        billingCity.typeText("Berlin");
        var billingZip = _driver.findElement(By.id("billing_postcode"));
        billingZip.typeText("10115");
        var billingPhone = _driver.findElement(By.id("billing_phone"));
        billingPhone.typeText("+00498888999281");
        var billingEmail = _driver.findElement(By.id("billing_email"));
        billingEmail.typeText("info@berlinspaceflowers.com");
        _purchaseEmail = "info@berlinspaceflowers.com";

        // This pause will be removed when we introduce a logic for waiting for AJAX requests.
        Thread.sleep(5000);
        var placeOrderButton = _driver.findElement(By.id("place_order"));
        placeOrderButton.click();

        Thread.sleep(10000);
        var receivedMessage = _driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/div/header/h1"));
        Assert.assertEquals(receivedMessage.getText(), "Order received");

        System.out.print(String.format("end completePurchaseSuccessfully_whenNewClient: %d", _stopWatch.elapsed(TimeUnit.SECONDS)));
    }
    
    @Test
    public void completePurchaseSuccessfully_whenExistingClient() throws InterruptedException {
        System.out.print(String.format("start completePurchaseSuccessfully_whenExistingClient: %d", _stopWatch.elapsed(TimeUnit.SECONDS)));

        _driver.goToUrl("http://demos.bellatrix.solutions/");

        var addToCartFalcon9 = _driver.findElement(By.cssSelector("[data-product_id*='28']"));
        addToCartFalcon9.click();
        var viewCartButton = _driver.findElement(By.cssSelector("[class*='added_to_cart wc-forward']"));
        viewCartButton.click();

        var couponCodeTextField = _driver.findElement(By.id("coupon_code"));
        couponCodeTextField.typeText("happybirthday");
        var applyCouponButton = _driver.findElement(By.cssSelector("[value*='Apply coupon']"));
        applyCouponButton.click();
        var messageAlert = _driver.findElement(By.cssSelector("[class*='woocommerce-message']"));
        Thread.sleep(4000);
        Assert.assertEquals(messageAlert.getText(), "Coupon code applied successfully.");

        var quantityBox = _driver.findElement(By.cssSelector("[class*='input-text qty text']"));
        quantityBox.typeText("2");
        var updateCart = _driver.findElement(By.cssSelector("[value*='Update cart']"));
        updateCart.click();
        Thread.sleep(4000);
        var totalSpan = _driver.findElement(By.xpath("//*[@class='order-total']//span"));
        Assert.assertEquals(totalSpan.getText(), "114.00€");

        var proceedToCheckout = _driver.findElement(By.cssSelector("[class*='checkout-button button alt wc-forward']"));
        proceedToCheckout.click();

        var loginHereLink = _driver.findElement(By.linkText("Click here to login"));
        loginHereLink.click();
        var userName = _driver.findElement(By.id("username"));
        Thread.sleep(5000);
        userName.typeText(_purchaseEmail);
        var password = _driver.findElement(By.id("password"));
        password.typeText(GetUserPasswordFromDb(_purchaseEmail));
        var loginButton = _driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        // This pause will be removed when we introduce a logic for waiting for AJAX requests.
        Thread.sleep(5000);
        var placeOrderButton = _driver.findElement(By.id("place_order"));
        placeOrderButton.click();

        var receivedMessage = _driver.findElement(By.xpath("//h1[text() = 'Order received']"));
        Assert.assertEquals(receivedMessage.getText(), "Order received");

        var orderNumber = _driver.findElement(By.xpath("//*[@id='post-7']/div/div/div/ul/li[1]/strong"));
        _purchaseOrderNumber = orderNumber.getText();

        System.out.print(String.format("end completePurchaseSuccessfully_whenExistingClient: %d", _stopWatch.elapsed(TimeUnit.SECONDS)));
    }

    @Test
    public void correctOrderDataDisplayed_whenNavigateToMyAccountOrderSection() throws InterruptedException {
        System.out.print(String.format("start correctOrderDataDisplayed_whenNavigateToMyAccountOrderSection: %d", _stopWatch.elapsed(TimeUnit.SECONDS)));
        _driver.goToUrl("http://demos.bellatrix.solutions/");

        var myAccountLink = _driver.findElement(By.linkText("My account"));
        myAccountLink.click();
        var userName = _driver.findElement(By.id("username"));
        Thread.sleep(4000);
        userName.typeText(_purchaseEmail);
        var password = _driver.findElement(By.id("password"));
        password.typeText(GetUserPasswordFromDb(GetUserPasswordFromDb(_purchaseEmail)));
        var loginButton = _driver.findElement(By.xpath("//button[@name='login']"));
        loginButton.click();

        var orders = _driver.findElement(By.linkText("Orders"));
        orders.click();

        var viewButtons = _driver.findElements(By.linkText("View"));
        viewButtons.get(0).click();

        var orderName = _driver.findElement(By.xpath("//h1"));
        String expectedMessage = String.format("Order #%s", _purchaseOrderNumber);
        Assert.assertEquals(expectedMessage, orderName.getText());

        System.out.print(String.format("end correctOrderDataDisplayed_whenNavigateToMyAccountOrderSection: %d", _stopWatch.elapsed(TimeUnit.SECONDS)));
    }

    private String GetUserPasswordFromDb(String userName)
    {
        return "@purISQzt%%DYBnLCIhaoG6$";
    }
}