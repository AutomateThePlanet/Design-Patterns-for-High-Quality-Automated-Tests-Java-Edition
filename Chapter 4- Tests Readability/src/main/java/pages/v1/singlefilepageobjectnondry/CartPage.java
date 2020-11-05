package pages.v1.singlefilepageobjectnondry;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;

public class CartPage {
    private final Driver _driver;

    public CartPage(Driver driver) {
        _driver = driver;
    }

    private Element couponCodeTextField() {
        return _driver.findElement(By.id("coupon_code"));
    }

    private Element applyCouponButton() {
        return _driver.findElement(By.cssSelector("[value*='Apply coupon']"));
    }

    private Element quantityBox() {
        return _driver.findElement(By.cssSelector("[class*='input-text qty text']"));
    }

    private Element updateCart() {
        return _driver.findElement(By.cssSelector("[value*='Update cart']"));
    }

    private Element messageAlert() {
        return _driver.findElement(By.cssSelector("[class*='woocommerce-message']"));
    }

    private Element totalSpan() {
        return _driver.findElement(By.xpath("//*[@class='order-total']//span"));
    }

    private Element proceedToCheckout() {
        return _driver.findElement(By.cssSelector("[class*='checkout-button button alt wc-forward']"));
    }

    // search
    private Element searchField() {
        return _driver.findElement(By.id("woocommerce-product-search-field-0"));
    }

    // menu links
    private Element homeLink() {
        return _driver.findElement(By.linkText("Home"));
    }

    private Element blogLink() {
        return _driver.findElement(By.linkText("Blog"));
    }

    private Element cartLink() {
        return _driver.findElement(By.linkText("Cart"));
    }

    private Element checkoutLink() {
        return _driver.findElement(By.linkText("Checkout"));
    }

    private Element myAccountLink() {
        return _driver.findElement(By.linkText("My Account"));
    }

    private Element promotionsLink() {
        return _driver.findElement(By.linkText("Promotions"));
    }

    // cart info
    private Element cartIcon() {
        return _driver.findElement(By.className("cart-contents"));
    }

    private Element cartAmount() {
        return _driver.findElement(By.className("amount"));
    }

    // breadcrumb
    private Element breadcrumb() {
        return _driver.findElement(By.className("woocommerce-breadcrumb"));
    }

    public void applyCoupon(String coupon) throws InterruptedException {
        couponCodeTextField().typeText(coupon);
        applyCouponButton().click();
        _driver.waitForAjax();
    }

    public void increaseProductQuantity(int newQuantity) throws InterruptedException {
        quantityBox().typeText(String.valueOf(newQuantity));
        updateCart().click();
        _driver.waitForAjax();
    }

    public void clickProceedToCheckout()
    {
        proceedToCheckout().click();
        _driver.waitUntilPageLoadsCompletely();
    }

    public String getTotal()
    {
        return totalSpan().getText();
    }

    public String getMessageNotification()
    {
        return messageAlert().getText();
    }

    // sections methods
    public void searchForItem(String searchText) throws InterruptedException {
        searchField().typeText(searchText);
    }

    public void openHomePage()
    {
        homeLink().click();
    }

    public void openBlogPage()
    {
        blogLink().click();
    }

    public void openMyAccountPage()
    {
        myAccountLink().click();
    }

    public void openPromotionsPage()
    {
        promotionsLink().click();
    }

    public String getCurrentAmount()
    {
        return cartAmount().getText();
    }

    public void openCart()
    {
        cartIcon().click();
    }

    public void openBreadcrumbItem(String itemToOpen)
    {
        breadcrumb().findElement(By.linkText(itemToOpen)).click();
    }
}
