package pages.v5.singlefilepageobjectnavibasepagesections;

import core.Driver;
import core.Element;
import org.openqa.selenium.By;

public class MainMenuSection {
    private final Driver _driver;

    public MainMenuSection(Driver driver) {
        _driver = driver;
    }

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
}
