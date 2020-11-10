package facades;

import core.Driver;
import facades.Sections.CartInfoSection;
import facades.Sections.MainMenuSection;
import facades.Sections.SearchSection;

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
