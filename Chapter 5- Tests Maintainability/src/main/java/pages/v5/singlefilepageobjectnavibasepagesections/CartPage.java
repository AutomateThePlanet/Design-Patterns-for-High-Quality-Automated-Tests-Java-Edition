package pages.v5.singlefilepageobjectnavibasepagesections;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;
import pages.v3.singlefilepageobjectssections.BreadcrumbSection;

public class CartPage extends NavigatableEShopPage {
    public CartPage(Driver driver) {
        super(driver);
    }

    @Override
    protected String getUrl() {
        return "http://demos.bellatrix.solutions/cart/";
    }

    private Element couponCodeTextField() {
        return driver.findElement(By.id("coupon_code"));
    }

    private Element applyCouponButton() {
        return driver.findElement(By.cssSelector("[value*='Apply coupon']"));
    }

    private Element quantityBox() {
        return driver.findElement(By.cssSelector("[class*='input-text qty text']"));
    }

    private Element updateCart() {
        return driver.findElement(By.cssSelector("[value*='Update cart']"));
    }

    private Element messageAlert() {
        return driver.findElement(By.cssSelector("[class*='woocommerce-message']"));
    }

    private Element totalSpan() {
        return driver.findElement(By.xpath("//*[@class='order-total']//span"));
    }

    private Element proceedToCheckout() {
        return driver.findElement(By.cssSelector("[class*='checkout-button button alt wc-forward']"));
    }

    public BreadcrumbSection breadcrumbSection() {
        return new BreadcrumbSection(driver);
    }

    public void applyCoupon(String coupon) throws InterruptedException {
        couponCodeTextField().typeText(coupon);
        applyCouponButton().click();
        driver.waitForAjax();
    }

    public void increaseProductQuantity(int newQuantity) throws InterruptedException {
        quantityBox().typeText(String.valueOf(newQuantity));
        updateCart().click();
        driver.waitForAjax();
    }

    public void clickProceedToCheckout()
    {
        proceedToCheckout().click();
        driver.waitUntilPageLoadsCompletely();
    }

    public String getTotal()
    {
        return totalSpan().getText();
    }

    public String getMessageNotification()
    {
        return messageAlert().getText();
    }
}
