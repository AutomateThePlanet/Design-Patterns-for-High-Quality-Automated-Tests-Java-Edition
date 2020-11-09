package pages.v8.multifilepageobjectsectionssingleton;

import core.ElementFindService;
import pages.v8.multifilepageobjectsectionssingleton.Sections.CartInfoSection;
import pages.v8.multifilepageobjectsectionssingleton.Sections.MainMenuSection;
import pages.v8.multifilepageobjectsectionssingleton.Sections.SearchSection;

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
