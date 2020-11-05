package pages.v2.singlefilepageobjectbasepage;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;

public abstract class BaseEShopPage {
    protected final Driver driver;

    public BaseEShopPage(Driver driver) {
        this.driver = driver;
    }

    // search
    private Element searchField() {
        return driver.findElement(By.id("woocommerce-product-search-field-0"));
    }

    // menu links
    private Element homeLink() {
        return driver.findElement(By.linkText("Home"));
    }

    private Element blogLink() {
        return driver.findElement(By.linkText("Blog"));
    }

    private Element cartLink() {
        return driver.findElement(By.linkText("Cart"));
    }

    private Element checkoutLink() {
        return driver.findElement(By.linkText("Checkout"));
    }

    private Element myAccountLink() {
        return driver.findElement(By.linkText("My Account"));
    }

    private Element promotionsLink() {
        return driver.findElement(By.linkText("Promotions"));
    }

    // cart info
    private Element cartIcon() {
        return driver.findElement(By.className("cart-contents"));
    }

    private Element cartAmount() {
        return driver.findElement(By.className("amount"));
    }

    // breadcrumb
    private Element breadcrumb() {
        return driver.findElement(By.className("woocommerce-breadcrumb"));
    }

    protected abstract String getUrl();

    public void open()
    {
        driver.goToUrl(getUrl());
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
