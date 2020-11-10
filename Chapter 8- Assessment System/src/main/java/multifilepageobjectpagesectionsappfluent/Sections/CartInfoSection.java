package multifilepageobjectpagesectionsappfluent.Sections;

import core.Element;
import core.interfaces.ElementFindService;

public class CartInfoSection {
    private final ElementFindService _elementFindService;

    public CartInfoSection(ElementFindService elementFindService) {
        _elementFindService = elementFindService;
    }

    private Element cartIcon() {
        return _elementFindService.findByClass("cart-contents");
    }

    private Element cartAmount() {
        return _elementFindService.findByClass("amount");
    }

    public String getCurrentAmount()
    {
        return cartAmount().getText();
    }

    public void openCart()
    {
        cartIcon().click();
    }
}
