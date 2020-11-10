package multifilepageobjectpagesectionsappfluent.MainPage;

import core.Element;
import core.interfaces.ElementFindService;

public class MainPageElements {
    private final ElementFindService _elementFindService;

    public MainPageElements(ElementFindService elementFindService) {
        _elementFindService = elementFindService;
    }

    public Element addToCartFalcon9() {
        return _elementFindService.findByCss("[data-product_id*='28']");
    }

    public Element viewCartButton() {
        return _elementFindService.findByCss("[class*='added_to_cart wc-forward']");
    }

    public Element getProductBoxByName(String name)
    {
        return _elementFindService.findByXPath(String.format("//h2[text()='%s']/parent::a[1]", name));
    }
}
