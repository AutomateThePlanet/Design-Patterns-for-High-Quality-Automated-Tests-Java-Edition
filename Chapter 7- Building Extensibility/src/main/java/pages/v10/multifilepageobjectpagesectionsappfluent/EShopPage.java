package pages.v10.multifilepageobjectpagesectionsappfluent;

import core.LoggingSingletonDriver;
import core.interfaces.ElementFindService;
import pages.v10.multifilepageobjectpagesectionsappfluent.Sections.CartInfoSection;
import pages.v10.multifilepageobjectpagesectionsappfluent.Sections.MainMenuSection;
import pages.v10.multifilepageobjectpagesectionsappfluent.Sections.SearchSection;

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
