/*
 * Copyright 2021 Automate The Planet Ltd.
 * Author: Anton Angelov
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package blackholeproxypattern;

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

public class CaptureHttpTrafficTests {
    private WebDriver driver;
    private BrowserMobProxyServer proxyServer;

    @BeforeMethod
    public void testInit() {
        WebDriverManager.chromedriver().setup();
        proxyServer = new BrowserMobProxyServer();
        proxyServer.start();

        proxyServer.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        proxyServer.newHar();
        String proxyDetails = "127.0.0.1:" + proxyServer.getPort();
        final Proxy proxyConfig = new Proxy().
                setHttpProxy(proxyDetails).
                setSslProxy(proxyDetails);

        final ChromeOptions options = new ChromeOptions();
        options.setProxy(proxyConfig);
        options.setAcceptInsecureCerts(true);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        proxyServer.blacklistRequests("(http(s?):)([/|.|\\w|\\s|-])*\\.(?:jpg|gif|png)", 400);
    }

    @AfterMethod
    public void testCleanup() throws InterruptedException {
        driver.quit();
        proxyServer.abort();
    }

    @Test
    public void completePurchaseSuccessfully_whenNewClient() {
        driver.navigate().to("http://demos.bellatrix.solutions/");
    }
}