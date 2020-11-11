package multifilepageobjectpagesectionsappfluent;

import configuration.AppInitializer;
import configuration.Props;
import core.Browser;
import multifilepageobjectpagesectionsappfluent.CartPage.CartPage;
import multifilepageobjectpagesectionsappfluent.MainPage.MainPage;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SpringBootTest(classes = TestNGWithSpringApplication.class)
public class ProductPurchaseTestsWithPageObjects extends AbstractTestNGSpringContextTests {
    private App _app;

    @BeforeMethod
    public void testInit() {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppInitializer.class);
        var props = appContext.getBean(Props.class);
        _app = appContext.getBean(App.class);
        _app.start(Browser.Chrome);
    }

    @AfterMethod
    public void testCleanup() throws Exception {
        _app.close();
    }

    @Test
    public void testConfig() {
        var appap = _app;
//        var appPropsUserName = _app.getProps().getPassword();
//        System.out.print(appPropsUserName);
    }

    @Test
    public void completePurchaseSuccessfully_WhenNewClient() throws InterruptedException {
        var mainPage = _app.goTo(MainPage.class);

        mainPage.addRocketToShoppingCart();
        var cartPage = _app.goTo(CartPage.class);
        cartPage.applyCoupon("happybirthday")
                .assertCouponAppliedSuccessfully()
                .increaseProductQuantity(2)
                .assertTotalPrice("114.00€")
                .clickProceedToCheckout();

    }
}