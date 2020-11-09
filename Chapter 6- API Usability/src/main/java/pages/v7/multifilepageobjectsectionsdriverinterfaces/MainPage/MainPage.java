package pages.v7.multifilepageobjectsectionsdriverinterfaces.MainPage;

import core.BrowserService;
import core.Driver;
import core.ElementFindService;
import core.NavigationService;
import pages.v7.multifilepageobjectsectionsdriverinterfaces.NavigatableEShopPage;

public class MainPage extends NavigatableEShopPage {
    public MainPage(ElementFindService elementFindService, NavigationService navigationService) {
        super(elementFindService, navigationService);
    }

    public MainPageElements elements() {
        return new MainPageElements(elementFindService);
    }

    public MainPageAssertions assertions() {
        return new MainPageAssertions(elements());
    }

    @Override
    protected String getUrl() {
        return "http://demos.bellatrix.solutions/";
    }

    public void addRocketToShoppingCart()
    {
        open();
        elements().addToCartFalcon9().click();
        elements().viewCartButton().click();
    }
}
