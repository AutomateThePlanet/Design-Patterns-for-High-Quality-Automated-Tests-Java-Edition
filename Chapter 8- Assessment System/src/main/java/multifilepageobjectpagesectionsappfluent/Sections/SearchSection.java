package multifilepageobjectpagesectionsappfluent.Sections;

import core.Element;
import core.interfaces.ElementFindService;

public class SearchSection {
    private final ElementFindService _elementFindService;

    public SearchSection(ElementFindService elementFindService) {
        _elementFindService = elementFindService;
    }

    private Element searchField() {
        return _elementFindService.findById("woocommerce-product-search-field-0");
    }

    public void searchForItem(String searchText) throws InterruptedException {
        searchField().typeText(searchText);
    }
}
