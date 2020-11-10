package multifilepageobjectpagesectionsappfluent.Sections;

import core.Element;
import core.interfaces.ElementFindService;

public class BreadcrumbSection {
    private final ElementFindService _elementFindService;

    public BreadcrumbSection(ElementFindService elementFindService) {
        _elementFindService = elementFindService;
    }

    private Element breadcrumb() {
        return _elementFindService.findByClass("woocommerce-breadcrumb");
    }

    public void openBreadcrumbItem(String itemToOpen)
    {
        breadcrumb().findByLinkText(itemToOpen).click();
    }
}
