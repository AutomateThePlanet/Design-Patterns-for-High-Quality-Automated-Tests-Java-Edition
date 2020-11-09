package pages.v9.multifilepageobjectpagesectionsapp.MainPage;

import pages.v9.multifilepageobjectpagesectionsapp.NavigatableEShopPage;
import pages.v9.multifilepageobjectpagesectionsapp.SingletonFactory;

public class MainPage extends NavigatableEShopPage {
    private static MainPage _instance;

    public static MainPage getInstance()
    {
        if (_instance == null)
        {
            _instance = new MainPage();
        }

        return _instance;
    }

    public static MainPage getInstanceFactory() {
        MainPage mainPage = null;
        try
        {
            return SingletonFactory.getInstance(MainPage.class);
        }
        catch (Exception e)
        {
            // not the best practice to return null. But probably we will never end here so it is OK.
            return mainPage;
        }
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
