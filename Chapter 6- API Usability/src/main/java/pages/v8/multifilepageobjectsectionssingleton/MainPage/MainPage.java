package pages.v8.multifilepageobjectsectionssingleton.MainPage;

import core.ElementFindService;
import core.NavigationService;
import pages.v8.multifilepageobjectsectionssingleton.LoggingSingletonDriver;
import pages.v8.multifilepageobjectsectionssingleton.NavigatableEShopPage;

public class MainPage extends NavigatableEShopPage {
    private static MainPage _instance;
    private MainPage(ElementFindService elementFindService, NavigationService navigationService) {
        super(elementFindService, navigationService);
    }

    public static MainPage getInstance()
    {
        if (_instance == null)
        {
            _instance = new MainPage(LoggingSingletonDriver.getInstance(), LoggingSingletonDriver.getInstance());
        }

        return _instance;
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
