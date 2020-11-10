package facadedesignpattern.templatemethods;

import core.Driver;
import facadedesignpattern.templatemethods.Sections.CartInfoSection;
import facadedesignpattern.templatemethods.Sections.MainMenuSection;
import facadedesignpattern.templatemethods.Sections.SearchSection;

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
