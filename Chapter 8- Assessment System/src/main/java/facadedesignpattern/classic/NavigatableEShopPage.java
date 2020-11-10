package facadedesignpattern.classic;

import core.Driver;

public abstract class NavigatableEShopPage extends EShopPage {
    public NavigatableEShopPage(Driver driver) {
        super(driver);
    }

    protected abstract String getUrl();

    public void open()
    {
        driver.goToUrl(getUrl());
    }
}
