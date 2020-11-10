package facadedesignpattern.classic;

import core.Driver;
import facadedesignpattern.classic.Sections.CartInfoSection;
import facadedesignpattern.classic.Sections.MainMenuSection;
import facadedesignpattern.classic.Sections.SearchSection;

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
