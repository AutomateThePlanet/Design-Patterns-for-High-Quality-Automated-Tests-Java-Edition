package pages.v10.multifilepageobjectpagesectionsappfluent.Sections;

import core.Element;
import core.interfaces.ElementFindService;
import org.openqa.selenium.By;

public class BreadcrumbSection {
    private final ElementFindService _elementFindService;

    public BreadcrumbSection(ElementFindService elementFindService) {
        _elementFindService = elementFindService;
    }

    private Element breadcrumb() {
        return _elementFindService.findElement(By.className("woocommerce-breadcrumb"));
    }

    public void openBreadcrumbItem(String itemToOpen)
    {
        breadcrumb().findElement(By.linkText(itemToOpen)).click();
    }
}
