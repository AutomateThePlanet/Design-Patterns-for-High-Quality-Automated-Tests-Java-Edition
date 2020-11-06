package pages.v5.singlefilepageobjectnavibasepagesections;

import core.Driver;
import pages.v3.singlefilepageobjectssections.CartInfoSection;
import pages.v3.singlefilepageobjectssections.MainMenuSection;
import pages.v3.singlefilepageobjectssections.SearchSection;

public abstract class EShopPage {
    protected final Driver driver;

    public EShopPage(Driver driver) {
        this.driver = driver;
    }

    public MainMenuSection mainMenuSection() {
        return new MainMenuSection(driver);
    }

    public CartInfoSection cartInfoSection() {
        return new CartInfoSection(driver);
    }

    public SearchSection searchSection() {
        return new SearchSection(driver);
    }
}
