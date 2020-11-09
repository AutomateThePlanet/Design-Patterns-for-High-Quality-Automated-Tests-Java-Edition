package pages.v8.multifilepageobjectsectionssingleton;

import core.ElementFindService;
import core.NavigationService;

public abstract class NavigatableEShopPage extends EShopPage {
    protected final NavigationService navigationService;

    public NavigatableEShopPage(ElementFindService elementFindService, NavigationService navigationService) {
        super(elementFindService);
        this.navigationService = navigationService;
    }

    protected abstract String getUrl();

    public void open()
    {
        navigationService.goToUrl(getUrl());
    }
}
