package pages.v7.multifilepageobjectsectionsdriverinterfaces.Sections;

import core.Element;
import core.ElementFindService;
import org.openqa.selenium.By;

public class MainMenuSection {
    private final ElementFindService _elementFindService;

    public MainMenuSection(ElementFindService elementFindService) {
        _elementFindService = elementFindService;
    }

    private Element homeLink() {
        return _elementFindService.findElement(By.linkText("Home"));
    }

    private Element blogLink() {
        return _elementFindService.findElement(By.linkText("Blog"));
    }

    private Element cartLink() {
        return _elementFindService.findElement(By.linkText("Cart"));
    }

    private Element checkoutLink() {
        return _elementFindService.findElement(By.linkText("Checkout"));
    }

    private Element myAccountLink() {
        return _elementFindService.findElement(By.linkText("My Account"));
    }

    private Element promotionsLink() {
        return _elementFindService.findElement(By.linkText("Promotions"));
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
