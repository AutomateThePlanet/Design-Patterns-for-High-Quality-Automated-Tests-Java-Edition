package multifilepageobjectpagesectionsappfluent;

import core.ElementFindService;
import multifilepageobjectpagesectionsappfluent.Sections.CartInfoSection;
import multifilepageobjectpagesectionsappfluent.Sections.MainMenuSection;
import multifilepageobjectpagesectionsappfluent.Sections.SearchSection;

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
