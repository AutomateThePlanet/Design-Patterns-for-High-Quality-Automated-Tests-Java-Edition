package pages.v1.singlefilepageobjectnondry;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;

public class MainPage {
    private final Driver _driver;
    private final String _url = "http://demos.bellatrix.solutions/";

    public MainPage(Driver driver)
    {
        _driver = driver;
    }

    private Element addToCartFalcon9() {
        return _driver.findElement(By.cssSelector("[data-product_id*='28']"));
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

    private Element viewCartButton() {
        return _driver.findElement(By.cssSelector("[class*='added_to_cart wc-forward']"));
    }

    public void addRocketToShoppingCart()
    {
        _driver.goToUrl(_url);
        addToCartFalcon9().click();
        viewCartButton().click();
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
}
