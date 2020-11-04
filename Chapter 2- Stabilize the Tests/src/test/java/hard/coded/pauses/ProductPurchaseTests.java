package hard.coded.pauses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ProductPurchaseTests {
    private WebDriver driver;
    private static String _purchaseEmail;
    private static String _purchaseOrderNumber;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void completePurchaseSuccessfully_whenNewClient() {
        driver.navigate().to("https://automatetheplanet.com");
    }
}
