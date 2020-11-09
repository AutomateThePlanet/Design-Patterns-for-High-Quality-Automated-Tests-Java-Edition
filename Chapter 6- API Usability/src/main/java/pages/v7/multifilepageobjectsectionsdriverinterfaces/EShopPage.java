package pages.v7.multifilepageobjectsectionsdriverinterfaces;

import core.ElementFindService;
import pages.v7.multifilepageobjectsectionsdriverinterfaces.Sections.CartInfoSection;
import pages.v7.multifilepageobjectsectionsdriverinterfaces.Sections.MainMenuSection;
import pages.v7.multifilepageobjectsectionsdriverinterfaces.Sections.SearchSection;

public abstract class EShopPage {
    protected final ElementFindService elementFindService;

    public EShopPage(ElementFindService elementFindService) {
        this.elementFindService = elementFindService;
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
