package pages.v10.multifilepageobjectpagesectionsappfluent.Sections;

import core.Element;
import core.interfaces.ElementFindService;
import org.openqa.selenium.By;

public class MainMenuSection {
    private final ElementFindService _elementFindService;

    public MainMenuSection(ElementFindService elementFindService) {
        _elementFindService = elementFindService;
    }

    private Element homeLink() {
        return _elementFindService.findByLinkText("Home");
    }

    private Element blogLink() {
        return _elementFindService.findByLinkText("Blog");
    }

    private Element cartLink() {
        return _elementFindService.findByLinkText("Cart");
    }

    private Element checkoutLink() {
        return _elementFindService.findByLinkText("Checkout");
    }

    private Element myAccountLink() {
        return _elementFindService.findByLinkText("My Account");
    }

    private Element promotionsLink() {
        return _elementFindService.findByLinkText("Promotions");
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
