package facadedesignpattern.templatemethods;

import core.Driver;

import java.io.IOException;
import java.net.URISyntaxException;

public abstract class NavigatableEShopPage extends EShopPage {
    public NavigatableEShopPage(Driver driver) {
        super(driver);
    }

    protected abstract String getUrl() throws IOException, URISyntaxException;

    public void open()
    {
        driver.goToUrl(getUrl());
    }
}
