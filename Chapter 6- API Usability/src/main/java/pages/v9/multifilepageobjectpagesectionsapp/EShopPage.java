package pages.v9.multifilepageobjectpagesectionsapp;

import core.ElementFindService;
import pages.v9.multifilepageobjectpagesectionsapp.Sections.CartInfoSection;
import pages.v9.multifilepageobjectpagesectionsapp.Sections.MainMenuSection;
import pages.v9.multifilepageobjectpagesectionsapp.Sections.SearchSection;

public abstract class EShopPage {
    protected final ElementFindService elementFindService;

    public EShopPage() {
        this.elementFindService = LoggingSingletonDriver.getInstance();
    }

    public MainMenuSection mainMenuSection() {
        return new MainMenuSection(elementFindService);
    }

    public CartInfoSection cartInfoSection() {
        return new CartInfoSection(elementFindService);
    }

    public SearchSection searchSection() {
        return new SearchSection(elementFindService);
    }
}
