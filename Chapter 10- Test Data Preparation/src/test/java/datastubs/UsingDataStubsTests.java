package datastubs;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UsingDataStubsTests {
    private WebDriver _driver;
    private BrowserMobProxyServer _proxyServer;

    @BeforeMethod
    public void testInit() {
        WebDriverManager.chromedriver().setup();
        _proxyServer = new BrowserMobProxyServer();
        _proxyServer.start();

        _proxyServer.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        _proxyServer.newHar();
        String proxyDetails = "127.0.0.1:" + _proxyServer.getPort();
        final Proxy proxyConfig = new Proxy().
                setHttpProxy(proxyDetails).
                setSslProxy(proxyDetails);

        final ChromeOptions options = new ChromeOptions();
        options.setProxy(proxyConfig);
        options.setAcceptInsecureCerts(true);
        _driver = new ChromeDriver(options);
        _driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void testCleanup() throws InterruptedException {
        _driver.quit();
        _proxyServer.abort();
    }

    @Test
    public void requestRedirected_when_usingProxyRedirect() {
        _proxyServer.rewriteUrl("https://secure.gravatar.com/js/gprofiles.js?ver=2019Junaa", "https://stub.gravatar.com/js/gprofiles.js?ver=2019Junaa");

        _driver.navigate().to("http://demos.bellatrix.solutions/");
    }
}