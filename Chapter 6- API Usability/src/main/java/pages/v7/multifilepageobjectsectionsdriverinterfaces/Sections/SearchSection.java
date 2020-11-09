package pages.v7.multifilepageobjectsectionsdriverinterfaces.Sections;

import core.Element;
import core.ElementFindService;
import org.openqa.selenium.By;

public class SearchSection {
    private final ElementFindService _elementFindService;

    public SearchSection(ElementFindService elementFindService) {
        _elementFindService = elementFindService;
    }

    private Element searchField() {
        return _elementFindService.findElement(By.id("woocommerce-product-search-field-0"));
    }

    public void searchForItem(String searchText) throws InterruptedException {
        searchField().typeText(searchText);
    }
}
