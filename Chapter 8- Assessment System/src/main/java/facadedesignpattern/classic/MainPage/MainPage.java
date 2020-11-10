package facadedesignpattern.classic.MainPage;

import core.Driver;
import facadedesignpattern.classic.NavigatableEShopPage;

public class MainPage extends NavigatableEShopPage {

    public MainPage(Driver driver)
    {
        super(driver);
    }

    public MainPageElements elements() {
        return new MainPageElements(driver);
    }

    public MainPageAssertions assertions() {
        return new MainPageAssertions(elements());
    }

    @Override
    protected String getUrl() {
        return "http://demos.bellatrix.solutions/";
    }

    public void addRocketToShoppingCart(String rocketName)
    {
        open();
        elements().getProductBoxByName(rocketName).click();
//        driver.waitForAjax();
        elements().viewCartButton().click();
    }
}
