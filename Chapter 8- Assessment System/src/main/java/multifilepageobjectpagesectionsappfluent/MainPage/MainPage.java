package multifilepageobjectpagesectionsappfluent.MainPage;

import org.testng.Assert;
import pages.v10.multifilepageobjectpagesectionsappfluent.NavigatableEShopPage;

public class MainPage extends NavigatableEShopPage {

    @Override
    protected String getUrl() {
        return "http://demos.bellatrix.solutions/";
    }

    public MainPage addRocketToShoppingCart()
    {
        open();
        elements().addToCartFalcon9().click();
        elements().viewCartButton().click();
        return this;
    }

    public MainPage assertProductBoxLink(String name, String expectedLink)
    {
        var actualLink = elements().getProductBoxByName(name).getAttribute("href");
        Assert.assertEquals(actualLink, expectedLink);
        return this;
    }

    private MainPageElements elements() {
        return new MainPageElements(elementFindService);
    }
}
